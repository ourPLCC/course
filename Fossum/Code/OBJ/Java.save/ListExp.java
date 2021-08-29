import java.util.*;
//ListExp:import//

// <exp>:ListExp ::= LBRACK <rands> RBRACK
public class ListExp extends Exp {

    public Rands rands;

    public ListExp(Rands rands) {
        this.rands = rands;
    }

    public static ListExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ListExp", scn$.lno);
        scn$.match(Token.Val.LBRACK, trace$);
        Rands rands = Rands.parse(scn$, trace$);
        scn$.match(Token.Val.RBRACK, trace$);
        return new ListExp(rands);
    }

    public Val eval(Env env) {
        List<Val> valList = rands.evalRands(env);
        ListVal listVal = Val.listNull;
        int n = valList.size();
        // process the elements in reverse order
        while (n > 0)
            listVal = new ListNode(valList.get(--n), listVal);
        return listVal;
    }

    public String toString() {
        return " ...ListExp... ";
    }
//ListExp//

}
