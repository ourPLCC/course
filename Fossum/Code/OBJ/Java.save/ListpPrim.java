import java.util.*;
//ListpPrim:import//

// <prim>:ListpPrim ::= LISTP
public class ListpPrim extends Prim {



    public ListpPrim() {

    }

    public static ListpPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ListpPrim", scn$.lno);
        scn$.match(Token.Val.LISTP, trace$);
        return new ListpPrim();
    }

    public Val apply(Val [] va) {
	if (va.length != 1)
	    throw new RuntimeException("one argument expected");
        Val v0 = va[0];
	return new IntVal(v0.isList() ? 1 : 0);
    }
//ListpPrim//

}
