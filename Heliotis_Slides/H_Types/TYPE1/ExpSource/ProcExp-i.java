ProcExp
%%%
    /**
     * Create the value of a procedure.
     * Remember, this is NOT calling the procedure!
     */
    @Override
    public Val eval( Env env ) {
        return new ProcVal( formals, exp, env );
    }

    /**
     * Compute the complete type of the proc in the current type
     * environment, ignoring the body's type.
     */
    public ProcType definedType() {
        return new ProcType( formals.formalTypeList(), retType.toType() );
    }

    /**
     * Compute the complete type of the proc in the current type
     * environment, AND make sure that the type to which the
     * proc body evaluates is the same as the return type.
     */
    @Override
    public Type evalType( TypeEnv tenv ) {
        ProcType procType = this.definedType();
        TypeBindings typeBindings = formals.declaredTypeBindings();
        TypeEnv newTenv = tenv.extendTypeEnv( typeBindings );
        Type bodyExpType = exp.evalType( newTenv );
        procType.returnType.checkEquals( bodyExpType );
        return procType;
    }

    @Override
    public String toString() {
        return "λ" + formals + " { return " + exp + " }";
    }
%%%

