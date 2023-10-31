
Formals:import
%%%

import java.util.List;
import java.util.stream.Collectors;
%%%

Formals
%%%
    public List< Type > formalTypeList() {
        // First check for duplicate formal parameter names.
        List< String > stringVarList = varList.stream()
                                        .map( Token::toString )
                                        .collect( Collectors.toList() );
        Type.checkDuplicates( stringVarList );

        // Now collect the formals' types into a list.
        return typeExprList.stream()
                                .map( TypeExpr::toType )
                                .collect( Collectors.toList() );
    }

    public TypeBindings declaredTypeBindings() {
        List< String > stringVarList = varList.stream()
                                        .map( Token::toString )
                                        .collect( Collectors.toList() );
        List< Type > formalTypeList = formalTypeList();
        return new TypeBindings( stringVarList, formalTypeList );
    }

    @Override
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

