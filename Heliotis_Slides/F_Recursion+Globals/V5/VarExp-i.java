
VarExp
%%%
    @Override
    public String toString() {
        return var.toString();
    }
    @Override
    public Val eval( Env env ) {
        return env.applyEnv( var.toString() );
    }
%%%

