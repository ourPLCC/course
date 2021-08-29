import java.util.*;
//PerrorExp:import//

// <exp>:PerrorExp ::= PERROR <STRNG>
public class PerrorExp extends Exp {

    public Token strng;

    public PerrorExp(Token strng) {
        this.strng = strng;
    }

    public static PerrorExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:PerrorExp", scn$.lno);
        scn$.match(Token.Val.PERROR, trace$);
        Token strng = scn$.match(Token.Val.STRNG, trace$);
        return new PerrorExp(strng);
    }

    public Val eval(Env env) {
        String str = strng.toString();
        int len = str.length();
        str = str.substring(1,len-1);
        throw new RuntimeException("error: " + str);
    }
//PerrorExp//

}
