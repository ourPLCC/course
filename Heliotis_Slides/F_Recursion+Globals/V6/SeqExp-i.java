SeqExp:import
%%%
import java.util.stream.Collectors;
%%%
SeqExp
%%%
public Val eval( Env env ) {
    Val v = exp.eval( env );
    for ( Exp e : seqExps.expList ) {
        v = e.eval( env );
    }
    return v;
}

@Override
public String toString() {
    return "{" + seqExps.expList.stream()
                                .map( Exp::toString )
                                .collect( Collectors.joining(";") ) + "}";
}
%%%
