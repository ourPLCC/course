import java.util.*;
//AtAtExp:import//

// <exp>:AtAtExp ::= ATAT
public class AtAtExp extends Exp {



    public AtAtExp() {

    }

    public static AtAtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:AtAtExp", scn$.lno);
        scn$.match(Token.Val.ATAT, trace$);
        return new AtAtExp();
    }

    public Val eval(Env env) {
        System.out.println(env.toString());
        return new ObjectVal(env);
    }
//AtAtExp//

}
