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

    // idList is a list of Tokens/Strings
    // refList is a list of Refs
    public Bindings(List<?> idList, List<Ref> refList) {
        bindingList = new ArrayList<Binding>();
        Iterator<?> idIterator = idList.iterator();
        Iterator<Ref> refIterator = refList.iterator();
        while (idIterator.hasNext()) {
            String id = idIterator.next().toString();
            Ref ref = refIterator.next();
            bindingList.add(new Binding(id, ref));
        }
    }

    public void add(String s, Ref r) {
        bindingList.add(new Binding(s, r));
    }

    public void addFirst(Binding b) {
        bindingList.add(0,b);
    }

    public void add(Binding b) {
        bindingList.add(b);
    }

    public int size() {
        return bindingList.size();
    }

    public String toString() {
        String s = "";
        for (Binding b : bindingList)
            s += " " + b;
        return s;
    }
}