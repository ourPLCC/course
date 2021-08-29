import java.util.*;
//ProcExp:import//

// <exp>:ProcExp ::= <proc>
public class ProcExp extends Exp {

    public Proc proc;

    public ProcExp(Proc proc) {
        this.proc = proc;
    }

    public static ProcExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ProcExp", scn$.lno);
        Proc proc = Proc.parse(scn$, trace$);
        return new ProcExp(proc);
    }

    public Val eval(Env env) {
        return proc.makeClosure(env);
    }

    public String toString() {
        return " ...ProcExp... ";
    }
//ProcExp//

}
