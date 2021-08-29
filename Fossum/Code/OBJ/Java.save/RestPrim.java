import java.util.*;
//RestPrim:import//

// <prim>:RestPrim ::= RESTOP
public class RestPrim extends Prim {



    public RestPrim() {

    }

    public static RestPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:RestPrim", scn$.lno);
        scn$.match(Token.Val.RESTOP, trace$);
        return new RestPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new RuntimeException("one argument expected");
        ListNode lst = va[0].listNode();
        return lst.listVal;
    }
//RestPrim//

}
