//Prim:top//
//Prim:import//
import java.util.*;

public abstract class Prim {

    public static Prim parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case OBJECTP:
            return ObjectpPrim.parse(scn$,trace$);
        case LEP:
            return LEPrim.parse(scn$,trace$);
        case ADD1OP:
            return Add1Prim.parse(scn$,trace$);
        case SUB1OP:
            return Sub1Prim.parse(scn$,trace$);
        case ADDFIRSTOP:
            return AddFirstPrim.parse(scn$,trace$);
        case SUBOP:
            return SubPrim.parse(scn$,trace$);
        case GEP:
            return GEPrim.parse(scn$,trace$);
        case ZEROP:
            return ZeropPrim.parse(scn$,trace$);
        case NEP:
            return NEPrim.parse(scn$,trace$);
        case LENOP:
            return LenPrim.parse(scn$,trace$);
        case DIVOP:
            return DivPrim.parse(scn$,trace$);
        case GTP:
            return GTPrim.parse(scn$,trace$);
        case ADDOP:
            return AddPrim.parse(scn$,trace$);
        case FIRSTOP:
            return FirstPrim.parse(scn$,trace$);
        case CLASSP:
            return ClasspPrim.parse(scn$,trace$);
        case EQP:
            return EQPrim.parse(scn$,trace$);
        case RESTOP:
            return RestPrim.parse(scn$,trace$);
        case LTP:
            return LTPrim.parse(scn$,trace$);
        case MULOP:
            return MulPrim.parse(scn$,trace$);
        case LISTP:
            return ListpPrim.parse(scn$,trace$);
        default:
            throw new RuntimeException("Prim cannot begin with " + v$);
        }
    }

    // apply the primitive to the passed values
    public abstract Val apply(Val [] va);
//Prim//

}
