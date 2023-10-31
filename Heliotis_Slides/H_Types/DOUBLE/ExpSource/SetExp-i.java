SetExp
%%%

    @Override
    public Val eval( Env env ) {
        Val val = exp.eval( env );
        Ref ref = env.applyEnvRef( var.str );
        return ref.setRef( val );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        Type varType = tenv.applyTypeEnv( var.str );
        Type expType = exp.evalType( tenv );
        varType.checkEquals( expType );
        return varType;
    }

    @Override
    public String toString() {
        return var.str + '=' + exp;
    }

%%%
