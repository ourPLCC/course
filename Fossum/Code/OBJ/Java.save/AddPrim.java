import java.util.*;
//AddPrim:import//

// <prim>:AddPrim ::= ADDOP
public class AddPrim extends Prim {



    public AddPrim() {

    }

    public static AddPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:AddPrim", scn$.lno);
        scn$.match(Token.Val.ADDOP, trace$);
        return new AddPrim();
    }


    public String toString() {
  return "+";
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new RuntimeException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new IntVal(i0 + i1);
    }
//AddPrim//

}
