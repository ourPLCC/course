import java.util.*;

public class EnvNode extends Env {

    public Bindings bindings; // list of local bindings
    public Env env;           // next set of bindings

    // create an environment
    public EnvNode(Bindings bindings, Env env) {
        this.bindings = bindings;
        this.env = env;
    }

    // find the Ref corresponding to a given id
    public Ref applyEnvRef(String sym) {
        // first look in the local bindings
        for (Binding b : bindings.bindingList) {
            if (sym.equals(b.id))
                return b.ref;
        }
        // if nothing left, we don't have a match in this list of bindings
        return env.applyEnvRef(sym);
    }

    public void replaceBindings(Bindings bindings) {
        this.bindings = bindings;
    }

    public String toString(int n) {
        return n + ":" + bindings.toString() + "\n" + env.toString(n+1);
    }

    public String toString() {
        return bindings.toString() + "\n" + env;
    }

    public void add(Binding b) {
        bindings.add(b);
    }

    public void addFirst(Binding b) {
        bindings.addFirst(b);
    }

}