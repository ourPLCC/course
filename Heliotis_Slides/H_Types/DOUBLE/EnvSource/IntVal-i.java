IntVal
%%%
/**
 * An object representing an integer run-time value in a program.
 */
public class IntVal implements Val {

    /** The integer within */
    private final int v;

    /** Construct a new value with the given integer. */
    public IntVal( int v ) {
        this.v = v;
    }

    /**
     * Return this IntVal's inner integer value.
     */
    @Override
    public int intVal() {
        return this.v;
    }

    /**
     * Return a representation of this value as a decimal string.
     */
    @Override
    public String toString() {
        return Integer.toString( v );
    }
}
%%%
