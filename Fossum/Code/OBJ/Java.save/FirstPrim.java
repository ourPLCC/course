import java.util.*;
//FirstPrim:import//

// <prim>:FirstPrim ::= FIRSTOP
public class FirstPrim extends Prim {



    public FirstPrim() {

    }

    public static FirstPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:FirstPrim", scn$.lno);
        scn$.match(Token.Val.FIRSTOP, trace$);
        return new FirstPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new RuntimeException("one argument expected");
        ListNode lst = va[0].listNode();
        return lst.val;
    }
//FirstPrim//

}
