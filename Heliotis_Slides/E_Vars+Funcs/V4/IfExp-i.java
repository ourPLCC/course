
IfExp
%%%
    @Override
    public String toString() {
        return test + " ? " + thenPart + " : " + elsePart;
    }
    @Override
    public Val eval( Env env ) {
        return test.eval( env ).isTrue() ? thenPart.eval( env ) : elsePart.eval( env );
    }
%%%

