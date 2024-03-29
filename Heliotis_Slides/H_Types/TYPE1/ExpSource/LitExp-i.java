
LitExp
%%%
    @Override
    public String toString() {
	return lit.toString();
    }

    @Override
    public Val eval( Env env ) {
        return new IntVal( Integer.parseInt( lit.toString() ) );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        return IntType.TYPE;
    }

%%%

