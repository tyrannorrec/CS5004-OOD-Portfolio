package birds.attributes;

/* ******************************************************************************
 * Enum       FoodCategory
 * Purpose    Contains as constant values the categories of foods eaten by Birds.
 * ***************************************************************************** */
public enum FoodCategory {

    BERRIES("berries"),
    SEEDS("seeds"),
    FRUIT("fruit"),
    NUTS("nuts"),
    BUDS("buds"),
    VEGETATION("vegetation"),
    INSECTS("insects"),
    LARVAE("larvae"),
    EGGS("eggs"),
    AQUATIC_INVERTEBRATES("aquatic invertebrates"),
    FISH("fish"),
    SMALL_MAMMALS("small mammals"),
    OTHER_BIRDS ("other birds");

    /* -----------------------------------------------------------------------------
     * FoodCategory Enum Fields
     * ----------------------------------------------------------------------------*/
    private final String printableName;

    /* -----------------------------------------------------------------------------
     * Enum Constructor (implicitly private)
     * ----------------------------------------------------------------------------*/
    FoodCategory(String printableName) {
        this.printableName = printableName;
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the String value contained in 'printableName'
     * @param    None
     * @returns  (String) the name of the food category
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return printableName;
    }

} /* ****************************************************************************** */
