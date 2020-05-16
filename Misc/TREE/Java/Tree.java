import java.util.*;
//Tree:import//

public abstract class Tree {

    public Tree() { } // dummy constructor

    public static Tree parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case NUM:
            return Leaf.parse(scn$,trace$);
        case LPAREN:
            return Interior.parse(scn$,trace$);
        default:
            throw new RuntimeException("Tree cannot begin with " + v$);
        }
    }

    public abstract int countInterior();
    public abstract int sumLeaves();

    public String toString() {
       return "this tree has " + sumLeaves() + " as the sum of its leaf nodes";
    }

}
