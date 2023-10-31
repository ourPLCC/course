/*
 * long-jump.c
 */

#include <setjmp.h>
#include <stdio.h>

void call_me( jmp_buf cont ) {
    printf( "Entering call_me function.\n" );
    printf( "Attempting warp back to save point.\n" );
    longjmp( cont, 99 );
    printf( "If you see this, warp has failed. :-(\n" );
}

int main() {

    printf( "Entering main function.\n" );

    jmp_buf cont;
    int what = setjmp( cont );
    if ( what ) {
        printf( "Warped back here! Value sent was %d.\n", what );
    }
    else {
        printf( "Jump buffer is set up.\n" );
        call_me( cont );
    }

    return 0;
}

