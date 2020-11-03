
ProcTypeExpr
%%%
    public Type toType() {
        return null;
        /*
        // for TYPE1
        List< Type > paramTypeList = new ArrayList< Type >();
        for ( TypeExp te : typeExprs.typeExpList )
            paramTypeList.add( te.toType() );
        Type returnType = retType.toType();
        return new ProcType( paramTypeList, returnType );
        */
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
