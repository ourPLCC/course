SetExp
%%%

    public Val eval( Env env ) {
        Val val = exp.eval( env );
        Ref ref = env.applyEnvRef( var.str );
        return ref.setRef( val );
    }

    @Override
    public String toString() {
        return var.str + '=' + exp;
    }

%%%
