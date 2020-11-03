
BoolType
%%%

class BoolType extends Type {

    public static Type TYPE = new BoolType();

    @Override
    public void checkEquals( Type t ) {
        t.checkBoolType( this );
    }

    @Override
    public void checkBoolType( Type t ) {}

}

%%%

