import java.util.*;

public class ObjectVal extends Val {

    public Env objectEnv;     // this object's environment

    public ObjectVal(Env env) {
        this.objectEnv = env;
    }

    public ObjectVal objectVal() {
        return this;
    }

    public boolean isObject() {
        return true;
    }

    public Env env() {
        return objectEnv;
    }

    public String toString() {
        return "object";
    }

}