
ListExp:import
%%%
import java.util.List;
import java.util.Collections;
%%%


ListExp

%%%

    @Override
    public Val eval( Env env ) {
        Val result = new NullVal();
        List< Val > elements = operands.evalOperands( env );
        Collections.reverse( elements );
        ProcVal prepend = (ProcVal)env.applyEnv( "prepend" );
        for ( Val v: elements ) {
            List< Val > args = List.of( v, result );
            result = prepend.apply( args, env );
        }
        return result;
    }

%%%
