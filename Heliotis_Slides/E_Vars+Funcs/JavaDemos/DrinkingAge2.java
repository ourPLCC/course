import java.util.function.Predicate;
public class DrinkingAge2 {
    private static Predicate< Integer > drinking_age( int minAge ) {
        class MyPredicate implements Predicate< Integer > {
            int minAge;
            MyPredicate( Integer minAge ) { this.minAge = minAge; }
            public boolean test( Integer age ) { return age >= minAge; }
        }
        return new MyPredicate( minAge );
    }
    public static void main( String[] args ) {
        Predicate< Integer > newYork = drinking_age( 21 );
        Predicate< Integer > québec = drinking_age( 18 );
        System.out.println( québec.test( 19 ) );
        System.out.println( newYork.test( 19 ) );
    }
}
