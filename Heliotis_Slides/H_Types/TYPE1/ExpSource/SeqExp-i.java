SeqExp
%%%
    @Override
    public Val eval( Env env ) {
        Val v = exp.eval( env );
        for ( Exp e : seqExps.expList ) {
            v = e.eval( env );
        }
        return v;
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        Type t = exp.evalType( tenv );
        for ( Exp e : seqExps.expList ) {
            t = e.evalType( tenv );
        }
        return t;
    }

    @Override
    public String toString() {
        String result = "{" + exp;
        for ( Exp e : seqExps.expList ) {
            result += ";" + e;
        }
        return result + "}";
    }

%%%
