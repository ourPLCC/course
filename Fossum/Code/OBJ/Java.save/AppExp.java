import java.util.*;
//AppExp:import//

// <exp>:AppExp ::= DOT <exp> LPAREN <rands> RPAREN
public class AppExp extends Exp {

    public Exp exp;
    public Rands rands;

    public AppExp(Exp exp, Rands rands) {
        this.exp = exp;
        this.rands = rands;
    }

    public static AppExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:AppExp", scn$.lno);
        scn$.match(Token.Val.DOT, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        scn$.match(Token.Val.LPAREN, trace$);
        Rands rands = Rands.parse(scn$, trace$);
        scn$.match(Token.Val.RPAREN, trace$);
        return new AppExp(exp, rands);
    }


    public Val eval(Env env) {
        Val p = exp.eval(env);
        List<Val> valList = rands.evalRands(env);
        return p.apply(valList);
    }

    public String toString() {
        return " ...AppExp... ";
    }

//AppExp//

}
