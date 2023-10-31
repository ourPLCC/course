NullpPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "One argument expected." );
        return ( vals[0] instanceof NullVal ) ? new IntVal(1) : new IntVal(0);
    }

    @Override
    public String toString() {
	return "isNull?";
    }
%%%

