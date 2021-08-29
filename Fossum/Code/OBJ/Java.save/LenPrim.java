import java.util.*;
//LenPrim:import//

// <prim>:LenPrim ::= LENOP
public class LenPrim extends Prim {



    public LenPrim() {

    }

    public static LenPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:LenPrim", scn$.lno);
        scn$.match(Token.Val.LENOP, trace$);
        return new LenPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new RuntimeException("one argument expected");
        ListVal lst = va[0].listVal();
        return new IntVal(lst.len());
    }

//LenPrim//

}
