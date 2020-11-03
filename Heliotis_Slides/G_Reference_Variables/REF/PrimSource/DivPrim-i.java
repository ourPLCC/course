
DivPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 2 )
            throw new RuntimeException( "Two arguments expected." );
        int i0 = vals[ 0 ].intVal();
        int i1 = vals[ 1 ].intVal();
        if ( i1 == 0 ) {
            throw new RuntimeException( "Divide by zero." );
        }
        return new IntVal( i0 / i1 );
    }

    @Override
    public String toString() {
	return "/";
    }
%%%


