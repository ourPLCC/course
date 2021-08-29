import java.util.*;
//Formals:import//

// <formals> **= <VAR> +COMMA
public class Formals {

    public List<Token> varList;

    public Formals(List<Token> varList) {
        this.varList = varList;
    }

    public static Formals parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<formals>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case VAR:
            while(true) {
                varList.add(scn$.match(Token.Val.VAR, trace$));
                t$ = scn$.cur();
                v$ = t$.val;
                if (v$ != Token.Val.COMMA)
                    break; // not a separator, so we're done
                scn$.match(v$, trace$);
            }
        } // end of switch
        return new Formals(varList);

    }

//Formals//

}
