
Exp
%%%
    public abstract Val eval( Env env );

    /**
     * Create a Ref for this expression's value.
     * This is the default way: just wrap it in a ThunkRef.
     */
    public Ref evalRef( Env env ) {
        return new ThunkRef( this, env );
    }

%%%

