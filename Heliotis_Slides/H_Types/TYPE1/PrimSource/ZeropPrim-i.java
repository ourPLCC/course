ZeropPrim
%%%
    @Override
    public Val apply(Val [] vals) {
        if ( vals.length != 1 )
            throw new RuntimeException( "One argument expected." );
        int i0 = vals[0].intVal();
        return new BoolVal( i0 == 0 ? true: false );
    }

    @Override
    public String toString() {
	return "sub1";
    }

    @Override
    public ProcType definedType() {
        return PrimProcType.i_b;
    }

%%%

