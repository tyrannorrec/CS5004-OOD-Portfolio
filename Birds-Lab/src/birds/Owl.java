package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     Owl
 * Purpose   The Owl class is a child class of AbstractBird, and represents
 *               a Bird in the classification "Owl". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. An Owl obj has no type drawn from the BirdType enum,
 *               though types may be added if necessary.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * ***************************************************************************** */
public class Owl extends AbstractBird {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates an Owl object.
     *           Initializes object with parent constructor, then assigns all other
     *           attributes based on the greater classification Owl.
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public Owl(String inName, List<FoodCategory> inPreferredFoods) {

        // call the parent constructor to initialize object
        super(BirdType.OWL, inName, inPreferredFoods);
    }

} /* ****************************************************************************** */

