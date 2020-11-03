ValRef
%%%

/**
 * References to regular old values
 */
public class ValRef implements Ref {

    private Val val;

    public ValRef( Val val ) {
        this.val = val;
    }

    @Override
    public Val deRef() {
        return val;
    }

    @Override
    public Val setRef( Val v ) {
        return val = v;
    }
}

%%%
