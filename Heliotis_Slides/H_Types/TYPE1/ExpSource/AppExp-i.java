AppExp:import
%%%
import java.util.List;
%%%

AppExp
%%%
    /**
     * Compute the value of a procedure call.
     */
    public Val eval( Env env ) {
        Val v = null;
        try {
            v = exp.eval( env ); // Fetch the proc itself.
            ProcVal pv = (ProcVal)v;
            List< Ref > args = operands.evalOperandsRef( env );
            // Have the ProcVal execute its body.
            return pv.apply( args, env );
        }
        catch( ClassCastException cce ) {
            throw new RuntimeException( v.getClass() + " is not a proc." );
        }
    }

    /**
     * Make sure
     * (a) this expression really is a proc, and
     * (b) the arguments' types match the proc's formals' types.
     */
    @Override
    public Type evalType( TypeEnv tenv ) {
        Type tt = exp.evalType( tenv );
        tt.checkProcType(); // make sure tt is a ProcType
        ProcType pt = (ProcType)tt;
        List< Type > argTypeList = operands.evalTypeOperands( tenv );
        Type.checkEqualTypes( pt.paramTypeList, argTypeList );
        return pt.returnType;
    }

    @Override
    public String toString() {
        return "CALL [" + exp + "](" + operands + ")";
    }
%%%

