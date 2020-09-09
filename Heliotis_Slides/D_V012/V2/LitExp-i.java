
LitExp
%%%
    public String toString() {
	return lit.toString();
    }
    public Val eval( Env env ) {
        return new Val( Integer.parseInt( lit.toString() ) );
    }
%%%

