
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

    /** 
     * Create a Ref for this expression's value.
     * Although passed by reference, literals cannot be modified.
     */
    @Override
    public Ref evalRef( Env env ) {
        return new ValRORef( this.eval( env ) );
    }

%%%

