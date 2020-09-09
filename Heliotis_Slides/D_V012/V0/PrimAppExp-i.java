PrimAppExp
%%%
    public String toString() {
	return prim + "(" + operands + ")";
    }

    /**
     * Alternative format that puts the operator in between
     * the operands
     */
    public String toStringAlternate() {
        int primLen = prim.toString().length();
        String result = "(";
        for ( Exp e: operands.expList ) {
            result += " " + e + ' ' + prim;
        }
        return result.substring( 0, result.length() - primLen ) + ')';
    }
%%%

