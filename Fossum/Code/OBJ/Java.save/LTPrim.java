import java.util.*;
//LTPrim:import//

// <prim>:LTPrim ::= LTP
public class LTPrim extends Prim {



    public LTPrim() {

    }

    public static LTPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:LTPrim", scn$.lno);
        scn$.match(Token.Val.LTP, trace$);
        return new LTPrim();
    }

    public String toString() {
        return "<?";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 < i1 ? 1 : 0);
    }
//LTPrim//

}
