PrimAppExp:import
%%%
import java.util.Arrays;
%%%

PrimAppExp
%%%
    @Override
    public Val eval( Env env ) {
        // evaluate the terms in the expression list
        // and apply the prim to the array of Vals
        List<Val> args = operands.evalOperands( env );
        Val [] va = args.toArray( new Val[ args.size() ] );
        return prim.apply( va );
    }

    @Override
    public Type evalType( TypeEnv tenv ) {
        ProcType pt = prim.definedType();

        // Before returning an answer, make sure operands are good.
        List< Type > argTypeList = operands.evalTypeOperands( tenv );
        Type.checkEqualTypes( pt.paramTypeList, argTypeList );

        return pt.returnType;
    }

    @Override
    public String toString() {
	return prim + "(" + operands + ")";
    }
%%%

