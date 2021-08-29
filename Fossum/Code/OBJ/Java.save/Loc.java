//Loc:top//
//Loc:import//
import java.util.*;

public abstract class Loc {

    public static Loc parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case VAR:
            return SimpleLoc.parse(scn$,trace$);
        case LANGLE:
            return ObjLoc.parse(scn$,trace$);
        default:
            throw new RuntimeException("Loc cannot begin with " + v$);
        }
    }

    public abstract Env getEnv(Env env);
//Loc//

}
