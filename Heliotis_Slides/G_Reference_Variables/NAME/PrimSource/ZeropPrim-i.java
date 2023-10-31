ZeropPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "One argument expected." );
        int i0 = vals[0].intVal();
        return new IntVal( i0 == 0 ? 1 : 0 );
    }

    @Override
    public String toString() {
	return "zero?";
    }
%%%

