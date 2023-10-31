
Define
%%%
    @Override
    public String toString() {

        Type expType = exp.evalType( Program.initTypeEnv );
        Type varType = null;
        try {
            /* ANOTHER LOUSY CODING PATTERN */
            varType = Program.initTypeEnv.applyTypeEnv( var.str );
        }
        catch ( Exception e ) {} // Type was not pre-declared

        if ( varType != null ) {
            varType.checkEquals( expType );
        }
        else {
            Program.initTypeEnv.addFirst( new TypeBinding( var.str, expType ) );
        }

        Val val = exp.eval( Program.initEnv );
        Program.initEnv.addFirst( new Binding( var.str, new ValRef( val ) ) );
        return var.str + " set to " + val;
    }

%%%

