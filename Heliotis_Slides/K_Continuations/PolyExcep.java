/*
 * So, what's the output going to be?
 */

class Excep1 extends Exception {}

class Excep2 extends Excep1 {}

public class PolyExcep {

    private Excep1 e;

    public void noGood() throws Excep1 {
        e = new Excep2();
        throw e;
    }

    public static void main( String[] args ) {
        PolyExcep poly = new PolyExcep();
        try {
            poly.noGood();
        }
        catch( Excep2 e2 ) {
            System.out.println( "Got an Excep2: " + e2 );
        }
        catch( Excep1 e1 ) {
            System.out.println( "Got an Excep1: " + e1 );
        }
    }
}
