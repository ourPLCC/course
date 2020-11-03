
LitExp
%%%
    @Override
    public String toString() {
	return lit.toString();
    }
    @Override
    public Val eval( Env env ) {
        return new Val( Integer.parseInt( lit.toString() ) );
    }
%%%

