PrimAppExp:import
%%%
import java.util.Arrays;
%%%

PrimAppExp
%%%
    public Val eval( Env env ) {
        // evaluate the terms in the expression list
        // and apply the prim to the array of Vals
        List<Val> args = operands.evalOperands( env );
        Val [] va = args.toArray( new Val[ args.size() ] );
        return prim.apply( va );
    }

    public String toString() {
	return prim + "(" + operands + ")";
    }
%%%

