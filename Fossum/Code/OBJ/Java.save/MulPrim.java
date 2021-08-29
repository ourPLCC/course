import java.util.*;
//MulPrim:import//

// <prim>:MulPrim ::= MULOP
public class MulPrim extends Prim {



    public MulPrim() {

    }

    public static MulPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:MulPrim", scn$.lno);
        scn$.match(Token.Val.MULOP, trace$);
        return new MulPrim();
    }


    public String toString() {
        return "*";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 * i1);
    }

//MulPrim//

}
