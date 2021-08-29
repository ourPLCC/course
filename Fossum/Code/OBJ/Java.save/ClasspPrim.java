import java.util.*;
//ClasspPrim:import//

// <prim>:ClasspPrim ::= CLASSP
public class ClasspPrim extends Prim {



    public ClasspPrim() {

    }

    public static ClasspPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ClasspPrim", scn$.lno);
        scn$.match(Token.Val.CLASSP, trace$);
        return new ClasspPrim();
    }

    public Val apply(Val [] va) {
	if (va.length != 1)
            throw new RuntimeException("one argument expected");
        Val v0 = va[0];
        return new IntVal(v0.isClass() ? 1 : 0);
   }
//ClasspPrim//

}
