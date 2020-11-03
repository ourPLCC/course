
Sub1Prim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "One argument expected." );
        int i0 = vals[ 0 ].intVal();
        return new IntVal( i0 - 1 );
    }

    @Override
    public String toString() {
	return "sub1";
    }
%%%

