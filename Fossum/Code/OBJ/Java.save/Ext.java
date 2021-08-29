//Ext:top//
//Ext:import//
import java.util.*;

public abstract class Ext {

    public static Ext parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Val v$ = t$.val;
        switch(v$) {
        case STATIC:
        case END:
        case METHOD:
        case FIELD:
            return Ext0.parse(scn$,trace$);
        case EXTENDS:
            return Ext1.parse(scn$,trace$);
        default:
            throw new RuntimeException("Ext cannot begin with " + v$);
        }
    }

    public abstract ClassVal toClassVal(Env env);
//Ext//

}
