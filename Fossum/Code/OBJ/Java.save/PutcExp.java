import java.util.*;
//PutcExp:import//

// <exp>:PutcExp ::= PUTC <exp>
public class PutcExp extends Exp {

    public Exp exp;

    public PutcExp(Exp exp) {
        this.exp = exp;
    }

    public static PutcExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:PutcExp", scn$.lno);
        scn$.match(Token.Val.PUTC, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new PutcExp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v.putc());
        return Val.nil;
    }
//PutcExp//

}
