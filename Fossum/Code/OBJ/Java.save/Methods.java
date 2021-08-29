import java.util.*;
//Methods:import//

// <methods> **= METHOD <VAR> EQUALS <proc>
public class Methods {

    public List<Token> varList;
    public List<Proc> procList;

    public Methods(List<Token> varList, List<Proc> procList) {
        this.varList = varList;
        this.procList = procList;
    }

    public static Methods parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<methods>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Proc> procList = new ArrayList<Proc>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case METHOD:
                scn$.match(Token.Val.METHOD, trace$);
                varList.add(scn$.match(Token.Val.VAR, trace$));
                scn$.match(Token.Val.EQUALS, trace$);
                procList.add(Proc.parse(scn$, trace$));
                continue;
            default:
                return new Methods(varList, procList);
            }
        }

    }

//Methods//

}
