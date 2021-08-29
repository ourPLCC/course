
public class ValRORef extends Ref {

    public Val val;

    public ValRORef(Val val) {
        this.val = val;
    }

    public Val deRef() {
        return val;
    }

    public Val setRORef(Val v) {
        return val = v;
    }

}
