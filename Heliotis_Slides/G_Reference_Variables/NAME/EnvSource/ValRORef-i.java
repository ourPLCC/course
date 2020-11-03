ValRORef
%%%

/**
 * References to regular old values
 */
public class ValRORef implements Ref {

    private Val val;

    public ValRORef( Val val ) {
        this.val = val;
    }

    @Override
    public Val deRef() {
        return val;
    }

    @Override
    public Val setRef( Val v ) {
        throw new RuntimeException( "Attempt to setRef of ValRORef" );
    }
}

%%%
