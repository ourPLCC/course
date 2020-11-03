
LetExp
%%%
    // <exp>:LetExp     ::= LET <letDecls> IN <exp>

    @Override
    public Val eval( Env env ) {
        Env newEnv = letDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        TypeEnv newTenv = letDecls.addTypeBindings( tenv );
        return exp.evalType( newTenv );
    }


%%%
