
NEpPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 2 )
            throw new RuntimeException( "Two arguments expected." );
        int i0 = vals[ 0 ].intVal();
        int i1 = vals[ 1 ].intVal();
        return new BoolVal( ( i0 != i1 ) ? true: false );
    }

    @Override
    public String toString() {
	return "!=?";
    }

    @Override
    public ProcType definedType() {
        return PrimProcType.ii_b;
    }

%%%

