import java.util.*;
//DivPrim:import//

// <prim>:DivPrim ::= DIVOP
public class DivPrim extends Prim {



    public DivPrim() {

    }

    public static DivPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:DivPrim", scn$.lno);
        scn$.match(Token.Val.DIVOP, trace$);
        return new DivPrim();
    }


    public String toString() {
        return "/";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        if (i1 == 0)
            throw new RuntimeException("attempt to divide by zero");
        return new IntVal(i0 / i1);
    }

//DivPrim//

}
