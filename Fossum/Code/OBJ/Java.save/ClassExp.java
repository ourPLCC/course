import java.util.*;
//ClassExp:import//

// <exp>:ClassExp ::= <classDecl>
public class ClassExp extends Exp {

    public ClassDecl classDecl;

    public ClassExp(ClassDecl classDecl) {
        this.classDecl = classDecl;
    }

    public static ClassExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ClassExp", scn$.lno);
        ClassDecl classDecl = ClassDecl.parse(scn$, trace$);
        return new ClassExp(classDecl);
    }

    public Val eval(Env env) {
        return classDecl.eval(env);
    }

//ClassExp//

}
