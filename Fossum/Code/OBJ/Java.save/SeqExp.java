import java.util.*;
//SeqExp:import//

// <exp>:SeqExp ::= LBRACE <exp> <seqExps> RBRACE
public class SeqExp extends Exp {

    public Exp exp;
    public SeqExps seqExps;

    public SeqExp(Exp exp, SeqExps seqExps) {
        this.exp = exp;
        this.seqExps = seqExps;
    }

    public static SeqExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:SeqExp", scn$.lno);
        scn$.match(Token.Val.LBRACE, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        SeqExps seqExps = SeqExps.parse(scn$, trace$);
        scn$.match(Token.Val.RBRACE, trace$);
        return new SeqExp(exp, seqExps);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        for (Exp e : seqExps.expList)
            v = e.eval(env);
        return v;
    }

    public String toString() {
        return " ...SeqExp... ";
    }

//SeqExp//

}
