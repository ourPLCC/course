
Exp:import
%%%

import java.util.HashSet;
import java.util.List;
import java.util.Set;
%%%

Exp
%%%
    /**
     * Compute the value of this expression while its program is
     * being interpreted.
     * @param env a reference to all the variable bindings currently in effect
     */
    public abstract Val eval( Env env );

    /**
     * Compute the type of the value that this expression will
     * evaluate to. This is done during type-checking.
     * @param env a reference to all the type bindings currently in effect
     */
    public abstract Type evalType( TypeEnv tenv );

    /**
     * Create a reference from this expression's value.
     * This is the default way: just compute the value
     * and then wrap in in a Ref.
     */
    public Ref evalRef( Env env ) {
        return new ValRef( eval( env ) );
    }
%%%

