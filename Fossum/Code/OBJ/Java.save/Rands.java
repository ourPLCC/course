import java.util.*;
//Rands:import//

// <rands> **= <exp> +COMMA
public class Rands {

    public List<Exp> expList;

    public Rands(List<Exp> expList) {
        this.expList = expList;
    }

    public static Rands parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rands>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case CHR:
        case LBRACE:
        case LENOP:
        case ADDFIRSTOP:
        case WITH:
        case MULOP:
        case NIL:
        case LISTP:
        case LETREC:
        case SEND:
        case PUTC:
        case SUBOP:
        case NEW:
        case CLASS:
        case SET:
        case VAR:
        case DIVOP:
        case IF:
        case NEWLINE:
        case ADDOP:
        case LLANGLE:
        case EQP:
        case LEP:
        case GEP:
        case CLASSP:
        case DISPLAY1:
        case SUB1OP:
        case LET:
        case BANGAT:
        case NEP:
        case RESTOP:
        case ZEROP:
        case LANGLE:
        case AT:
        case FIRSTOP:
        case PERROR:
        case ERROR:
        case STRNG:
        case GTP:
        case LIT:
        case ATAT:
        case PROC:
        case EXIT:
        case DISPLAY:
        case LTP:
        case LBRACK:
        case DOT:
        case OBJECTP:
        case ADD1OP:
            while(true) {
                expList.add(Exp.parse(scn$, trace$));
                t$ = scn$.cur();
                v$ = t$.val;
                if (v$ != Token.Val.COMMA)
                    break; // not a separator, so we're done
                scn$.match(v$, trace$);
            }
        } // end of switch
        return new Rands(expList);

    }

    public String toString() {
        String s = "";   // the string to return
        String sep = ""; // no separator for the first expression
        // get all of the expressions in the expression list
        for (Exp e : expList) {
            s += sep + e;
            sep = ",";   // commas separate the rest of the expressions
        }
        return s;
    }

    public List<Val> evalRands(Env env) {
        List<Val> valList = new ArrayList<Val>();
        for (Exp e : expList)
            valList.add(e.eval(env));
        return valList;
    }

//Rands//

}
