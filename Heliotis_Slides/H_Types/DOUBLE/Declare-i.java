
Declare
%%%
    // Note that this statement modifies the top-level type environment.
    @Override
    public String toString() {
        TypeEnv tenv = Program.initTypeEnv; // top-level type environment
        Type varType; // variable's declared type
        String sym = var.str;
        try {
            // Look up the variable in the top-level type environment.
            varType = tenv.applyTypeEnv( sym );
            throw new RuntimeException(
                            "duplicate variable declaration for " + sym );
        }
        catch ( RuntimeException e ) {
            /* THIS IS AWFUL CODING. Exception => All is GOOD? */
            // No type binding -- must be a new type declaration.
            varType = typeExpr.toType();
            tenv.addFirst( new TypeBinding( sym, varType ) );
            return sym + ": " + varType;
        }
    }
%%%

