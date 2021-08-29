//Exp:top//
//Exp:import//
import java.util.*;

public abstract class Exp {

    public static Exp parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case LBRACK:
            return ListExp.parse(scn$,trace$);
        case WITH:
            return WithExp.parse(scn$,trace$);
        case SEND:
            return SendExp.parse(scn$,trace$);
        case CHR:
            return ChrExp.parse(scn$,trace$);
        case EXIT:
            return ExitExp.parse(scn$,trace$);
        case IF:
            return IfExp.parse(scn$,trace$);
        case AT:
            return AtExp.parse(scn$,trace$);
        case DISPLAY:
            return DisplayExp.parse(scn$,trace$);
        case LLANGLE:
            return EenvExp.parse(scn$,trace$);
        case LET:
            return LetExp.parse(scn$,trace$);
        case DOT:
            return AppExp.parse(scn$,trace$);
        case LBRACE:
            return SeqExp.parse(scn$,trace$);
        case DISPLAY1:
            return Display1Exp.parse(scn$,trace$);
        case NEWLINE:
            return NewlineExp.parse(scn$,trace$);
        case BANGAT:
            return BangAtExp.parse(scn$,trace$);
        case VAR:
            return VarExp.parse(scn$,trace$);
        case LANGLE:
            return EnvExp.parse(scn$,trace$);
        case ATAT:
            return AtAtExp.parse(scn$,trace$);
        case NIL:
            return NilExp.parse(scn$,trace$);
        case NEW:
            return NewExp.parse(scn$,trace$);
        case CLASS:
            return ClassExp.parse(scn$,trace$);
        case PUTC:
            return PutcExp.parse(scn$,trace$);
        case STRNG:
            return StrngExp.parse(scn$,trace$);
        case ERROR:
            return ErrorExp.parse(scn$,trace$);
        case LIT:
            return LitExp.parse(scn$,trace$);
        case EQP:
        case LEP:
        case LENOP:
        case GEP:
        case ADDFIRSTOP:
        case CLASSP:
        case MULOP:
        case SUB1OP:
        case NEP:
        case LISTP:
        case RESTOP:
        case ZEROP:
        case FIRSTOP:
        case SUBOP:
        case GTP:
        case OBJECTP:
        case DIVOP:
        case LTP:
        case ADDOP:
        case ADD1OP:
            return PrimappExp.parse(scn$,trace$);
        case SET:
            return SetExp.parse(scn$,trace$);
        case PERROR:
            return PerrorExp.parse(scn$,trace$);
        case PROC:
            return ProcExp.parse(scn$,trace$);
        case LETREC:
            return LetrecExp.parse(scn$,trace$);
        default:
            throw new RuntimeException("Exp cannot begin with " + v$);
        }
    }

    public abstract Val eval(Env env);
//Exp//

}
