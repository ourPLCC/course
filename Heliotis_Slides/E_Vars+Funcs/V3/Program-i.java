
Program
%%%
    public static Env initEnv = Env.ENV_NULL;

    @Override
    public String toString() {
        return exp.eval( initEnv ).toString();
    }

    public String toStringOld() {
	return exp.toString();
    }
%%%

