public class FGC {

    static int B = 3; // boat side
    static int F = 2; // fox
    static int G = 1; // goose
    static int C = 0; // corn
    static char [] cgf = {'c', 'g', 'f'};

    public static boolean safe(int [] state) {
        int side = state[B]; // 0=left, 1=right
        int other = 1 - side;
        if (state[F] == other && state[G] == other)
            return false;
        if (state[G] == other && state[C] == other)
            return false;
        return true;
    }

    public static void populate(int [] state, int val) {
        state[3] = 0;
        for (int j=0 ; j<3 ; ++j) {
            state[j] = val % 2;
            val /= 2;
        }
    }

    public static void print(int [] state) {
        System.out.print("s");
        for (int j=0 ; j<4 ; ++j) {
            System.out.print(state[3-j]);
        }
    }

    public static void printXing(int [] state, char pass, int [] newState) {
        System.out.print("cross(");
        print(state);
        System.out.format(",%c,", pass);
        print(newState);
        System.out.println(").");
    }

    public static void cross(int [] state) {
        int [] newState = new int [4];
        int side = state[B];
        int other = 1 - side;
        newState[B] = other;
        for (int j=0 ; j<3 ; ++j)
            newState[j] = state[j]; // copy the state
        if (safe(newState)) {
            printXing(state, 'x', newState);
        }
        for (int i=0 ; i<B ; ++i) {
            for (int j=0 ; j<3 ; ++j)
                newState[j] = state[j]; // copy the state
            if (state[i] == side) {
                newState[i] = other;
                if (safe(newState)) {
                    printXing(state, cgf[i], newState);
                }
            }
        }
    }

    public static void main(String [] args) {
        int [] state = new int[4];
        for (int i=0 ; i<8 ; ++i) {
            populate(state, i);
            // print(state);
            if (safe(state))
                cross(state);
        }
        System.out.println("cross(X,P,Y) :- cross(Y,P,X).");
        // System.out.println("state(B) :- cross(B,_,_).");
        // System.out.println("state(B) :- cross(_,_,B).");
        System.out.println("path(X,Y) :- cross(X,_,Y).");
        // System.out.println("path(X,Z) :- state(Y),path(X,Y),cross(Y,_,Z).");
        System.out.println("path(X,Z) :- path(X,Y),cross(Y,_,Z).");
        System.out.println("m1(X,P1,Z) :- cross(X,P1,Z).");
        for (int i=2 ; i<=7 ; ++i) {
            System.out.format("m%d(X", i);
            for (int j=1 ; j<=i ; ++j)
                System.out.format(",P%d", j);
            System.out.format(",Z) :- m%d(X", i-1);
            for (int j=1 ; j<i ; ++j)
                System.out.format(",P%d", j);
            System.out.format(",Y), cross(Y,P%d,Z).", i);
            System.out.println();
        }
        System.out.println("m7(s0000,P,Q,R,S,T,U,V,s1111)?");
    }

}
