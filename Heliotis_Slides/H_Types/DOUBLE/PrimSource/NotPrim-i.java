
NotPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "Two arguments expected." );
        boolean b0 = vals[ 0 ].boolVal();
        return new BoolVal( !b0 );
    }

    @Override
    public String toString() {
	return "not";
    }

    @Override
    public ProcType definedType() {
        return PrimProcType.b_b;
    }

%%%

