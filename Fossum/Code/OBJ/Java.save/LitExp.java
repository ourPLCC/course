import java.util.*;
//LitExp:import//

// <exp>:LitExp ::= <LIT>
public class LitExp extends Exp {

    public Token lit;

    public LitExp(Token lit) {
        this.lit = lit;
    }

    public static LitExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:LitExp", scn$.lno);
        Token lit = scn$.match(Token.Val.LIT, trace$);
        return new LitExp(lit);
    }


    public Val eval(Env env) {
        return new IntVal(lit.toString());
    }

    public String toString() {
        return lit.toString();
    }

//LitExp//

}
