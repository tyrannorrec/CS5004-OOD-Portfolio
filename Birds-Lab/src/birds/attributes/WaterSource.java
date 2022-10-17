package birds.attributes;

/* ******************************************************************************
 * Enum       WaterSource
 * Purpose    Contains as constant values the types of water bodies preferred by
 *                aquatic birds.
 * ***************************************************************************** */
public enum WaterSource {

    WETLANDS("Wetlands"),
    OCEAN("Ocean");

    /* -----------------------------------------------------------------------------
     * WaterSource Enum Fields
     * ----------------------------------------------------------------------------*/
    private final String printableName;

    /* -----------------------------------------------------------------------------
     * Enum Constructor (implicitly private)
     * ----------------------------------------------------------------------------*/
    WaterSource(String printableName) {
        this.printableName = printableName;
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the String value contained in 'printableName'
     * @param    None
     * @returns  (String) the name of the water source
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return printableName;
    }

} /* ****************************************************************************** */

