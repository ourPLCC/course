import java.util.*;

public class ListNode extends ListVal {

    public Val val;
    public ListVal listVal;
    public int length;

    public ListNode(Val val, ListVal listVal) {
        this.val = val;
        this.listVal = listVal;
        length = listVal.len() + 1;
    }

    public Env env() {
        throw new RuntimeException("ListVal: no environment");
    }

    public boolean isList() {
	return true;
    }

    public ListNode listNode() {
        return this;
    }

    public String toString() {
        return "[" + this.toString("") + "]";
    }

    public String putc() {
	return val.putc() + listVal.putc();
    }

    public String toString(String sep) {
        return sep + val + listVal.toString(",");
    }

    public int len() {
        return length;
    }

}