package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     AquaticBird
 * Purpose   The AquaticBird class extends AbstractBird, and is the parent class
 *               of all Birds whose habitat is near water (Shorebird and Waterfowl).
 *               AquaticBird objects have the additional variable 'environs'
 *               (WaterSource), which contains the type of water preferred by the
 *               AquaticBird, as well as methods pertaining to this attribute.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * @attrib   'environs'       --    (WaterSource) the type of water preferred by the Bird
 * ***************************************************************************** */
public abstract class AquaticBird extends AbstractBird {

    private WaterSource environs;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Initializes the attributes of an AquaticBird.
     * @param    'inType'     --    (BirdType)  subspecies of Bird
     * @param    'inName'     --    (String)    name of the Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public AquaticBird(BirdType inType, String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object
        super(inType, inName, inPreferredFoods);
    }

    /* -----------------------------------------------------------------------------
     * Method   `initializeEnvirons` sets this.environs to WaterSource enum type
     *              depending on the input BirdType. Overridden by child classes.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    protected abstract void initializeEnvirons();

    /* -----------------------------------------------------------------------------
     * Method   `getEnvirons` returns the type of water environment preferred by
     *              the BirdType.
     * @param    None
     * @returns  (WaterSource) either WETLANDS or OCEAN, of the Watersource enum type
     * ----------------------------------------------------------------------------*/
    public WaterSource getEnvirons() {
        return this.environs;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setEnvirons` sets the type of water environment preferred by
     *              the BirdType.
     * @param    'inEnvirons'   --  (WaterSource)   new WaterSource
     * @returns  None
     * ----------------------------------------------------------------------------*/
    protected void setEnvirons(WaterSource inEnvirons) {
        this.environs = inEnvirons;
    }

    /* -----------------------------------------------------------------------------
     * Method   `equals` returns true if all attributes of two AquaticBirds match, and
     *              false if they do not match. Overrides AbstractBird equals method.
     * @param    None
     * @returns  (boolean) true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) return false;

        // Check for AutomaticTransmission Class; cast and rename if true
        if (!(obj instanceof AquaticBird)) {
            throw new IllegalArgumentException("Argument must be an instance " +
                    "of the AquaticBird class hierarchy; i.e. either a Shorebird " +
                    "or a Waterfowl.");
        }

        // If all vars equivalent, return true. Else, return false
        AquaticBird other = (AquaticBird) obj;
        return this.environs == other.environs;
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns a String containing most of a Waterfowl's attributes,
     *           to print. Overrides AbstractBird class 'toString' method.
     *           Does not include numOfWings and isExtinct attributes.
     * @param    None
     * @returns  (String) contains all values of a Waterfowl's attributes
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return ("-----------------------------------------------------------------------\n" +
                "Name:            " + this.name + "\n" +
                "Type:            " + this.type + "\n" +
                "Environment:     " + this.environs + "\n" +
                "Preferred Foods: " + this.preferredFoods + "\n\n" +
                "Description:\n" + this.description + "\n" +
                "-----------------------------------------------------------------------\n" );
    }

} /* ****************************************************************************** */
