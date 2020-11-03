
IntType
%%%

class IntType extends Type {

    public static Type TYPE = new IntType();

    @Override
    public void checkEquals( Type t ) {
        t.checkIntType( this );
    }

    @Override
    public void checkIntType( Type t ) {}
}

%%%

