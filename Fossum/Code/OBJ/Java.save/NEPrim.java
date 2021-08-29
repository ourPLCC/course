import java.util.*;
//NEPrim:import//

// <prim>:NEPrim ::= NEP
public class NEPrim extends Prim {



    public NEPrim() {

    }

    public static NEPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:NEPrim", scn$.lno);
        scn$.match(Token.Val.NEP, trace$);
        return new NEPrim();
    }

    public String toString() {
        return "<>?";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 != i1 ? 1 : 0);
    }
//NEPrim//

}
