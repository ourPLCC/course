import java.util.*;

public abstract class Env {

    public static Env initEnv() {
        // an environment with an empty local environment
        return new EnvNode(new Bindings(), new EnvNull());
    }

    public abstract Ref applyEnvRef(String sym);
    public abstract void replaceBindings(Bindings bindings);
    public abstract void add(Binding b);
    public abstract void addFirst(Binding b);

    public Val applyEnv(String sym) {
        return applyEnvRef(sym).deRef();
    }

    public Ref applyEnvRef(Token tok) {
        return applyEnvRef(tok.toString());
    }

    public Val applyEnv(Token tok) {
        return applyEnv(tok.toString());
    }

    public Env extendEnvRef(Bindings bindings) {
        return new EnvNode(bindings, this);
    }

    public abstract String toString(int n);
}