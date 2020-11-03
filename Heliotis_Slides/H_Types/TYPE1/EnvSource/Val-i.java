Val
%%%
/**
 * The run-time value of a variable
 */
public interface Val {

    /**
     * Return an integer value from this Val, if appropriate.
     * @excep RunTimeException if this is not an integer(-like) value.
     */
    public default int intVal() {
        throw new RuntimeException( "intVal(): this Val is not an IntVal." );
    }

    /**
     * Return a Boolean value from this Val, if appropriate.
     * @excep RunTimeException if this is not a Boolean value.
     */
    public default boolean boolVal() {
        throw new RuntimeException( "boolVal(): this Val is not a BoolVal." );
    }
}
%%%
