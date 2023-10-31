
LetExp
%%%
    // <exp>:LetExp     ::= LET <letDecls> IN <exp>

    public Val eval( Env env ) {
        Env newEnv = letDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

    @Override
    public String toString() {
        return "let " + letDecls + " in " + exp;
    }

%%%
