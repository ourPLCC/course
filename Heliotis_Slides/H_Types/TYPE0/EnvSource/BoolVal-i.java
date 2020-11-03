BoolVal
%%%%

/**
 * An object representing a Boolean run-time value in a program.
 */
public class BoolVal implements Val {

    /** The Boolean within */
    public final boolean b;

    /** Construct a new value with the given Boolean. */
    public BoolVal( boolean b ) {
        this.b = b;
    }

    /**
     * Return a representation of this value as a decimal string.
     */
    @Override
    public String toString() {
        return Boolean.toString( b );
    }

    /**
     * Return the underlying Boolean value.
     */
    public boolean isTrue() {
        return b;
    }

    /**
     * Compare this BoolVal to another one.
     * (Used by primitive procs =? and <>?)
     */
    @Override
    public boolean equals( Object other ) {
        if ( !( other instanceof BoolVal ) ) return false;
        return b == ((BoolVal)other).b;
    }
}

%%%%
