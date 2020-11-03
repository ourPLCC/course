
Define
%%%
    @Override
    public String toString() {
        Val val = exp.eval( Program.initEnv );
        Program.initEnv.addFirst( new Binding( var.str, new ValRef( val ) ) );
        return var.str + " set to " + val;
    }

%%%

