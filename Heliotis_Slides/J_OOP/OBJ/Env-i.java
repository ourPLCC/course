# Environment-related classes

Env
%%%
import java.util.*;

public abstract class Env {

    public static final Env empty = new EnvNull();

    public abstract Env add(Binding b);

    public static void checkDuplicates(List<Token> varList, String msg) {
        // throws an exeption if the varList has duplicate vars
        Set<String> varSet = new HashSet<String>(2*varList.size());
        for (Token var: varList) {
            String str = var.toString();
            if (varSet.contains(str)) {
                msg = "duplicate ID " + str + msg;
                throw new PLCCException("Semantic error",  msg);
            }
            varSet.add(str);
        }
    }

    public static void checkDuplicates(List<Token> varList) {
        checkDuplicates(varList, "");
    }

    public static Env initEnv() {
        // Create bindings for some symbols
        return new EnvNode(new Bindings(), empty);
    }

    public abstract Binding lookup(String sym, boolean local);

    public Binding lookup(String sym) {
        return lookup(sym, true); // defaults to local
    }

    public Ref applyEnvRef(String sym) {
        Binding b = lookup(sym, false);
        if (b != null)
            return b.ref;
        throw new PLCCException("no binding for "+sym);
    }

    public Ref applyEnvRef(Token tok) {
        return applyEnvRef(tok.toString());
    }

    public Val applyEnv(String sym) {
        return applyEnvRef(sym).deRef();
    }

    public Val applyEnv(Token tok) {
        return applyEnvRef(tok.toString()).deRef();
    }

    public Env extendEnvRef(Bindings bindings) {
        return new EnvNode(bindings, this);
    }

    public abstract Bindings getBindings();

    public abstract String toString(int n);

}
%%%

EnvNode
%%%
import java.util.*;

public class EnvNode extends Env {

    public Bindings bindings; // list of local bindings
    public Env env;           // next set of bindings

    // create an environment
    public EnvNode(Bindings bindings, Env env) {
        this.bindings = bindings;
        this.env = env;
    }

    public Bindings getBindings() {
        return bindings;
    }

    public Binding lookup(String sym, boolean local) {
        Binding b = bindings.lookup(sym);
        if (b != null)
            return b;
        if (local)
            return null;
        return env.lookup(sym, false);
    }

    public Env add(Binding b) {
        bindings.add(b);
        return this;
    }

    public String toString(int n) {
        return n + ":" + bindings.toString() + "\n" + env.toString(n+1);
    }

    public String toString() {
        return bindings.toString() + "----\n" + env;
    }

}
%%%

EnvNull
%%%
import java.util.*;

public class EnvNull extends Env {

    // create an environment
    public EnvNull() {
    }

    public Binding lookup(String sym, boolean local) {
        return null;
    }

    public Bindings getBindings() {
        throw new PLCCException("no bindings");
    }

    public Env add(Binding b) {
        throw new PLCCException("no bindings to add to");
    }

    public String toString(int n) {
        return n + ":\n";
    }

    public String toString() {
        return "\n";
    }
}
%%%

Binding
%%%
public class Binding {

    public String id;
    public Ref ref;

    public Binding(String id, Ref ref) {
        this.id = id;
        this.ref = ref;
    }

    public String toString() {
        return "[" + id + ":" + ref.deRef().toString() + "]";
    }

}
%%%

Bindings
%%%
import java.util.*;

public class Bindings {

    public List<Binding> bindingList;

    // create an empty list of bindings
    public Bindings() {
        bindingList = new ArrayList<Binding>();
    }

    public Bindings(List<Binding> bindingList) {
        this.bindingList = bindingList;
    }

    public Binding lookup(String sym) {
        for (Binding b: bindingList)
            if (sym.equals(b.id))
                return b;
        return null;
    }

    // idList is a list of Tokens/Strings (whatever has a toString())
    // valList is a list of Vals
    public Bindings(List<?> idList, List<Ref> refList) {
        bindingList = new ArrayList<Binding>();
        Iterator<?> idIter = idList.iterator();
        Iterator<Ref> refIter = refList.iterator();
        while (idIter.hasNext()) {
            String s = idIter.next().toString();
            Ref r = refIter.next();
            this.add(new Binding(s, r));
        }
    }

    public void add(Binding b) {
        bindingList.add(b);
    }

    public void add(String s, Ref r) {
        add(new Binding(s, r));
    }

    public int size() {
        return bindingList.size();
    }

    public String toString() {
        String s = "";
        for (Binding b : bindingList)
            s += b + "\n";
        return s;
    }
}
%%%
