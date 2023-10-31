
AndPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 2 )
            throw new RuntimeException( "Two arguments expected." );
        boolean b0 = vals[ 0 ].boolVal();
        boolean b1 = vals[ 1 ].boolVal();
        return new BoolVal( b0 && b1 );
    }

    @Override
    public String toString() {
	return "and";
    }

    @Override
    public ProcType definedType() {
        return PrimProcType.bb_b;
    }

%%%

