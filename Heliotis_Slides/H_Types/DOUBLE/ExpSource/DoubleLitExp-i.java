
DoubleLitExp
%%%
    @Override
    public String toString() {
	return doublelit.toString();
    }

    @Override
    public Val eval( Env env ) {
        return new DoubleVal( Double.parseDouble( doublelit.toString() ) );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        return DoubleType.TYPE;
    }

%%%

