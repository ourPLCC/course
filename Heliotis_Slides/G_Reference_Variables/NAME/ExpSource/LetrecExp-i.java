
LetrecExp
%%%
    // <exp>:LetrecExp     ::= LETREC <letrecDecls> IN <exp>

    @Override
    public Val eval( Env env ) {
        Env newEnv = letrecDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

%%%
