Env

%%%

import java.util.Arrays;
import java.util.List;

public abstract class Env {

    /**
     * Look up the symbol in the environment.
     */
    public abstract Val applyEnv(String sym);

    /**
     * Extend the current environment by adding bindings.
     * @return a new Env linked to this one.
     */
    public Env extendEnv(Bindings bindings) {
        return new EnvNode(bindings, this);
    }

    /**
     * Display, in a string, the sequence of all bindings,
     * newest to oldest, in this and in enclosing environments.
     */
    @Override
    public String toString() {
        return "{" + this.envListing() + "}";
    }

    /**
     * Show the bindings in this Env. and in all surrounding Env's.
     */
    public abstract String envListing();

    /**
     * The "end of sequence" object for an environment chain
     */
    public static class EnvNull extends Env {
        /**
         * The parent class will make one instance of this class.
         */
        private EnvNull () {}

        @Override
        public Val applyEnv(String sym) {
            throw new RuntimeException("no binding for "+sym);
        }

        @Override
        public String envListing() {
            return "";
        }
    }

    /**
     * The initial (empty) environment
     */
    public static final Env ENV_NULL = new EnvNull();

    public static void main(String [] args) {
        Env env0 = Env.ENV_NULL;
        Env env1 = env0.extendEnv(
            new Bindings(Arrays.asList(
                new Binding("a", new Val(1)),
                new Binding("b", new Val(2)),
                new Binding("c", new Val(3)))));
        List<String> i2 = Arrays.asList("a", "p");
        List<Val> v2 = Arrays.asList(new Val(4), new Val(5));
        Env env2 = env1.extendEnv(new Bindings(i2, v2));
        try {
            System.out.println("env0:\n" + env0);
            System.out.println("env1:\n" + env1);
            System.out.println("env2:\n" + env2);
            System.out.print("a(env2) => ");
                System.out.println(env2.applyEnv("a"));
            System.out.print("a(env1) => ");
                System.out.println(env1.applyEnv("a"));
            System.out.print("b(env2) => ");
                System.out.println(env2.applyEnv("b"));
            System.out.print("p(env2) => ");
                System.out.println(env2.applyEnv("p"));
            System.out.print("p(env1) => ");
                System.out.println(env1.applyEnv("p"));
        }
        catch( Exception e ) {
            System.err.println( e );
        }
    }
}

%%%
