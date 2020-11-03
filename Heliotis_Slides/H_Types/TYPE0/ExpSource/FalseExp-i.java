FalseExp
%%%
    @Override
    public String toString() {
	return "false";
    }

    @Override
    public Val eval( Env env ) {
        return new BoolVal( false );
    }
%%%

