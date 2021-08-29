import java.util.*;
//DisplayExp:import//

// <exp>:DisplayExp ::= DISPLAY <exp>
public class DisplayExp extends Exp {

    public Exp exp;

    public DisplayExp(Exp exp) {
        this.exp = exp;
    }

    public static DisplayExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:DisplayExp", scn$.lno);
        scn$.match(Token.Val.DISPLAY, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new DisplayExp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v);
        return v;
    }

//DisplayExp//

}
