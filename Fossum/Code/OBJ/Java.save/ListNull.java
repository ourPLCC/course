import java.util.*;

public class ListNull extends ListVal {

    public ListNull() {
    }

    public Env env() {
        throw new RuntimeException("ListVal: no environment");
    }

    public boolean isList() {
	return true;
    }

    public boolean isTrue() {
        return false;
    }

    public String toString() {
        return "[]";
    }

    public String putc() {
	return "";
    }

    public String toString(String sep) {
        return "";
    }
}
