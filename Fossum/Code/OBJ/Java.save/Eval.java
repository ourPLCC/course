import java.util.*;
//Eval:import//

// <program>:Eval ::= <exp>
public class Eval extends Program {

    public Exp exp;

    public Eval(Exp exp) {
        this.exp = exp;
    }

    public static Eval parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Eval", scn$.lno);
        Exp exp = Exp.parse(scn$, trace$);
        return new Eval(exp);
    }

    public String toString() {
        return exp.eval(initEnv).toString();
    }
//Eval//

}
