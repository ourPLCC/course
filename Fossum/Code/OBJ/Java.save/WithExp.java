import java.util.*;
//WithExp:import//

// <exp>:WithExp ::= WITH <exp>vExp EVAL <exp>eExp
public class WithExp extends Exp {

    public Exp vExp;
    public Exp eExp;

    public WithExp(Exp vExp, Exp eExp) {
        this.vExp = vExp;
        this.eExp = eExp;
    }

    public static WithExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:WithExp", scn$.lno);
        scn$.match(Token.Val.WITH, trace$);
        Exp vExp = Exp.parse(scn$, trace$);
        scn$.match(Token.Val.EVAL, trace$);
        Exp eExp = Exp.parse(scn$, trace$);
        return new WithExp(vExp, eExp);
    }

    public Val eval(Env env) {
        return new EnvExp(vExp, eExp).eval(env);
    }
//WithExp//

}
