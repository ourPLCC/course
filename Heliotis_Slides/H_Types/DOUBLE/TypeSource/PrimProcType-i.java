        
PrimProcType
%%%
import java.util.List;

public class PrimProcType {


    private static List< Type > iTypes1 = List.of( IntType.TYPE );
    private static List< Type > bTypes1 = List.of( BoolType.TYPE );
    private static List< Type > iTypes2 = List.of( IntType.TYPE, IntType.TYPE );
    private static List< Type > bTypes2 =
                                    List.of( BoolType.TYPE, BoolType.TYPE );
    private static List< Type > dTypes2 =
                                    List.of( DoubleType.TYPE, DoubleType.TYPE );

    // For primitive procedures' types
    public static ProcType dd_d = new ProcType( dTypes2, DoubleType.TYPE );
    public static ProcType ii_i = new ProcType( iTypes2, IntType.TYPE );
    public static ProcType i_i = new ProcType( iTypes1, IntType.TYPE );
    public static ProcType i_b = new ProcType( iTypes1, BoolType.TYPE );
    public static ProcType ii_b = new ProcType( iTypes2, BoolType.TYPE );
    public static ProcType b_b = new ProcType( bTypes1, BoolType.TYPE );
    public static ProcType bb_b = new ProcType( bTypes2, BoolType.TYPE );

}

%%%
