package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Interface  Bird
 * Purpose    The Bird interface models the methods available to any class
 *            depicting a Bird. These methods include the ability to get a
 *            Bird object's name, type, description, preferred foods, number
 *            of wings, and whether that Bird is extinct, as well as a method
 *            to set the name of the individual Bird. The interface is
 *            implemented by the AbstractBird class, which in turn is extended
 *            by various concrete classes (and one abstract class) representing
 *            different classifications of Birds.
 * ***************************************************************************** */
public interface Bird {

    /* -----------------------------------------------------------------------------
     * Method   `getName` returns the given name of the Bird.
     * @param    None
     * @returns  (String) given name of the Bird.
     * ----------------------------------------------------------------------------*/
    String getName();

    /* -----------------------------------------------------------------------------
     * Method   `getType` returns the type or subcategory of the Bird.
     * @param    None
     * @returns  (BirdType) Subcategory of Bird, defined by enum in birds.attributes
     * ----------------------------------------------------------------------------*/
    BirdType getType();

    /* -----------------------------------------------------------------------------
     * Method   `getDescription` returns a String description of the category of bird.
     * @param    None
     * @returns  (String) description of the category of Bird
     * ----------------------------------------------------------------------------*/
    String getDescription();

    /* -----------------------------------------------------------------------------
     * Method   `getPreferredFoods` returns a List of foods eaten by the subcategory
     *               of Bird, represented by a child class of AbstractBird.
     * @param    None
     * @returns  (List<FoodCategory>) a List of enum type FoodCategory
     * ----------------------------------------------------------------------------*/
    List<FoodCategory> getPreferredFoods();

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfWings` returns the number of wings a Bird has.
     * @param    None
     * @returns  (int) always returns 2
     * ----------------------------------------------------------------------------*/
    int getNumOfWings();

    /* -----------------------------------------------------------------------------
     * Method   `getIsExtinct` returns true if the Bird type is extinct, else false.
     * @param    None
     * @returns  (boolean) true if Bird type/subcategory is extinct. Otherwise, false.
     * ----------------------------------------------------------------------------*/
    boolean getIsExtinct();

    /* -----------------------------------------------------------------------------
     * Method   `setName` replaces the Bird's name with a new name.
     * @param    (String) new name for the Bird
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setName(String inName);

} /* ****************************************************************************** */
