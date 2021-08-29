import java.util.*;
//Display1Exp:import//

// <exp>:Display1Exp ::= DISPLAY1 <exp>
public class Display1Exp extends Exp {

    public Exp exp;

    public Display1Exp(Exp exp) {
        this.exp = exp;
    }

    public static Display1Exp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:Display1Exp", scn$.lno);
        scn$.match(Token.Val.DISPLAY1, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Display1Exp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v+" ");
        return v;
    }

//Display1Exp//

}
