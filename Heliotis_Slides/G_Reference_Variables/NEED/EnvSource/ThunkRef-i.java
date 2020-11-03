
ThunkRef
%%%

/**
 * An expression wrapped in an environment.
 * This is essentially the same as a ProcVal, but without formal parameters.
 * In the NEED language, the ThunkRef remembers its value after the first
 * time it is called.
 */
public class ThunkRef implements Ref {

    public final Exp exp;
    public final Env env;
    public Val val; // the cache for a value after 1st evaluation

    public ThunkRef( Exp exp, Env env ) {
        this.exp = exp;
        this.env = env;
        this.val = null;
    }

    /**
     * Get the value out of this ThunkRef.
     * In call-by-name, that means evaluating the expression.
     */
    @Override
    public Val deRef() {
        if ( this.val == null ) {
            this.val = exp.eval( env );
        }
        return this.val;
    }

    @Override
    public Val setRef( Val v ) {
        throw new RuntimeException( "ThunkRefs have no Value to set." );
    }
}

%%%

