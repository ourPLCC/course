import java.util.*;
//Add1Prim:import//

// <prim>:Add1Prim ::= ADD1OP
public class Add1Prim extends Prim {



    public Add1Prim() {

    }

    public static Add1Prim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:Add1Prim", scn$.lno);
        scn$.match(Token.Val.ADD1OP, trace$);
        return new Add1Prim();
    }


    public String toString() {
        return "add1";
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new RuntimeException("one argument expected");
        int i0 = va[0].intVal().val;
        return new IntVal(i0 + 1);
    }

//Add1Prim//

}
