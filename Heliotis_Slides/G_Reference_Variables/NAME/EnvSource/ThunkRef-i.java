
ThunkRef
%%%

/**
 * An expression wrapped in an environment.
 * This is essentially the same as a ProcVal, but without formal parameters.
 */
public class ThunkRef implements Ref {

    /* Note there is no "val" for a ThunkRef. */

    public final Exp exp;
    public final Env env;

    public ThunkRef( Exp exp, Env env ) {
        this.exp = exp;
        this.env = env;
    }

    /**
     * Get the value out of this ThunkRef.
     * In call-by-name, that means evaluating the expression.
     */
    @Override
    public Val deRef() {
        return exp.eval( env );
    }

    @Override
    public Val setRef( Val v ) {
        throw new RuntimeException( "ThunkRefs have no Value to set." );
    }
}

%%%

