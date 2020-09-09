import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A set of bindings associated with a single scope.
 * A sequence of bindings forms an environment for the program at any
 * given point in time.
 */
public class Bindings {

    /**
     * An associative table of identifier bindings
     */
    public final List< Binding > bindingList;

    /**
     * Bindings is initially empty, unless another constructor is used.
     */
    public Bindings() {
        bindingList = new ArrayList< Binding >();
    }

    /**
     * Create bindings from the parallel arrays constructed by code
     * generated by PLCC.
     */
    public Bindings( List< String > idList, List< Val > valList ) {
        // the Lists must be the same size
        if ( idList.size() != valList.size() )
            throw new RuntimeException( "Bindings: List size mismatch" );
        bindingList = new ArrayList< Binding >();
        Iterator< String > is = idList.iterator();
        Iterator< Val > vs = valList.iterator();
        while ( is.hasNext() ) {
            bindingList.add( new Binding( is.next().toString(), vs.next() ) );
        }
    }

    /**
     * Create Bindings from a list of Bindings.
     */
    public Bindings( List< Binding > bindingList ) {
        this.bindingList = bindingList;
    }

    /**
     * Add a Binding object to this local environment.
     */
    public void add( Binding b ) {
        bindingList.add( b );
    }

    /**
     * Add a binding (s, v) to this local environment.
     */
    public void add( String s, Val v ) {
        add( new Binding( s, v ) );
    }

    /**
     * Create a string that is the concatentated string representations
     * of the individual Bindings.
     */
    @Override
    public String toString() {
        String result = "";
        for ( Binding b : bindingList ) {
            result += b;
        }
        return result;
    }
}
