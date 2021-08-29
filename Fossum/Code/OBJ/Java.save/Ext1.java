import java.util.*;
//Ext1:import//

// <ext>:Ext1 ::= EXTENDS <exp>
public class Ext1 extends Ext {

    public Exp exp;

    public Ext1(Exp exp) {
        this.exp = exp;
    }

    public static Ext1 parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<ext>:Ext1", scn$.lno);
        scn$.match(Token.Val.EXTENDS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Ext1(exp);
    }

    public ClassVal toClassVal(Env env) {
        Val v = exp.eval(env);
        return v.classVal();
    }
//Ext1//

}
