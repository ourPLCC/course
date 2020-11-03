
LetrecExp
%%%
    // <exp>:LetrecExp     ::= LET <letrecDecls> IN <exp>

    @Override
    public Val eval( Env env ) {
        Env newEnv = letrecDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

%%%
