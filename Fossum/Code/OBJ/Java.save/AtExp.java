import java.util.*;
//AtExp:import//

// <exp>:AtExp ::= AT
public class AtExp extends Exp {



    public AtExp() {

    }

    public static AtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:AtExp", scn$.lno);
        scn$.match(Token.Val.AT, trace$);
        return new AtExp();
    }

    public Val eval(Env env) {
        return new ObjectVal(env);
    }

//AtExp//

}
