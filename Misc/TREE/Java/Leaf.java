import java.util.*;
//Leaf:import//

// <tree>:Leaf ::= <NUM>
public class Leaf extends Tree {

    public Token num;

    public Leaf(Token num) {
        this.num = num;
    }

    public static Leaf parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<tree>:Leaf", scn$.lno);
        Token num = scn$.match(Token.Val.NUM, trace$);
        return new Leaf(num);
    }

   public int countInterior() {
       return 0;
   }

   public int sumLeaves() {
       return Integer.parseInt(num.toString());
   }

}
