
#include <stdio.h>

int main() {
    int x = 1;
    printf( "%d\n", (x=5*x,x) );
    return 0;
}

