/*
 * prodcon2.c
 */

#include <stdio.h>
#include <setjmp.h>

static jmp_buf p_jump, c_jump;

int main() {

    int phase = setjmp( p_jump );
    if ( phase ) {
        for ( int i=1; i<9; ++i ) {
            phase = setjmp( p_jump );
            if ( phase ) {
                printf( "Producer is alive.\n" );
            }
            else {
                printf( "Producer is going to Consumer.\n" );
                longjmp( c_jump, i );
            }
        }
    }
    else {
        while( 1 ) {
            phase = setjmp( c_jump );
            if ( phase ) {
                printf( "\t\tConsumer got %d.\n", phase );
            }
            else {
                printf( "\t\tConsumer is going to Producer.\n" );
                longjmp( p_jump, 1 );
            }
        }
    }

    return 0;
}

