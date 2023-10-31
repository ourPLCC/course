
IfExp
%%%
    @Override
    public String toString() {
        return test + " ? " + thenPart + " : " + elsePart;
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        Type testType = test.evalType( tenv );
        testType.checkEquals( BoolType.TYPE );
        Type thenType = thenPart.evalType( tenv );
        thenType.checkEquals( elsePart.evalType( tenv ) );
        return thenType;
    }

    @Override
    public Val eval( Env env ) {
        return test.eval( env ).boolVal() ? thenPart.eval( env ) : elsePart.eval( env );
    }
%%%

