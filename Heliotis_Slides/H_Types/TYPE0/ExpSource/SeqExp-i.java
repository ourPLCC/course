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
    public String toString() {
        String result = "{" + exp;
        for ( Exp e : seqExps.expList ) {
            result += ";" + e;
        }
        return result + "}";
    }

%%%
