/**

  Missionaries and cannibals learn logic programming

  Pipe the output of this to the ABC language read-eval-print loop. The
  output will be a list of boat trips ("m" means a missionary, "mm"
  means two missionaries, etc.) to get the three missionaries and three
  cannibals across the river without "incident".

  A "state" in this solution is a string of the form

      sbmc

  where 's' is just the letter 's', 'b' is the boat side (0=left, 1=right),
  'm' is the number of missionaries on the left side, and 'c' is the
  number of cannibals on the left side.

  The minimal solution takes 11 steps. The start state is s033 (boat is
  on left side of river, with three missionaries and 3 cannibals on the
  left side). The goal state is s100 (boat is in right side of river,
  with no missionaries or cannibals on the left side).

 **/
import java.util.*;

public class MC {

    public static int B = 0; // state index of boat position (0=left, 1=right)
    public static int M = 1; // state index of missionaries on left
    public static int C = 2; // state index of cannibals on left

    public static boolean safe(int [] state) {
        int sum = state[B] + state[M] + state[C];
        if (sum == 0 || sum == 7) {
            // boat on left and all MCs are on right
            // or boat on right and all MCs are on left
            return true;
        }
        if (state[M] == 3 || state[M] == 0 || state[M] == state[C])
            return true;
        return false;
    }

    public static void printState(int [] state) {
        System.out.print("s");
        System.out.print(state[B]);
        System.out.print((char)('0'+state[M]));
        System.out.print((char)('0'+state[C]));
    }

    // cross from the given state using one or two passengers specified by
    // the passenger string (one of: m, mm, c, cc, or mc)
    public static void cross(int [] state, String mc) {
        int len = mc.length();
        assert len >= 1 && len <= 2;
        int [] newState = new int[3];
        for (int i=1 ; i<3 ; ++i) {
            newState[i] = state[i];
        }
        assert state[B] == 0; // assume boat is on left side
        newState[B] = 1;      // boat will end on right side after crossing
        if (mc.equals("mc")) {
            // one missionary, one cannibal
            if (state[M] == 0 || state[C] == 0)
                return;
            --newState[M];
            --newState[C];
        } else {
            int pass;
            if (mc.charAt(0) == 'm') {
                // one (len == 1) or two (len == 2) missionaries
                pass = M;
            } else if (mc.charAt(0) == 'c') {
                // one (len == 1) or two (len == 2) cannibals
                pass = C;
            } else {
                throw new RuntimeException("whoops!");
            }
            if (state[pass] < len) {
                return; // not enough to satisfy the crossing
            }
            newState[pass] = state[pass] - len; // len = how many to move
        }
        if (safe(newState)) {
            // can only cross to a safe state
            System.out.print("cross(");
            printState(state);
            System.out.format(",%s,", mc);
            printState(newState);
            System.out.println(").");
        }
    }

    public static void crossings() {
        for (int m=3 ; m>=0 ; --m) {
            for (int c=3 ; c>=0 ; --c) {
                int [] state = new int[3];
                state[B] = 0;
                state[M] = m;
                state[C] = c;
                if (safe(state)) {
                    cross(state, "m");
                    cross(state, "mm");
                    cross(state, "c");
                    cross(state, "cc");
                    cross(state, "mc");
                }
            }
        }
    }

    public static void main(String [] args) {
        crossings(); // print all of the left-to-right crossings
        System.out.println("cross(X,P,Y) :- cross(Y,P,X).");
        System.out.println("path(X,Y) :- cross(X,_,Y).");
        System.out.println("path(X,Z) :- path(X, Y), cross(Y,_,Z).");
        System.out.println("m1(X,P1,Z) :- cross(X,P1,Z).");
        for (int i=2 ; i<=11 ; ++i) {
            System.out.format("m%d(X", i);
            for (int j=1 ; j<=i ; ++j)
                System.out.format(",P%d", j);
            System.out.format(",Z) :- m%d(X", i-1);
            for (int j=1 ; j<i ; ++j)
                System.out.format(",P%d", j);
            System.out.format(",Y), cross(Y,P%d,Z).", i);
            System.out.println();
        }
        System.out.println("m11(s033,P,Q,R,S,T,U,V,W,X,Y,Z,s100)?");
    }

}
