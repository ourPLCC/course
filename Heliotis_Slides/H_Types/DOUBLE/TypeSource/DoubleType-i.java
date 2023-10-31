
DoubleType
%%%

class DoubleType extends Type {

    public static Type TYPE = new DoubleType();

    @Override
    public void checkEquals( Type t ) {
        t.checkDoubleType( this );
    }

    @Override
    public void checkDoubleType( Type t ) {}
}

%%%

