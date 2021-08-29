//Program:top//
//Program:import//
import java.util.*;

public abstract class Program {

    public Program() { } // dummy constructor

    public static Program parse(Scan scn$, Trace trace$) {
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
            return Eval.parse(scn$,trace$);
        case DEFINE:
            return Define.parse(scn$,trace$);
        default:
            throw new RuntimeException("Program cannot begin with " + v$);
        }
    }


    public static Env initEnv = Env.initEnv();

//Program//

}
