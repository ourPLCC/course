import java.util.*;
//ObjLoc:import//

// <loc>:ObjLoc ::= LANGLE <exp> RANGLE
public class ObjLoc extends Loc {

    public Exp exp;

    public ObjLoc(Exp exp) {
        this.exp = exp;
    }

    public static ObjLoc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<loc>:ObjLoc", scn$.lno);
        scn$.match(Token.Val.LANGLE, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        scn$.match(Token.Val.RANGLE, trace$);
        return new ObjLoc(exp);
    }

    public Env getEnv(Env env) {
        Val v = exp.eval(env);
        return v.env();
    }
//ObjLoc//

}
