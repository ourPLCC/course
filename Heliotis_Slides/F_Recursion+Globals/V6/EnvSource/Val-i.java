Val
%%%
/**
 * The run-time value of a variable
 */
public interface Val {
    /**
     * Values are assumed to represent true
     * except in special cases
     */
    public default boolean isTrue() { return true; }

    /**
     * Return an integer value from this Val, if appropriate.
     * @excep RunTimeException if this is not an integer(-like) value.
     */
    public default int intVal() {
        throw new RuntimeException( "intVal(): this Val is not an IntVal." );
    }
}
%%%
