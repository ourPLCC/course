
Add1Prim
%%%
   @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "One argument expected." );
        int i0 = vals[ 0 ].value;
        return new Val( i0 + 1 );
    }

    @Override
    public String toString() {
	return "add1";
    }
%%%

