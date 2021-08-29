import java.util.*;
//Statics:import//

// <statics> **= STATIC <VAR> EQUALS <exp>
public class Statics {

    public List<Token> varList;
    public List<Exp> expList;

    public Statics(List<Token> varList, List<Exp> expList) {
        this.varList = varList;
        this.expList = expList;
    }

    public static Statics parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<statics>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case STATIC:
                scn$.match(Token.Val.STATIC, trace$);
                varList.add(scn$.match(Token.Val.VAR, trace$));
                scn$.match(Token.Val.EQUALS, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new Statics(varList, expList);
            }
        }

    }

    // Add new bindings to the static bindings -- behaves like top-level
    // defines.
    public void addStaticBindings(Bindings staticBindings, Env staticEnv) {
        Iterator<Token> varIter = varList.iterator(); // LHS identifiers
        Iterator<Exp> expIter = expList.iterator();    // RHS expressions
        while(varIter.hasNext()) {
            Token var = varIter.next();
            String id = var.toString(); // the LHS identifier
            Exp exp = expIter.next();    // the RHS expression
            Val val = exp.eval(staticEnv);
            Binding b = new Binding(id, new ValRef(val));
            staticBindings.addFirst(b);
        }
    }
//Statics//

}
