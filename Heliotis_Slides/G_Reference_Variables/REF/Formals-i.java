
Formals
%%%
    // The real work is handled directly in the Proc class.

    public String toString() {
        String formals = "(";
        String sep = "";
        for ( Token v : varList ) {
            formals += sep + v;
            sep = ",";
        }
        return formals + ")";
    }
%%%

