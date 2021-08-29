import java.util.*;
//Interior:import//

// <tree>:Interior ::= LPAREN <SYMBOL> <tree>left <tree>right RPAREN
public class Interior extends Tree {

    public Token symbol;
    public Tree left;
    public Tree right;

    public Interior(Token symbol, Tree left, Tree right) {
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    public static Interior parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<tree>:Interior", scn$.lno);
        scn$.match(Token.Val.LPAREN, trace$);
        Token symbol = scn$.match(Token.Val.SYMBOL, trace$);
        Tree left = Tree.parse(scn$, trace$);
        Tree right = Tree.parse(scn$, trace$);
        scn$.match(Token.Val.RPAREN, trace$);
        return new Interior(symbol, left, right);
    }

    public int countInterior() {
        return 1 + left.countInterior() + right.countInterior();
    }

    public int sumLeaves() {
        return left.sumLeaves() + right.sumLeaves();
    }


}
