import java.util.*;
//StrngExp:import//

// <exp>:StrngExp ::= <STRNG>
public class StrngExp extends Exp {

    public Token strng;

    public StrngExp(Token strng) {
        this.strng = strng;
    }

    public static StrngExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:StrngExp", scn$.lno);
        Token strng = scn$.match(Token.Val.STRNG, trace$);
        return new StrngExp(strng);
    }

    public Val eval(Env env) {
        String s = strng.toString();
        int len = s.length()-1;
        LinkedList<Character> chars = new LinkedList<Character>();
        // We know that s.charAt(0) is '"'
        // and that s.charAt(len) is '"'
        int pos = 1;
        while (pos < len) {
            char c = s.charAt(pos++);
            if (c == '\\') {
                // escape!
                c = s.charAt(pos++);
                switch(c) {
                case 'a' : c = 7; break;
                case 'b' : c = 8;  break;
                case 't' : c = 9;  break;
                case 'n' : c = 10; break;
                case 'f' : c = 12; break;
                case 'r' : c = 13; break;
                default  : break;
                }
            }
            chars.add(0, c); // add to beginning of list
        }
        // chars is in reverse order -- now build a ListVal in proper order
        ListVal lst = Val.listNull;
        for (Character c : chars) {
            lst = lst.add(new IntVal(c));
        }
        return lst;
    }

    public String toString() {
        return strng.toString();
    }
//StrngExp//

}
