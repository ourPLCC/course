
LetrecExp
%%%
    // <exp>:LetrecExp     ::= LET <letrecDecls> IN <exp>

    @Override
    public Val eval( Env env ) {
        Env newEnv = letrecDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        TypeEnv newTenv = letrecDecls.addTypeBindings( tenv );
        return exp.evalType( newTenv );
    }

%%%
