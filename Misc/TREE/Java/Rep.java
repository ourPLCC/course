import java.io.*;
import java.util.*;

public class Rep {

    // do a read-eval-print loop, reading from command-line files
    // and then from standard input
    public static void main(String [] args) {
	Trace trace = null;
	// first read and process any input files from the command line
	Scan scn = null;
	for (int i=0 ; i<args.length ; i++) {
	    String s = args[i];
            if (s.equals("-t") && trace == null) {
                trace = new Trace(); // trace any following args
                continue;
            }
	    try {
		scn = new Scan(new BufferedReader(new FileReader(s)));
            } catch (FileNotFoundException e) {
		System.out.println(e + " ... exiting");
                System.exit(1);
            }
	    try {
		// read and process expressions from this FileReader
		while (true) {
		    if (trace != null)
			trace.reset();
		    System.out.println(PLCC$Start.parse(scn, trace));
                }
            } catch (NullPointerException e) {
		// harmless end of file on this FileReader
            } catch (Exception e) {
		System.out.println(e + " ... exiting");
                System.exit(1);
            }
        }
        // finally read any expressions from standard input
	BufferedReader rdr =
            new BufferedReader(new InputStreamReader(System.in));
        scn = new Scan(rdr);
        while (true) {
            System.out.print("--> ");
            try {
		if (trace != null) {
		    trace.reset();
                    System.out.println();
                }
                System.out.println(PLCC$Start.parse(scn, trace)); // parse and print
            } catch (NullPointerException e) {
                break; // all done!
            } catch (Exception e) {
                scn = new Scan(rdr); // start over
                System.out.println(e);
            }
        }
    }
}
