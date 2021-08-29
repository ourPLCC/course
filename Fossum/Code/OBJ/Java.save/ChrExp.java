import java.util.*;
//ChrExp:import//

// <exp>:ChrExp ::= <CHR>
public class ChrExp extends Exp {

    public Token chr;

    public ChrExp(Token chr) {
        this.chr = chr;
    }

    public static ChrExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ChrExp", scn$.lno);
        Token chr = scn$.match(Token.Val.CHR, trace$);
        return new ChrExp(chr);
    }

    public Val eval(Env env) {
        return new IntVal(chr.toString().charAt(1));
    }

    public String toString() {
        return chr.toString();
    }
//ChrExp//

}
