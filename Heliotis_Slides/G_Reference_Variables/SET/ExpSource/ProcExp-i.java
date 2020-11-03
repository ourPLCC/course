ProcExp
%%%
    /**
     * Create the value of a procedure.
     * Remember, this is NOT calling the procedure!
     */
    public Val eval( Env env ) {
        return new ProcVal( formals, exp, env );
        // return proc.makeClosure( env );
    }

    @Override
    public String toString() {
        return "λ" + formals + " { return " + exp + " }";
        // return proc.toString();
    }
%%%

