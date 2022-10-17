package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     BirdOfPrey
 * Purpose   The BirdOfPrey class is a child class of AbstractBird, and represents
 *               a Bird in the classification "Birds of Prey". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. A BirdOfPrey obj can be either of type HAWK, EAGLE, or
 *               OSPREY, drawn from the BirdType enum.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * ***************************************************************************** */
public class BirdOfPrey extends AbstractBird {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a BirdOfPrey object of type HAWK, EAGLE, or OSPREY --
     *           Initializes object with parent constructor, then assigns all other
     *           attributes based on the greater classification BirdOfPrey and
     *           the lesser classification HAWK, EAGLE, or OSPREY (BirdType).
     * @param    'inType'     --    (BirdType)  subspecies of Bird
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public BirdOfPrey(BirdType inType, String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object
        super(inType, inName, inPreferredFoods);

        // check that input BirdType is of the right category; throw exception if bad type
        if (inType != BirdType.HAWK && inType != BirdType.EAGLE && inType != BirdType.OSPREY) {
            throw new IllegalArgumentException("Only Hawks, Eagles, and Ospreys are considered Birds of Prey.");
        }
    }

} /* ****************************************************************************** */

