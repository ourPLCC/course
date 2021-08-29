import java.util.*;
//NewlineExp:import//

// <exp>:NewlineExp ::= NEWLINE
public class NewlineExp extends Exp {



    public NewlineExp() {

    }

    public static NewlineExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:NewlineExp", scn$.lno);
        scn$.match(Token.Val.NEWLINE, trace$);
        return new NewlineExp();
    }

    public Val eval(Env env) {
        System.out.println();
        return Val.nil;
    }

//NewlineExp//

}
