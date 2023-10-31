
TypeEnv
%%%

import java.util.List;

abstract class TypeEnv {

    public abstract Type applyTypeEnv( String sym );

    public TypeEnv extendTypeEnv( TypeBindings typeBindings ) {
        return new TypeEnvNode( typeBindings, this );
    }

    public TypeEnv extendTypeEnv(
                            List< String > idList,
                            List< Type > typeList
    ) {
        return extendTypeEnv( new TypeBindings( idList, typeList ) );
    }

    public abstract void addFirst( TypeBinding tb );

    public static final TypeEnv ENV_NULL = new TypeEnvNull();

    /**
     * empty type environment class
     */
    private static class TypeEnvNull extends TypeEnv {

        @Override
        public Type applyTypeEnv( String sym ) {
            throw new RuntimeException( "No type binding for " + sym );
        }

        @Override
        public void addFirst( TypeBinding tb ) {
            throw new RuntimeException(
                                "Cannot add TypeBinding to TypeEnvNull" );
        }

    }
}

%%%

