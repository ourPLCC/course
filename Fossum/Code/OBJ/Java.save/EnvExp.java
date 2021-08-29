import java.util.*;
//EnvExp:import//

// <exp>:EnvExp ::= LANGLE <exp>vExp RANGLE <exp>eExp
public class EnvExp extends Exp {

    public Exp vExp;
    public Exp eExp;

    public EnvExp(Exp vExp, Exp eExp) {
        this.vExp = vExp;
        this.eExp = eExp;
    }

    public static EnvExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:EnvExp", scn$.lno);
        scn$.match(Token.Val.LANGLE, trace$);
        Exp vExp = Exp.parse(scn$, trace$);
        scn$.match(Token.Val.RANGLE, trace$);
        Exp eExp = Exp.parse(scn$, trace$);
        return new EnvExp(vExp, eExp);
    }

    public Val eval(Env env) {
        Val v = vExp.eval(env);
        return eExp.eval(v.env());
    }

//EnvExp//

}
