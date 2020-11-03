
VarExp
%%%
    @Override
    public String toString() {
        return var.str;
    }

    @Override
    public Val eval( Env env ) {
        return env.applyEnv( var.str );
    }

    /**
     * Create a reference from a variable.
     * In this language, which implements call-by-reference,
     * we simply return the Ref that is stored in the Binding
     * for the var. That way the Val is shared.
     */
    @Override
    public Ref evalRef( Env env ) {
        return env.applyEnvRef( var.str );
    }

%%%

