EnvNode

%%%

/**
 * The standard Env class. It contains a Bindings object.
 */
public class EnvNode extends Env {

    /** Sequence of local bindings */
    public Bindings bindings;

    /** Enclosing scope in the chain */
    public final Env enclosing;

    /**
     * Create a new environment
     * @param bindings a given set of variable bindings
     * @param env the enclosing scope
     */
    public EnvNode(Bindings bindings, Env env) {
        this.bindings = bindings;
        this.enclosing = env;
    }

    /**
     * Replace the bindings in this environment.
     * Used by "letrec" expressions.
     * @param bindings the new bindings to use
     * @rit.post the old bindings, if there were any, are gone.
     */
    @Override
    public void replaceBindings( Bindings bindings ) {
        this.bindings = bindings;
    }

    /**
     * Add a new binding to the front of this environment's existing ones.
     */
    public void addFirst( Binding newBinding ) {
        this.bindings.addFirst( newBinding );
    }

    /**
     * Look up the given symbol in this Env's bindings.
     * @param sym the symbol
     * @return the symbol's (most recent) binding in the Env chain
     */
    @Override
    public Ref applyEnvRef( String sym ) {
        // look first in the local bindings
        for ( Binding b : bindings.bindingList ) {
            if ( sym.equals( b.id ) )
                return b.ref;
        }
        // not found in the local bindings,
        // so look in the next (enclosing) environment
        Ref result = enclosing.applyEnvRef(sym);
        return result;
    }

    /**
     * Create a string containing the bindings of this environment,
     * plus those of enclosing environments.
     */
    @Override
    public String envListing() {
        String result = bindings.toString();
        result += enclosing.envListing();
        return result;
    }
}

%%%
