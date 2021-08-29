import java.util.*;

public abstract class Val {

    public static final Val nil = new NilVal();
    public static final Val zero = new IntVal(0);
    public static final ListVal listNull = new ListNull();

    public static Val [] toArray(List<Val> valList) {
        int n = valList.size();
        return valList.toArray(new Val[n]);
    }

    public Val apply(List<Val> valList) {
        throw new RuntimeException(this + ": not a procedure");
    }

    public Env env() {
        throw new RuntimeException("<" + this + ">: not an environment");
    }

    public boolean isTrue() {
        return true; // everything is true except for an IntVal of zero
    }

    public IntVal intVal() {
        throw new RuntimeException(this + ": not an Int");
    }

    public ListVal listVal() {
        throw new RuntimeException(this + ": not a List");
    }

    public ClassVal classVal() {
        throw new RuntimeException(this + ": not a Class");
    }

    public ObjectVal objectVal() {
        throw new RuntimeException(this + ": not an Object");
    }


    public ListNode listNode() {
        throw new RuntimeException(this + ": not a nonempty List");
    }

    public boolean isList() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isClass() {
        return false;
    }

    public ObjectVal makeObject(Ref objRef) {
        throw new RuntimeException("new " + this + ": not a class");
    }

    public String putc() {
        return this.toString();
    }
}

