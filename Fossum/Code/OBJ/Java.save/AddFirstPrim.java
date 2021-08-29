import java.util.*;
//AddFirstPrim:import//

// <prim>:AddFirstPrim ::= ADDFIRSTOP
public class AddFirstPrim extends Prim {



    public AddFirstPrim() {

    }

    public static AddFirstPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:AddFirstPrim", scn$.lno);
        scn$.match(Token.Val.ADDFIRSTOP, trace$);
        return new AddFirstPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        Val v = va[0];
        ListVal lst = va[1].listVal();
        return new ListNode(v, lst);
    }
//AddFirstPrim//

}
