import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Demonstration of regular expression syntax in Java.
 *
 * Remember, when using PLCC, a Python program reads your regex strings,
 * but it does not interpret them. It places them, unaltered, into generated
 * Java code which is then compiled and executed.
 *
 * @see java.util.regex.Pattern
 * @author James Heliotis
 * January 2021
 */
public class RegularExpressions {

    private static String[][] examples = {
            { "hell", "Well hello world!" },
            { "Hell", "Well hello world!" },
            { "hello|goodbye", "Well hello world!" },
            { "[0-9]", "When I'm 64 ..." },
            { "^[0-9]$", "When I'm 64 ..." },
            { "^[0-9]$", "64" },
            { "^[0-9]$", "6" },
            { "^\\d$", "6" },
            { "^\\d$", "6" },
            { "^\\d*$", "2525" },
            { "^\\d*$", "2525a" },
            { "\\d*", "2525a" },
            { "\\d*", "a" },
            { "\\d+", "a" },
            { "\\D+", "2525a" },
            { "\\D+", "2525" }
    };

    private static void match( String[] pair ) {
        Pattern pattern = Pattern.compile( pair[ 0 ] );

        System.out.print(
          "Does '" + pair[ 1 ] + "' completely match '" + pair[ 0 ] + "'? "
        );
        Matcher matcher = pattern.matcher( pair[ 1 ] );
        System.out.println( matcher.matches() ? "YES." : "NO." );

        System.out.print(
                "Does '" + pair[ 1 ] + "' match '" + pair[ 0 ] + "' anywhere? "
        );
        System.out.println( matcher.find() ? "YES." : "NO." );

        System.out.println();
    }

    public static void main( String[] args ) {
        switch ( args.length ) {
            case 2 -> {
                match( args );
            }
            case 0 -> {
                for ( String[] strPair : examples ) match( strPair );
            }
            default -> {
                System.err.println(
                        "Usage: java RegularExpressions [pattern string]"
                );
            }
        }
    }

}
