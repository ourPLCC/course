import java.util.*;
//GTPrim:import//

// <prim>:GTPrim ::= GTP
public class GTPrim extends Prim {



    public GTPrim() {

    }

    public static GTPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:GTPrim", scn$.lno);
        scn$.match(Token.Val.GTP, trace$);
        return new GTPrim();
    }

    public String toString() {
        return ">?";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 > i1 ? 1 : 0);
    }
//GTPrim//

}
