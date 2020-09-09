
VarExp
%%%
    public String toString() {
        return var.toString();
    }
    public Val eval( Env env ) {
        return env.applyEnv( var.toString() );
    }
%%%

