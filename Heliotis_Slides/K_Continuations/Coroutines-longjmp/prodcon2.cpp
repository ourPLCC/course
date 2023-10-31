/*
 * prodcon2.cpp
 * James Heliotis
 */

#include <iostream>
#include <csetjmp>

using std::cout;
using std::endl;

static jmp_buf p_jump, c_jump;

int main() {

    int phase = setjmp( p_jump );
    if ( phase ) {
        for ( int i=1; i<9; ++i ) {
            phase = setjmp( p_jump );
            if ( phase ) {
                cout << "Producer is alive." << endl;
            }
            else {
                cout << "Producer is going to Consumer." << endl;
                longjmp( c_jump, i );
            }
        }
    }
    else {
        while( 1 ) {
            phase = setjmp( c_jump );
            if ( phase ) {
                cout << "\t\tConsumer got " << phase << '.' << endl;
            }
            else {
                cout << "\t\tConsumer is going to Producer." << endl;
                longjmp( p_jump, 1 );
            }
        }
    }

    return 0;
}

