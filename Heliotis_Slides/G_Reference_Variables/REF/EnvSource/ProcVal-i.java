ProcVal
%%%%

import java.util.List;
import java.util.stream.Collectors;

/**
 * An object representing a procedure (actually a closure) at run time.
 */
public class ProcVal implements Val {

    /** The list of parameter names */
    private Formals formals;

    /**
     * The expression that is evaluated when the procedure is called.
     * body refers to a node in the parse tree.
     */
    private Exp body;

    /**
     * The environment in which the body is evaluated.
     * (Thus the name <i>closure</i>.)
     */
    private Env env;

    /** Construct a new procedure with the given data. */
    public ProcVal( Formals formals, Exp body, Env env ) {
        this.formals = formals;
        this.body = body;
        this.env = env;
    }

    /**
     * Return a representation of this procedure using
     * comfortable syntax.
     * We don't usually show the closure's environment because
     * it can get into an infinite loop once we have recursive
     * functions.
     */
    @Override
    public String toString() {
        return "λ" + formals + "{return " + body + "}";
    }

    /**
     * Apply (&quot;call&quot;) this procedure to a given list of arguments.
     * @param args the actual arguments (already evaluated)
     * @param e not used at this time
     */
    public Val apply( List< Ref > argRefs, Env e ) {
        List< String > varNameList =
            formals.varList.stream()
                            .map( Token::toString )
                            .collect( Collectors.toList() );
        Bindings bindings = new Bindings( varNameList, argRefs );
        Env newEnv = env.extendEnv( bindings );
        return body.eval( newEnv );
    }
}

%%%%
