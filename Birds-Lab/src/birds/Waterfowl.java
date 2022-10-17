package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     Waterfowl
 * Purpose   The Waterfowl class is a child class of AbstractBird, and represents
 *               a Bird in the classification "Waterfowl". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. Shorebird objects also have the additional variable 'environs'
 *               (WaterSource), which contains the type of water preferred by the
 *               Shorebird. A Shorebird obj can be either of type DUCK, SWAN, or
 *               GOOSE, drawn from the BirdType enum.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * @attrib   'environs'       --    (WaterSource) the type of water preferred by the Bird
 * ***************************************************************************** */
public class Waterfowl extends AquaticBird {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Waterfowl object of type DUCK, SWAN, or GOOSE.
     *           Initializes object with parent constructor, then
     *           assigns all other attributes based on the greater classification
     *           Shorebird and the lesser classification DUCK, SWAN, or GOOSE (BirdType).
     *           Also initializes 'environs', a Shorebird- and Waterfowl-specific attribute.
     * @param    'inType'     --    (BirdType)  subspecies of Bird
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public Waterfowl(BirdType inType, String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object and 'numOfWings' attribute
        super(inType, inName, inPreferredFoods);

        // check that input BirdType is of the right category; throw exception if bad type
        if (inType != BirdType.DUCK && inType != BirdType.SWAN && inType != BirdType.GOOSE) {
            throw new IllegalArgumentException("Only Ducks, Swans, and Geese are " +
                    "considered Waterfowl.");
        }

        // call function to check type and set this.environs to proper WaterSource
        this.initializeEnvirons();
    }

    /* -----------------------------------------------------------------------------
     * Method   `initializeEnvirons` sets this.environs to WaterSource enum type
     *              depending on the input BirdType. Called by constructor.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    protected void initializeEnvirons() {
        if (this.type == BirdType.DUCK) {
            this.setEnvirons(WaterSource.WETLANDS);
        }
        else if (this.type == BirdType.SWAN) {
            this.setEnvirons(WaterSource.WETLANDS);
        }
        else { // this.type == BirdType.GOOSE
            this.setEnvirons(WaterSource.WETLANDS);
        }
    }

} /* ****************************************************************************** */

