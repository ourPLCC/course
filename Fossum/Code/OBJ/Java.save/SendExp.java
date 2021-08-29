import java.util.*;
//SendExp:import//

// <exp>:SendExp ::= SEND <exp>objExp <exp>procExp LPAREN <rands> RPAREN
public class SendExp extends Exp {

    public Exp objExp;
    public Exp procExp;
    public Rands rands;

    public SendExp(Exp objExp, Exp procExp, Rands rands) {
        this.objExp = objExp;
        this.procExp = procExp;
        this.rands = rands;
    }

    public static SendExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:SendExp", scn$.lno);
        scn$.match(Token.Val.SEND, trace$);
        Exp objExp = Exp.parse(scn$, trace$);
        Exp procExp = Exp.parse(scn$, trace$);
        scn$.match(Token.Val.LPAREN, trace$);
        Rands rands = Rands.parse(scn$, trace$);
        scn$.match(Token.Val.RPAREN, trace$);
        return new SendExp(objExp, procExp, rands);
    }


    public Val eval(Env env) {
        Val v = objExp.eval(env);
        Val p = procExp.eval(v.env()); // in the object env
        List<Val> valList = rands.evalRands(env); // in calling env
        return p.apply(valList);
    }

    public String toString() {
        return " ...SendExp... ";
    }

//SendExp//

}
