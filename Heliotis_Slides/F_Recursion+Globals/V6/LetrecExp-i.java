
LetrecExp
%%%
    // <exp>:LetrecExp     ::= LET <letrecDecls> IN <exp>

    public Val eval( Env env ) {
        Env newEnv = letrecDecls.makeEnv( env );
        return exp.eval( newEnv );
    }

    @Override
    public String toString() {
        return "let " + letrecDecls + " in " + exp;
    }
%%%
