import java.util.*;
//SimpleLoc:import//

// <loc>:SimpleLoc ::= 
public class SimpleLoc extends Loc {



    public SimpleLoc() {

    }

    public static SimpleLoc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<loc>:SimpleLoc", scn$.lno);
        return new SimpleLoc();
    }

    public Env getEnv(Env env) {
        return env;
    }
//SimpleLoc//

}
