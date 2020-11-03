
Exp
%%%
    public abstract Val eval( Env env );

    /**
     * Create a reference from this expression's value.
     * This is the default way: just compute the value
     * and then wrap in in a Ref.
     */
    public Ref evalRef( Env env ) {
        return new ValRef( eval( env ) );
    }

%%%

