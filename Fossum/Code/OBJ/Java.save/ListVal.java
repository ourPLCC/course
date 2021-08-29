
public abstract class ListVal extends Val {

    public abstract String toString(String sep);

    public ListVal add(Val v) {
        // System.err.println("adding " + v);
	return new ListNode(v, this);
    }

    public ListVal listVal() {
        return this;
    }

    public int len() {
        return 0;
    }
}
