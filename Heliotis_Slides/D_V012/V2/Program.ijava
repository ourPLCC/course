
Program
%%%
    public static Env initEnv = Env.ENV_NULL.extendEnv(
            new Bindings(Arrays.asList(
                new Binding( "i", new Val( 1 ) ),
                new Binding( "v", new Val( 5 ) ),
                new Binding( "x", new Val( 10 ) ),
                new Binding( "l", new Val( 50 ) ),
                new Binding( "c", new Val( 100 ) ),
                new Binding( "d", new Val( 500 ) ),
                new Binding( "m", new Val( 1000 ) )
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

