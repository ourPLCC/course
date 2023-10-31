
NullExp
%%%
    @Override
    public String toString() {
	return "NULL";
    }
    @Override
    public Val eval( Env env ) {
        return new NullVal();
    }
%%%

