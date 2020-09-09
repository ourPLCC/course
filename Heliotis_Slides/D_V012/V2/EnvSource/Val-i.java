Val
%%%
/**
 * The run-time value of a variable
 */
public class Val {

    /**
     * The actual int value
     */
    public final int value;

    /**
     * Create an int Val.
     */
    public Val( int value ) {
        this.value = value;
    }

    /**
     * Return false if this Val's integer is 0; true otherwise.
     * Useful when an integer is used as a test in a conditional expression.
     */
    public boolean isTrue() {
        return value != 0;
    }

    /**
     * Return the int value as a string.
     */
    @Override
    public String toString() {
        return Integer.toString( value );
    }
}
%%%
