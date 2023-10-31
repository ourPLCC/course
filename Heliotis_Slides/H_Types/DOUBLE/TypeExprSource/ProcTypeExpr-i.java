
ProcTypeExpr
%%%
    public Type toType() {
        List< Type > paramTypeList = new ArrayList< Type >();
        for ( TypeExpr te : typeExprs.typeExprList )
            paramTypeList.add( te.toType() );
        Type returnType = retTypeExpr.toType();
        return new ProcType( paramTypeList, returnType );
    }

    @Override
    public String toString() {
        String result = "[";
        String sep = " ";
        for ( TypeExpr te : typeExprs.typeExprList ) {
            result += sep + te;
            sep = ", ";
        }
        return result + " => " + retTypeExpr + " ]";
    }
%%%
