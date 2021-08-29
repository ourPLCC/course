import java.util.*;

public class IntVal extends Val {

    public int val;

    public IntVal(String s) {
        val = Integer.parseInt(s);
    }

    public IntVal(int v) {
        val = v;
    }

    public IntVal intVal() {
        return this;
    }

    public boolean isTrue() {
        return val != 0;
    }

    public String putc() {
        return "" + (char)val;
    }

    public String toString() {
        return "" + val;
    }

}