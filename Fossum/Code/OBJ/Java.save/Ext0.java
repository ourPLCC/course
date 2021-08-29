import java.util.*;
//Ext0:import//

// <ext>:Ext0 ::= 
public class Ext0 extends Ext {



    public Ext0() {

    }

    public static Ext0 parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<ext>:Ext0", scn$.lno);
        return new Ext0();
    }


    public ClassVal toClassVal(Env env) {
        return EnvClass.envClass; // a singleton
    }

//Ext0//

}
