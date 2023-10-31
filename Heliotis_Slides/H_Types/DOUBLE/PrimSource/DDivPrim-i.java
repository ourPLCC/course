
DDivPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 2 )
            throw new RuntimeException( "Two arguments expected." );
        double i0 = vals[ 0 ].doubleVal();
        double i1 = vals[ 1 ].doubleVal();
        if ( i1 == 0.0 ) {
            throw new RuntimeException( "Divide by zero." );
        }
        return new DoubleVal( i0 / i1 );
    }

    @Override
    public String toString() {
	return "/";
    }

    @Override
    public ProcType definedType() {
        return PrimProcType.dd_d;
    }

%%%


