
VarExp
%%%
    public String toString() {
        return var.str;
    }
    public Val eval( Env env ) {
        return env.applyEnv( var.str );
    }
%%%

