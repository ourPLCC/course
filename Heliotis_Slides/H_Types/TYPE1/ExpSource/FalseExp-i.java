FalseExp
%%%
    @Override
    public String toString() {
	return "false";
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        return BoolType.TYPE;
    }

    @Override
    public Val eval( Env env ) {
        return new BoolVal( false );
    }
%%%

