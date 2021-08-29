import java.util.*;
import java.util.regex.*;

// Token class with match patterns (used with the built-in Scan class)
public class Token {
       
    public enum Val {
        WHITESPACE ("\\s+", true),
        COMMENT ("%.*", true),
        LIT ("\\d+"),
        LPAREN ("\\("),
        RPAREN ("\\)"),
        COMMA (","),
        ADDOP ("\\+"),
        SUBOP ("\\-"),
        MULOP ("\\*"),
        DIVOP ("/"),
        ADD1OP ("add1"),
        SUB1OP ("sub1"),
        ZEROP ("zero\\?"),
        LTP ("<\\?"),
        LEP ("<=\\?"),
        GTP (">\\?"),
        GEP (">=\\?"),
        NEP ("<>\\?"),
        EQP ("=\\?"),
        LENOP ("len"),
        LISTP ("list\\?"),
        OBJECTP ("object\\?"),
        CLASSP ("class\\?"),
        FIRSTOP ("first"),
        RESTOP ("rest"),
        ADDFIRSTOP ("addFirst"),
        IF ("if"),
        THEN ("then"),
        ELSE ("else"),
        LET ("let"),
        LETREC ("letrec"),
        DEFINE ("define"),
        IN ("in"),
        EQUALS ("="),
        EXIT ("exit"),
        PROC ("proc"),
        SET ("set"),
        CLASS ("class"),
        EXTENDS ("extends"),
        STATIC ("static"),
        FIELD ("field"),
        METHOD ("method"),
        END ("end"),
        WITH ("with"),
        EVAL ("eval"),
        NEW ("new"),
        SEND ("send"),
        NIL ("nil"),
        DISPLAY ("display"),
        DISPLAY1 ("display#"),
        NEWLINE ("newline"),
        PUTC ("putc"),
        ERROR ("error"),
        PERROR ("perror"),
        AT ("@"),
        ATAT ("@@"),
        DOT ("\\."),
        LBRACE ("\\{"),
        RBRACE ("\\}"),
        LBRACK ("\\["),
        RBRACK ("\\]"),
        LANGLE ("<"),
        RANGLE (">"),
        LLANGLE ("!<"),
        RRANGLE ("!>"),
        BANGAT ("!@"),
        SEMI (";"),
        CHR ("'."),
        STRNG ("\\\"(\\\\.|[^\\\"\\\\])*\\\""),
        VAR ("[A-Za-z\\&\\?\\$][\\w\\?\\&\\$]*"),
        $ERROR (null),
        $EOF (null);

	public String pattern;
        public boolean skip;
	public Pattern cPattern; // compiled pattern

        // a token pattern (skip == false)
        Val(String pattern) {
            this(pattern, false);
	}

        Val(String pattern, boolean skip) {
	    this.pattern = pattern;
            this.skip = skip;
            if (pattern != null)
	        this.cPattern = Pattern.compile(pattern, Pattern.DOTALL);
            else
                this.cPattern = null;
	}
    }

    public Val val;          // token
    public String str;       // the token string matched
    public int lno;          // the line number where this token was found

    public Token() {
	val = null;
        str = null;
        lno = 0;
    }
    
    public Token(Val val, String str, int lno) {
        this.val = val;
        this.str = str;
	this.lno = lno;
    }

    public Token(Val val, String str) {
	this(val, str, 0);
    }

    public String toString() {
        return str;
    }

    public boolean isEOF() {
        return this.val == Token.Val.$EOF;
    }

    public static void main(String [] args) {
	for (Val v : Val.values()) {
            if (v == Val.$EOF)
                break;
            String what;
            if (v.skip)
                what = "skip";
            else
                what = "token";
	    System.out.println(String.format("%s %s '%s'", what, v, v.pattern));
        }
    }

//Token//

}
