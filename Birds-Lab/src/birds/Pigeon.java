package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     Pigeon
 * Purpose   The Pigeon class is a child class of AbstractBird, and represents
 *               a Bird in the classification "Pigeon". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. A Pigeon obj has no type drawn from the BirdType enum,
 *               though types may be added if necessary.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * ***************************************************************************** */
public class Pigeon extends AbstractBird{

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Pigeon object.
     *           Initializes object with parent constructor, then assigns all other
     *           attributes based on the greater classification Pigeon.
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public Pigeon(String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object
        super(BirdType.PIGEON, inName, inPreferredFoods);
    }

} /* ****************************************************************************** */

