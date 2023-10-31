Ref
%%%

import java.util.ArrayList;
import java.util.List;

/**
 * The type that represents all indirectly referenced values
 */
public interface Ref {
    /**
     * Fetch the value to which this Ref is referring.
     */
    public abstract Val deRef();

    /**
     * Set/change the value to which this Ref refers.
     */
    public abstract Val setRef(Val v);

    /**
     * Handy utility to build new Refs for a list of Vals
     */
    public static List< Ref > valsToRefs( List< Val > valList ) {
        List< Ref > refList = new ArrayList< Ref >();
        for ( Val v : valList ) {
            refList.add( new ValRef( v ) );
        }
        return refList;
    }
}

%%%
