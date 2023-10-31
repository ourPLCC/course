
Type
%%%

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class Type {

    public void typeMismatch( Type otherType ) {
        throw new RuntimeException(
                    "Type mismatch, " + this + " and " + otherType );
    }

    public abstract void checkEquals( Type t );

    public void checkBoolType( Type t ) {
        typeMismatch( t );
    }

    public void checkDoubleType( Type t ) {
        typeMismatch( t );
    }

    public void checkIntType( Type t ) {
        typeMismatch( t );
    }

    public void checkProcType( Type t ) {
        typeMismatch( t );
    }

    /**
     * Just make sure this is a ProcType.
     * (Done before doing a cast.)
     */
    public void checkProcType() {
        throw new RuntimeException( this + ": not a proc type." );
    }

    public static void checkEqualTypes(
                        List< Type > t1List, List< Type > t2List) {
        if ( t1List.size() != t2List.size() ) {
            throw new RuntimeException( "Param/operand list size mismatch" );
        }
        Iterator<Type> t1i = t1List.iterator();
        Iterator<Type> t2i = t2List.iterator();
        while ( t1i.hasNext() ) {
            Type t1 = t1i.next();
            Type t2 = t2i.next();
            t1.checkEquals(t2);
        }
    }

    /**
     * Check a variable list for duplicates.
     * Throw an exception if the argument list repeats any variable names.
     * This is a utility function used by several other grammatical elements.
     */
    public static void checkDuplicates( List< String > idList ) {
        Set< String > idSet = new HashSet<>();
        for ( String id: idList ) {
            if ( idSet.contains( id ) ) {
                throw new RuntimeException(
                            "duplicate identifier '" + id + "'" );
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}

%%%

