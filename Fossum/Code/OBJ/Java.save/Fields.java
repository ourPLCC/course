import java.util.*;
//Fields:import//

// <fields> **= FIELD <VAR>
public class Fields {

    public List<Token> varList;

    public Fields(List<Token> varList) {
        this.varList = varList;
    }

    public static Fields parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<fields>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Val v$ = t$.val;
            switch(v$) {
            case FIELD:
                scn$.match(Token.Val.FIELD, trace$);
                varList.add(scn$.match(Token.Val.VAR, trace$));
                continue;
            default:
                return new Fields(varList);
            }
        }

    }

//Fields//

}
