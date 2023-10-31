
ProcType
%%%

import java.util.List;

class ProcType extends Type {
    public final List< Type > paramTypeList;
    public final Type returnType;

    public ProcType( List< Type > paramTypeList, Type returnType ) {
        this.paramTypeList = paramTypeList;
        this.returnType = returnType;
    }

    @Override
    public void checkEquals( Type t ) {
        t.checkProcType( this );
    }

    /**
     * check to see if the type of the ProcType object t is the same
     * as this ProcType object.
     */
    @Override
    public void checkProcType( Type t ) {
        ProcType pt = (ProcType)t;
        // first check the return types.
        this.returnType.checkEquals( pt.returnType );
        // then check the types of the formal parameters
        Type.checkEqualTypes( this.paramTypeList, pt.paramTypeList );
    }

    /**
     * Just make sure this is a ProcType.
     * (Done before doing a cast.)
     */
    public void checkProcType() {}

    @Override
    public String toString() {
        String result = "[";
        String sep = " ";
        for ( Type t : paramTypeList ) {
            result += sep + t;
            sep = ", ";
        }
        return result + " => " + returnType + " ]";
    }

}

%%%

