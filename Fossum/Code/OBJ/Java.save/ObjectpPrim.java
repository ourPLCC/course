import java.util.*;
//ObjectpPrim:import//

// <prim>:ObjectpPrim ::= OBJECTP
public class ObjectpPrim extends Prim {



    public ObjectpPrim() {

    }

    public static ObjectpPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ObjectpPrim", scn$.lno);
        scn$.match(Token.Val.OBJECTP, trace$);
        return new ObjectpPrim();
    }

    public Val apply(Val [] va) {
	if (va.length != 1)
            throw new RuntimeException("one argument expected");
        Val v0 = va[0];
        return new IntVal(v0.isObject() ? 1 : 0);
   }
//ObjectpPrim//

}
