#include <iostream>

using std::cout;
using std::endl;

void increment_min( int &a, int &b ) {
    if ( a <= b ) {
        a += 1;
    }
    else {
        b += 1;
    }
}

int main() {
    int u = 3;
    int v = 7;
    increment_min( u, v );
    cout << u << ", " << v << endl;

    // cout << "increment_min(12,15)" << endl;
    // increment_min( 12, 15 );

    return 0;
}
