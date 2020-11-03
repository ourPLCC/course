TrueExp
%%%
    @Override
    public String toString() {
	return "true";
    }

    @Override
    public Val eval( Env env ) {
        return new BoolVal( true );
    }
%%%

