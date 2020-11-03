
Eval
%%%
    @Override
    public String toString() {
        String evaluation = null;
        try {
            evaluation = exp.eval( initEnv ).toString();
        }
        catch( Exception e ) { // Don't blow up rep.
            evaluation = e.getMessage();
        }
        return evaluation;
    }

%%%

