import java.util.regex.*;
import java.util.*;
import java.io.*;

public class Scan implements IScan {

    private BufferedReader rdr;  // get input from here, line by line
    private String s;   // current string being scanned
    public int lno;     // current line number
    private String snl; // current string to scan, without the newline
    private int start;  // starting position in the string to scan
    private int end;    // ending position

    // create a scanner object on a buffered reader
    public Scan(BufferedReader rdr) {
        this.rdr = rdr;
	this.lno = 0;
        s = null;
        snl = null;
    }

    // create a scanner object on a string
    public Scan(String s) {
        this(new BufferedReader(new StringReader(s)));
    }

    public Token tok; // this is persistent across all calls to token()

    // fill the string buffer from the reader if it's exhausted or null)
    public void fillString() {
        if (s == null || start >= end) {
            // get the next line from the reader
            try {
                s = rdr.readLine();
                if (s == null)
                    return; // end of file
		lno++;
                snl = s;
                s += "\n";
                start = 0;
                end = s.length();
            } catch (IOException e) {
                s = null;
            }
            // System.err.print("s=" + s);
        }
    }
        
    public Token cur() {
        // lazy
        if (tok != null)
            return tok; // don't get a new token if we already have one

        String matchString = "";
	Token.Val valFound = null;

        LOOP:
        while (true) {
            fillString(); // get another line if necessary
            if (s == null)
                return null; // EOF
            // s cannot be null here
            int matchEnd = start; // current end of match
            for (Token.Val val : Token.Val.values()) {
                if (val.skip && valFound != null)
                    continue; // don't check skips if we have a pending token
                Pattern pat = val.cPattern;
                Matcher m = pat.matcher(s);
                m.region(start, end);
                if (m.lookingAt()) {
                    int e = m.end();
                    if (e == start)
                        continue; // empty match, so try next pattern
                    if (val.skip) {
                        // there's a non-empty skip match,
                        // so we skip over the matched part
                        // and get more stuff to read
                        start = e;
                        continue LOOP;
                    }
                    if (matchEnd < e) {
                        // found a longer match -- keep it!
                        matchEnd = e;
                        matchString = m.group();
                        valFound = val;
                    }
                }
            }
            if (valFound == null) {
                char ch = s.charAt(start);
                String sch;
                if (ch >= ' ' && ch <= '~')
                    sch = "'" + ch + "'";
                else
                    sch = String.format("(char)%d", (int)ch);
                throw new RuntimeException(
                    "illegal character " +
                    sch +
                    " on line " +
                    lno +
                    ": \"" +
                    snl + 
                    "\""); 
            }
            start = matchEnd; // start of next token match
            // matchString is the matching string
	    tok = new Token(valFound, matchString, lno); // persistent value
	    return tok;
        }
    }

    public void adv() {
        // if we have already advanced past the current token,
        // we'll have to do it again
        if (tok == null)
            cur();
        tok = null;
    }

    public void put(Token t) {
	throw new RuntimeException("Scan class: put not implemented");
    }

    public Token match(Token.Val v, Trace trace) {
        Token t = cur();
        Token.Val vv = t.val;
        if (v == vv) {
            if (trace != null)
		trace.print(t);
            adv();
        } else {
            throw new RuntimeException
                ("match failure: expected token " + v +
                 ", got " + vv);
        }
        return t;
    }

    public void printTokens() {
	Token t;
        while ((t = cur()) != null) {
            System.out.println(t.val + ": '" + t + "'");
            adv();
        }
    }

    public boolean hasNext() {
        return cur() != null;
    }

    public Token next() {
        Token t = cur();
        adv();
        return t;
    }

    public static void main(String [] args) {
        BufferedReader rdr =
            new BufferedReader(new InputStreamReader(System.in));
        Scan scn = new Scan(rdr);
        scn.printTokens();
    }
}
