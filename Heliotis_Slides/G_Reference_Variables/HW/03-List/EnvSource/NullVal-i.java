NullVal
%%%
/**
 * An object representing a nil/null value.
 * There does not need to be more than one but we won't worry about that.
 */
public class NullVal implements Val {

    /**
     * Return false. Null is simply not true.
     */
    public boolean isTrue() {
        return false;
    }

    /**
     * Return true, implying that this is indeed a null.
     */
    @Override
    public boolean isNull() {
        return true;
    }

    /**
     * Return a representation of this value as a decimal string.
     */
    @Override
    public String toString() {
        return "NULL";
    }
}
%%%
