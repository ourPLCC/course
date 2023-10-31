/*
 * prodcon1.c
 */

#include <stdio.h>
#include <setjmp.h>

void producer( jmp_buf *my_buf_ptr, jmp_buf *c_buf_ptr ) {
    int phase;
    int count;
    for ( int i=1; i<=8; ++i ) {
        phase = setjmp( *my_buf_ptr );
        if ( phase ) {
            printf( "Producer: %d.\n", phase );
        }
        else {
            printf( "Jumping to Consumer\n" );
            longjmp( *c_buf_ptr, i );
        }
    }
}

void consumer( jmp_buf *my_buf_ptr, jmp_buf *p_buf_ptr ) {
    int phase;
    while( 1 ) {
        phase = setjmp( *my_buf_ptr );
        if ( phase ) {
            printf( "Consumer: %d.\n", phase );
        }
        else {
            printf( "Jumping to Producer\n" );
            longjmp( *p_buf_ptr, 1 );
        }
    }
}

static jmp_buf p_jump, c_jump;

int main() {

    int phase = setjmp( p_jump );
    if ( phase ) {
        producer( &p_jump, &c_jump );
    }
    else {
        consumer( &c_jump, &p_jump );
    }

    return 0;
}

