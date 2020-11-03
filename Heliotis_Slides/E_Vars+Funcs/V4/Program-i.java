
Program
%%%
    public static Env initEnv = Env.ENV_NULL.extendEnv(
            new Bindings(Arrays.asList(
                new Binding( "i", new IntVal( 1 ) ),
                new Binding( "v", new IntVal( 5 ) ),
                new Binding( "x", new IntVal( 10 ) ),
                new Binding( "l", new IntVal( 50 ) ),
                new Binding( "c", new IntVal( 100 ) ),
                new Binding( "d", new IntVal( 500 ) ),
                new Binding( "m", new IntVal( 1000 ) )
            ))
    );

    @Override
    public String toString() {
        return exp.eval( initEnv ).toString();
    }

    public String toStringOld() {
	return exp.toString();
    }
%%%

