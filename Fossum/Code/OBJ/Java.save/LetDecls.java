import java.util.*;
//LetDecls:import//

// <letDecls> **= <VAR> EQUALS <exp>
public class LetDecls {

    public List<Token> varList;
    public List<Exp> expList;

    public LetDecls(List<Token> varList, List<Exp> expList) {
        this.varList = varList;
        this.expList = expList;
    }

    public static LetDecls parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<letDecls>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case VAR:
                varList.add(scn$.match(Token.Val.VAR, trace$));
                scn$.match(Token.Val.EQUALS, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new LetDecls(varList, expList);
            }
        }

    }

    public Env addBindings(Env env) {
        Rands rands = new Rands(expList);
        List<Val> valList = rands.evalRands(env);
        List<Ref> refList = Ref.valsToRefs(valList);
        Bindings bindings = new Bindings(varList, refList);
        return env.extendEnvRef(bindings);
    }

    public String toString() {
        return " ...LetDecls... ";
    }
//LetDecls//

}
