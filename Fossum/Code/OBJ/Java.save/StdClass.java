import java.util.*;

public class StdClass extends ClassVal {

    public ClassVal superClass;  // an EnvClass (top-level) or a StdClass
    public Bindings staticBindings;
    public Fields fields;
    public Methods methods;
    public Env staticEnv;

    public StdClass(
            Env env,             // the environment where this class is created
            ClassVal superClass, // evaluated by ClassExp
            Statics statics,     // static variable definitions
            Fields fields,       // field declarations
            Methods methods) {   // method definitions
        this.superClass = superClass;
        this.fields = fields;
        this.methods = methods;
	// my static environment starts with the superclass environment
        staticEnv = superClass.env();
        // the staticBindings field is used to create instances of this class
        staticBindings = new Bindings();
        staticEnv = staticEnv.extendEnvRef(staticBindings);
        // initially create bindings for these static symbols ...
        staticBindings.add("!@", new ValRef(new ObjectVal(env))); // not a var
        staticBindings.add("myclass", new ValRef(this));
        staticBindings.add("superclass", new ValRef(superClass));
        // The static RHS expressions are evaluated in the modified
        // staticEnv that includes the bindings for myclass, superclass.
        // New static bindings are added as they are created,
        // as in top-level defines
        statics.addStaticBindings(staticBindings, staticEnv);
    }

    public Env env() {
        return staticEnv;
    }

    public ObjectVal makeObject(Ref objRef) {
        // System.err.println("... in makeObject ...");
        // create the parent object first (recursively)
        ObjectVal parent = superClass.makeObject(objRef);

        // this object's environment extends the parent object's environment
        Env env = parent.objectEnv;

        // add this class's static bindings (including those for myclass, etc)
        env = env.extendEnvRef(staticBindings);

        // the fields come next
        Bindings fieldBindings = new Bindings();
        env = env.extendEnvRef(fieldBindings);
        // bind all of this object's instance fields to nil
        for (Token t : fields.varList) {
              String s = t.toString();
              fieldBindings.add(s, new ValRef(Val.nil));
        }
        // bind all this object's methods as in letrec
        // don't add any bindings if there are no method declarations
        if (methods.varList.size() > 0) {
            LetrecDecls methodDecls =
                new LetrecDecls(methods.varList, methods.procList);
            env = methodDecls.addBindings(env);
        }

        // create the object and return it
        // bind 'super' field to the parent object
        fieldBindings.add("super", new ValRef(parent)); // parent object
        // bind 'self' field to the base object being created
        // (to speed up lookups)
        fieldBindings.add("self", objRef); // deep
        // bind 'this' field to this object environment
        ObjectVal objectVal = new ObjectVal(env);
        fieldBindings.add("this", new ValRef(objectVal)); // shallow
        return objectVal;
    }

    public String toString() {
        return "class";
    }

}