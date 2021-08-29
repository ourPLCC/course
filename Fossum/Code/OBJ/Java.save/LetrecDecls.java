import java.util.*;
//LetrecDecls:import//

// <letrecDecls> **= <VAR> EQUALS <proc>
public class LetrecDecls {

    public List<Token> varList;
    public List<Proc> procList;

    public LetrecDecls(List<Token> varList, List<Proc> procList) {
        this.varList = varList;
        this.procList = procList;
    }

    public static LetrecDecls parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<letrecDecls>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Proc> procList = new ArrayList<Proc>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case VAR:
                varList.add(scn$.match(Token.Val.VAR, trace$));
                scn$.match(Token.Val.EQUALS, trace$);
                procList.add(Proc.parse(scn$, trace$));
                continue;
            default:
                return new LetrecDecls(varList, procList);
            }
        }

    }


    public Env addBindings(Env env) {
        Env nenv = env.extendEnvRef(null); // no bindings yet
        List<Val> valList = new ArrayList<Val>();
        for (Proc p : procList)
            valList.add(p.makeClosure(nenv));
        List<Ref> refList = Ref.valsToRefs(valList);
        Bindings bindings = new Bindings(varList, refList);
        nenv.replaceBindings(bindings);
        return nenv;
    }

    public Bindings toBindingsRef(Env env) {
        List<Ref> refList = new ArrayList<Ref>();
        for (Proc p : procList)
            refList.add(new ValRef(p.makeClosure(env)));
        return new Bindings(varList, refList);
    }
//LetrecDecls//

}
