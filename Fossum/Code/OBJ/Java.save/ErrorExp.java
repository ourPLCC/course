import java.util.*;
//ErrorExp:import//

// <exp>:ErrorExp ::= ERROR <exp>
public class ErrorExp extends Exp {

    public Exp exp;

    public ErrorExp(Exp exp) {
        this.exp = exp;
    }

    public static ErrorExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ErrorExp", scn$.lno);
        scn$.match(Token.Val.ERROR, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new ErrorExp(exp);
    }

    public Val eval(Env env) {
        Val val = exp.eval(env);
        throw new RuntimeException("error: " + val);
    }
//ErrorExp//

}
