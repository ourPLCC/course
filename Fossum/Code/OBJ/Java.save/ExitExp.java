import java.util.*;
//ExitExp:import//

// <exp>:ExitExp ::= EXIT
public class ExitExp extends Exp {



    public ExitExp() {

    }

    public static ExitExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ExitExp", scn$.lno);
        scn$.match(Token.Val.EXIT, trace$);
        return new ExitExp();
    }

    public Val eval(Env env) {
        throw new RuntimeException("...exiting...");
    }
//ExitExp//

}
