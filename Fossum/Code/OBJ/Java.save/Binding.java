public class Binding {

    public String id;
    public Ref ref;

    public Binding(String id, Ref ref) {
        this.id = id;
        this.ref = ref;
    }

    public String toString() {
        return "[" + id + "->" + ref.deRef().toString() + "]";
    }

}