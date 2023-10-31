
TypeBinding
%%%

class TypeBinding {

    public final String sym;

    public final Type type;

    public TypeBinding( String sym, Type type ) {
        this.sym = sym;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + this.sym + ',' + this.type + ')';
    }
}

%%%

