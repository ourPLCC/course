DoubleVal
%%%
/**
 * An object representing an double run-time value in a program.
 */
public class DoubleVal implements Val {

    /** The double within */
    private final double v;

    /** Construct a new value with the given double. */
    public DoubleVal( double v ) {
        this.v = v;
    }

    /**
     * Return this DoubleVal's inner double value.
     */
    @Override
    public double doubleVal() {
        return this.v;
    }

    /**
     * Return a representation of this value as a decimal string.
     */
    @Override
    public String toString() {
        return Double.toString( v );
    }
}
%%%
