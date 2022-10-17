package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     Shorebird
 * Purpose   The Shorebird class is a child class of AquaticBird, and represents
 *               a Bird in the classification "Shorebird". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. Shorebird objects also have the additional variable 'environs'
 *               (WaterSource), which contains the type of water preferred by the
 *               Shorebird. A Shorebird obj can be either of type GREAT_AUK,
 *               HORNED_PUFFIN, or AFRICAN_JACANA, drawn from the BirdType enum.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * @attrib   'environs'       --    (WaterSource) the type of water preferred by the Bird
 * ***************************************************************************** */
public class Shorebird extends AquaticBird {

    private WaterSource environs;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Shorebird object of type GREAT_AUK, HORNED_PUFFIN, or --
     *           AFRICAN_JACANA. Initializes object with parent constructor, then
     *           assigns all other attributes based on the greater classification
     *           Shorebird and the lesser classification GREAT_AUK, HORNED_PUFFIN,
     *           or AFRICAN_JACANA (BirdType). Also initializes 'environs', a
     *           Shorebird- and Waterfowl- specific attribute.
     * @param    'inType'     --    (BirdType)  subspecies of Bird
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public Shorebird(BirdType inType, String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object and 'numOfWings' attribute
        super(inType, inName, inPreferredFoods);

        // check that input BirdType is of the right category; throw exception if bad type
        if (inType != BirdType.GREAT_AUK && inType != BirdType.HORNED_PUFFIN && inType != BirdType.AFRICAN_JACANA) {
            throw new IllegalArgumentException("Only Great Auks, Horned Puffins, and African Jacanas are " +
                    "considered Shorebirds.");
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

        if (this.type == BirdType.GREAT_AUK) {
            this.setEnvirons(WaterSource.OCEAN);
        }
        else if (this.type == BirdType.HORNED_PUFFIN) {
            this.setEnvirons(WaterSource.OCEAN);
        }
        else { // this.type == BirdType.AFRICAN_JACANA
            this.setEnvirons(WaterSource.WETLANDS);
        }
    }

} /* ****************************************************************************** */

