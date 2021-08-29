import java.util.*;
//SubPrim:import//

// <prim>:SubPrim ::= SUBOP
public class SubPrim extends Prim {



    public SubPrim() {

    }

    public static SubPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:SubPrim", scn$.lno);
        scn$.match(Token.Val.SUBOP, trace$);
        return new SubPrim();
    }


    public String toString() {
        return "-";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 - i1);
    }
//SubPrim//

}
