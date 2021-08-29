import java.util.*;
//EenvExp:import//

// <exp>:EenvExp ::= LLANGLE <exp> <mangle> RRANGLE
public class EenvExp extends Exp {

    public Exp exp;
    public Mangle mangle;

    public EenvExp(Exp exp, Mangle mangle) {
        this.exp = exp;
        this.mangle = mangle;
    }

    public static EenvExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:EenvExp", scn$.lno);
        scn$.match(Token.Val.LLANGLE, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        Mangle mangle = Mangle.parse(scn$, trace$);
        scn$.match(Token.Val.RRANGLE, trace$);
        return new EenvExp(exp, mangle);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);      // the environment object
        return mangle.eval(v, env);
    }
//EenvExp//

}
