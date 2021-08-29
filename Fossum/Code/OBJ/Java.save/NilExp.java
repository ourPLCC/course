import java.util.*;
//NilExp:import//

// <exp>:NilExp ::= NIL
public class NilExp extends Exp {



    public NilExp() {

    }

    public static NilExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:NilExp", scn$.lno);
        scn$.match(Token.Val.NIL, trace$);
        return new NilExp();
    }

    public Val eval(Env env) {
        return Val.nil;
    }

//NilExp//

}
