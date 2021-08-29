import java.util.*;
//SeqExps:import//

// <seqExps> **= SEMI <exp>
public class SeqExps {

    public List<Exp> expList;

    public SeqExps(List<Exp> expList) {
        this.expList = expList;
    }

    public static SeqExps parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<seqExps>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case SEMI:
                scn$.match(Token.Val.SEMI, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new SeqExps(expList);
            }
        }

    }

//SeqExps//

}
