import java.util.*;
//Define:import//

// <program>:Define ::= DEFINE <VAR> EQUALS <exp>
public class Define extends Program {

    public Token var;
    public Exp exp;

    public Define(Token var, Exp exp) {
        this.var = var;
        this.exp = exp;
    }

    public static Define parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Define", scn$.lno);
        scn$.match(Token.Val.DEFINE, trace$);
        Token var = scn$.match(Token.Val.VAR, trace$);
        scn$.match(Token.Val.EQUALS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Define(var, exp);
    }

    // notice that calling toString triggers a modification
    // of the initial environment
    public String toString() {
        String id = var.toString();
        Val val = exp.eval(initEnv);
        initEnv.addFirst(new Binding(id, new ValRef(val)));
        return id; // return *something*
    }
//Define//

}
