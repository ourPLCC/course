
Prim
%%%
    /**
     * Apply this primitive (whatever it is) to the provided values.
     */
    public abstract Val apply( Val[] vals );

    /**
     * Return the parameter types and return type for this primitive.
     * It must be hand-coded for each primitive.
     */
    public abstract ProcType definedType();
%%%
