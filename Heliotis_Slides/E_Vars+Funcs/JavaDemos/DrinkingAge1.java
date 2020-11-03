import java.util.function.Predicate;
public class DrinkingAge1 {
    private static Predicate< Integer > drinking_age( int minAge ) {
        return age -> age >= minAge;
    }
    public static void main( String[] args ) {
        Predicate< Integer > newYork = drinking_age( 21 );
        Predicate< Integer > québec = drinking_age( 18 );
        System.out.println( québec.test( 19 ) );
        System.out.println( newYork.test( 19 ) );
    }
}
