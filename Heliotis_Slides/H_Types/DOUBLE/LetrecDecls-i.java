
LetrecDecls:import
%%%
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;
%%%


LetrecDecls
%%%

    // <letDecls>       **= <VAR> ASSIGN <exp>

    public Env makeEnv( Env oldEnv ) {
        assert varList.size() == expList.size(): "AST is messed up";

        // Create an empty environment
        
        Env newEnv = oldEnv.extendEnv( null ); // ! no Bindings object

        // For each var-proc pair, make a new Binding
        // out of the corresponding token "lexeme" and expr evaluation.
        
        List< Binding > bindings = new LinkedList<>();
        Iterator< Token > varIter = varList.iterator();
        Iterator< Exp > expIter = expList.iterator();
        while ( varIter.hasNext() ) {
            String varName = varIter.next().str;
            Val procVal = expIter.next().eval( newEnv ); // !
            // ProcVal procVal = (ProcVal)expIter.next().eval( newEnv ); // !
            Binding binding = new Binding( varName, new ValRef( procVal ) );
            bindings.add( binding );
        }

        // Change the environment to add the Bindings.
        newEnv.replaceBindings( new Bindings( bindings ) ); // !
        return newEnv;
    }

    public TypeEnv addTypeBindings( TypeEnv tenv ) {
        // first check for duplicate LHS identifiers
        List< String > stringVarList = this.varList.stream()
                            .map( Token::toString )
                            .collect( Collectors.toList() );
        Type.checkDuplicates( stringVarList );
        // next get the defined type environment of the letrec,
        // ignoring the proc bodies for now
        List< Type > definedTypeList = new ArrayList< Type >();
        for ( Exp e: expList ) {
            if ( e instanceof ProcExp ) {
                ProcType pt = ((ProcExp)e).definedType();
                definedTypeList.add( pt );
            }
            else {
                definedTypeList.add( e.evalType( tenv ) );
            }
        }
        TypeBindings typeBindings = new TypeBindings(
                                            stringVarList, definedTypeList );
        TypeEnv ntenv = tenv.extendTypeEnv( typeBindings );
        // Finally check that the proc bodies are OK in the ntenv environment
        // We don't care about their types, just that there are no errors.
        for ( Exp e: expList ) {
             e.evalType( ntenv );
        }
        return ntenv;
    }
    


%%%
