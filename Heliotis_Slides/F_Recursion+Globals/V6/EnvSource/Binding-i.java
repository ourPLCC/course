Binding

%%%

/**
 * Binding of a single identifier to its value.
 * They go into a collection of bindings called Bindings.
 */
public class Binding {
    /** the identifier / variable name */
    public final String id;

    /** the value to which the identifier is bound */
    public final Val val;

    /**
     * Construct a Binding by initializing its two fields.
     */
    public Binding( String id, Val val ) {
        this.id = id;
        this.val = val;
    }

    /**
     * Return a string representation in the format '(ID,value)'.
     */
    @Override
    public String toString() {
        return "(" + id + ',' + val + ')';
    }
}

%%%
