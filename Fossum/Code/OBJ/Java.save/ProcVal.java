import java.util.*;

public class ProcVal extends Val {

    public Formals formals;
    public int nargs;
    public Exp body;
    public Env env;

    public ProcVal(Formals formals, Exp body, Env env) {
        this.formals = formals;
        this.nargs = formals.varList.size();
        this.body = body;
        this.env = env;
    }

    public Val apply(List<Val> valList) {
        if (valList.size() != nargs)
            throw new RuntimeException("formals/arguments number mismatch");
        List<Ref> refList = Ref.valsToRefs(valList);
        Bindings bindings = new Bindings(formals.varList, refList);
        Env nenv = env.extendEnvRef(bindings);
        return body.eval(nenv);
    }

    public ProcVal procVal() {
        return this;
    }

    public Env env() {
        return env;
    }

    public String toString() {
        String ret = "proc(";
        String sep = "";

        for (Token t : formals.varList) {
            String s = t.toString();
            ret += sep + s;
            sep = ",";
        }
        ret += ")";
        return ret;
    }
}
