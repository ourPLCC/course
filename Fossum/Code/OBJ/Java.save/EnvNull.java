import java.util.*;

public class EnvNull extends Env {

    // create an environment
    public EnvNull() {
    }

    // find the Ref corresponding to a given id
    public Ref applyEnvRef(String sym) {
        throw new RuntimeException("no binding for "+sym);
    }

    public void replaceBindings(Bindings bindings) {
        throw new RuntimeException("no bindings to replace");
    }

    public void add(Binding b) {
        throw new RuntimeException("no bindings to add to");
    }

    public void addFirst(Binding b) {
        throw new RuntimeException("no bindings to add to");
    }

    public String toString(int n) {
        return n + ":\n";
    }

    public String toString() {
        return "\n";
    }
}