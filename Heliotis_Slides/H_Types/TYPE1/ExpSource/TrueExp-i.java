TrueExp
%%%
    @Override
    public String toString() {
	return "true";
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        return BoolType.TYPE;
    }

    @Override
    public Val eval( Env env ) {
        return new BoolVal( true );
    }
%%%

