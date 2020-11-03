Binding

%%%

/**
 * Binding of a single identifier to a reference to its value.
 */
public class Binding {
    /** the identifier / variable name */
    public final String id;

    /** the value to which the identifier is bound */
    public final Ref ref;

    /**
     * Construct a Binding by initializing its two fields.
     */
    public Binding( String id, Ref ref ) {
        this.id = id;
        this.ref = ref;
    }

    /**
     * Return a string representation in the format '(ID,value)'.
     */
    @Override
    public String toString() {
        return "(" + id + ",&" + ref.deRef() + ')';
    }
}

%%%
