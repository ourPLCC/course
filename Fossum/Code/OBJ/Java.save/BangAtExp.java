import java.util.*;
//BangAtExp:import//

// <exp>:BangAtExp ::= BANGAT
public class BangAtExp extends Exp {



    public BangAtExp() {

    }

    public static BangAtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:BangAtExp", scn$.lno);
        scn$.match(Token.Val.BANGAT, trace$);
        return new BangAtExp();
    }

    public Val eval(Env env) {
        return env.applyEnv("!@");
    }
//BangAtExp//

}
