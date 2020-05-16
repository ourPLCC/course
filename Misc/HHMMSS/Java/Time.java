import java.util.*;
//Time:import//

// <time> ::= <TWOD>hours COLON <TWOD>minutes COLON <TWOD>seconds NL
public class Time {

    public Token hours;
    public Token minutes;
    public Token seconds;

    public Time() { } // dummy constructor

    public Time(Token hours, Token minutes, Token seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static Time parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<time>", scn$.lno);
        Token hours = scn$.match(Token.Val.TWOD, trace$);
        scn$.match(Token.Val.COLON, trace$);
        Token minutes = scn$.match(Token.Val.TWOD, trace$);
        scn$.match(Token.Val.COLON, trace$);
        Token seconds = scn$.match(Token.Val.TWOD, trace$);
        scn$.match(Token.Val.NL, trace$);
        return new Time(hours, minutes, seconds);
    }

//Time//

}
