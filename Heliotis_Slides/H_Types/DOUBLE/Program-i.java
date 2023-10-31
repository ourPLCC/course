
Program
%%%
    public static Env initEnv = Env.ENV_NULL.extendEnv(
            new Bindings( new LinkedList<>() )
    );

    public static TypeEnv initTypeEnv = TypeEnv.ENV_NULL.extendTypeEnv(
            new TypeBindings( new LinkedList<>() )
    );

%%%

