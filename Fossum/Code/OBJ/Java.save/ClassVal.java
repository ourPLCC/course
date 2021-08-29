
public abstract class ClassVal extends Val {

    public abstract ObjectVal makeObject(Ref objRef);

    public ClassVal classVal() {
        return this;
    }

    public boolean isClass() {
        return true;
    }
}
