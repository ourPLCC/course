ProcExp
%%%
    /**
     * Create the value of a procedure.
     * Remember, this is NOT calling the procedure!
     */
    @Override
    public Val eval( Env env ) {
        return new ProcVal( formals, exp, env );
        // return proc.makeClosure( env );
    }

    /** 
     * Create a Ref for this expression's value.
     * procs cannot be modified.
     */
    @Override
    public Ref evalRef( Env env ) {
        return new ValRORef( this.eval( env ) );
    }

    @Override
    public String toString() {
        return "λ" + formals + " { return " + exp + " }";
        // return proc.toString();
    }
%%%

