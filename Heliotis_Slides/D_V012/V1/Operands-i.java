Operands:import
%%%
import java.util.stream.Collectors;
%%%

Operands
%%%
    /**
     * Fetch the values of each expression in the parameter (operands) list.
     */
    public List<Val> evalOperands( Env env ) {
        return expList.stream()
                            .map( exp -> exp.eval(env) )
                            .collect( Collectors.toList() );
    }

    public String toString() {
        return expList.stream()
                        .map( Exp::toString )
                        .collect( Collectors.joining( "," ) );
    }
%%%

