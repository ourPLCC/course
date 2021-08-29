import java.util.*;
//Proc:import//

// <proc> ::= PROC LPAREN <formals> RPAREN <exp>
public class Proc {

    public Formals formals;
    public Exp exp;

    public Proc(Formals formals, Exp exp) {
        this.formals = formals;
        this.exp = exp;
    }

    public static Proc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<proc>", scn$.lno);
        scn$.match(Token.Val.PROC, trace$);
        scn$.match(Token.Val.LPAREN, trace$);
        Formals formals = Formals.parse(scn$, trace$);
        scn$.match(Token.Val.RPAREN, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Proc(formals, exp);
    }

    public Val makeClosure(Env env) {
        return new ProcVal(formals, exp, env);
    }

//Proc//

}
