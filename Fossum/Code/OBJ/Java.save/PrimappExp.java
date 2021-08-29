import java.util.*;
//PrimappExp:import//

// <exp>:PrimappExp ::= <prim> LPAREN <rands> RPAREN
public class PrimappExp extends Exp {

    public Prim prim;
    public Rands rands;

    public PrimappExp(Prim prim, Rands rands) {
        this.prim = prim;
        this.rands = rands;
    }

    public static PrimappExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:PrimappExp", scn$.lno);
        Prim prim = Prim.parse(scn$, trace$);
        scn$.match(Token.Val.LPAREN, trace$);
        Rands rands = Rands.parse(scn$, trace$);
        scn$.match(Token.Val.RPAREN, trace$);
        return new PrimappExp(prim, rands);
    }


    public String toString() {
        return prim.toString()+ "(" + rands + ")";
    }

    public Val eval(Env env) {
        // evaluate the terms in the expression list
        // and apply the prim to the array of integer results
        List<Val> valList = rands.evalRands(env);
        Val [] va = Val.toArray(valList);
        return prim.apply(va);
    }

//PrimappExp//

}
