import java.util.*;
//Sub1Prim:import//

// <prim>:Sub1Prim ::= SUB1OP
public class Sub1Prim extends Prim {



    public Sub1Prim() {

    }

    public static Sub1Prim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:Sub1Prim", scn$.lno);
        scn$.match(Token.Val.SUB1OP, trace$);
        return new Sub1Prim();
    }


    public String toString() {
        return "sub1";
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new RuntimeException("one argument expected");
        int i0 = va[0].intVal().val;
        return new IntVal(i0 - 1);
    }

//Sub1Prim//

}
