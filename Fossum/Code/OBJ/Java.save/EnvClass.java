import java.util.*;

public class EnvClass extends ClassVal {

    public static EnvClass envClass = new EnvClass(Program.initEnv);

    public Env staticEnv;

    public EnvClass(Env env) {
        staticEnv = env; // the environment inherited by all subclasses
    }

    public Env env() {
        return staticEnv;
    }

    // Observe that the environment of objects created with 'new ...'
    // always end up extending the static environment of this class.
    // The 'objRef' reference will eventually be set to the object
    // being created.
    public ObjectVal makeObject(Ref objRef) {
        // start with the static environment of this class
        Env env = staticEnv;
        // add the field binding 'self' to refer to the base object (deep)
        Bindings fieldBindings = new Bindings();
        env = env.extendEnvRef(fieldBindings); // this object's environment
        fieldBindings.add("self", objRef);                // deep
        return new ObjectVal(env);
    }

    public String toString() {
        // return "class:" + staticEnv.getDepth();
        return "class";
    }

}