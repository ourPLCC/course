import java.util.*;
//NewExp:import//

// <exp>:NewExp ::= NEW <exp>
public class NewExp extends Exp {

    public Exp exp;

    public NewExp(Exp exp) {
        this.exp = exp;
    }

    public static NewExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:NewExp", scn$.lno);
        scn$.match(Token.Val.NEW, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new NewExp(exp);
    }

    public Val eval(Env env) {
        // get the class from which this object will be created
        Val val = exp.eval(env);
        // create a reference to a dummy value (nil)
        Ref objRef = new ValRef(Val.nil);
        // let the class create the object
        ObjectVal objectVal = val.makeObject(objRef);
        // set the reference to the newly created object
        return objRef.setRef(objectVal);
    }
//NewExp//

}
