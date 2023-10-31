
TypeEnvNode
%%%

class TypeEnvNode extends TypeEnv {

    /**
     * local bindings
     */
    private final TypeBindings typeBindings;

    /**
     * next (outer) environment
     */
    private final TypeEnv outerEnv;

    public TypeEnvNode( TypeBindings typeBindings, TypeEnv outerEnv ) {
        this.typeBindings = typeBindings;
        this.outerEnv = outerEnv;
    }

    public Type applyTypeEnv( String sym ) {
        for ( TypeBinding b: this.typeBindings.typeBindingList ) {
            if ( b.sym.equals( sym ) ) return b.type;
        }
        return this.outerEnv.applyTypeEnv( sym );
    }

    public void addFirst( TypeBinding tb ) {
        typeBindings.addFirst( tb );
    }

}

%%%

