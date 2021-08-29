import java.util.*;
//Mangle:import//

// <mangle> **= RANGLE <exp> LPAREN <rands> RPAREN
public class Mangle {

    public List<Exp> expList;
    public List<Rands> randsList;

    public Mangle(List<Exp> expList, List<Rands> randsList) {
        this.expList = expList;
        this.randsList = randsList;
    }

    public static Mangle parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<mangle>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        List<Rands> randsList = new ArrayList<Rands>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case RANGLE:
                scn$.match(Token.Val.RANGLE, trace$);
                expList.add(Exp.parse(scn$, trace$));
                scn$.match(Token.Val.LPAREN, trace$);
                randsList.add(Rands.parse(scn$, trace$));
                scn$.match(Token.Val.RPAREN, trace$);
                continue;
            default:
                return new Mangle(expList, randsList);
            }
        }

    }

    public Val eval(Val v, Env env) {
        Iterator<Exp> expIter = expList.iterator();
        Iterator<Rands> randsIter = randsList.iterator();
        while (expIter.hasNext()) {
            // expIter.next() ProcExp to apply
            // randsIter.next() are the method rands -- evaluated in env
            // v.env() is the environment in which to build the ProcVal
            Val p = expIter.next().eval(v.env());
            List<Val> valList = randsIter.next().evalRands(env);
            v = p.apply(valList);
        }
        return v;
    }
//Mangle//

}
