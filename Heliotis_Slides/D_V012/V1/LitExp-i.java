
LitExp
%%%
    public String toString() {
	return lit.str;
    }
    public Val eval( Env env ) {
        return new Val( Integer.parseInt( lit.str ) );
    }
%%%

