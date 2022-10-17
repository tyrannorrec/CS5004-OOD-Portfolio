package birds;

import birds.attributes.*;
import java.util.List;
import java.util.Objects;

/* ******************************************************************************
 * Class     Parrot
 * Purpose   The Parrot class is a child class of AbstractBird, and represents
 *               a Bird in the classification "Parrot". It is distinguished
 *               from other Bird classifications by its description and preferred
 *               foods. Parrot objects also have 'vocabulary' (int) and 'favoriteSaying'
 *               (String) as additional attributes. A Parrot obj has no type drawn
 *               from the BirdType enum, though types may be added if necessary.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * @attrib   'vocabulary'     --    (int)       the number of words known by the Parrot
 * @attrib   'favoriteSaying' --    (String)    the parrot's favorite word or phrase
 * ***************************************************************************** */
public class Parrot extends AbstractBird {

    private int vocabulary;
    private String favoriteSaying;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Parrot object.
     *           Initializes object with parent constructor, then assigns all other
     *           attributes based on the greater classification Parrot.
     *           Initializes Parrot-specific attributes 'vocabulary' and 'favoriteSaying'.
     * @param    'inName'     --    (String)    given name of the individual Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * @param    'inVocabulary' --  (int)       the number of words known by the Parrot
     * @param    'inFavoriteSaying' -- (String) the parrot's favorite word or phrase
     * ----------------------------------------------------------------------------*/
    public Parrot(String inName, List<FoodCategory> inPreferredFoods,
                  int inVocabulary, String inFavoriteSaying) {

        // call the parent constructor to initialize object
        super(BirdType.PARROT, inName, inPreferredFoods);

        if (inVocabulary < 0) {
            throw new IllegalArgumentException("Vocabulary must be a non-negative number.");
        }

        this.vocabulary = inVocabulary;
        this.favoriteSaying = inFavoriteSaying;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getVocabulary` returns the number of words in the Parrot's vocabulary.
     * @param    None
     * @returns  (int) the number of words in the Parrot's vocabulary
     * ----------------------------------------------------------------------------*/
    public int getVocabulary() {
        return this.vocabulary;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getFavoriteSaying` returns the favorite saying of the Parrot.
     * @param    None
     * @returns  (String) the favorite saying of the parrot
     * ----------------------------------------------------------------------------*/
    public String getFavoriteSaying() {
        return this.favoriteSaying;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setVocabulary` updates the vocabulary attribute to a new int
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    public void setVocabulary(int inVocabulary) {
        this.vocabulary = inVocabulary;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setFavoriteSaying` updates the favoriteSaying attribute to a new String
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    public void setFavoriteSaying(String inFavoriteSaying) {
        this.favoriteSaying = inFavoriteSaying;
    }

    /* -----------------------------------------------------------------------------
     * Method   `equals` returns true if all attributes of two Parrots match, and
     *              false if they do not match. Overrides AbstractBird equals method.
     * @param    None
     * @returns  (boolean) true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) return false;

        // Check for AutomaticTransmission Class; cast and rename if true
        if (!(obj instanceof Parrot)) {
            throw new IllegalArgumentException("Argument must be an instance " +
                    "of the Parrot class.");
        }

        // If all vars equivalent, return true. Else, return false
        Parrot other = (Parrot) obj;
        return (this.vocabulary == other.vocabulary) &&
                (Objects.equals(this.favoriteSaying, other.favoriteSaying));
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns a String containing most of a Parrot's attributes,
     *           to print. Overrides AbstractBird class 'toString' method.
     *           Does not include numOfWings and isExtinct attributes.
     * @param    None
     * @returns  (String) contains all values of a Parrot's attributes
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return ("-----------------------------------------------------------------------\n" +
                "Name:            " + this.name + "\n" +
                "Type:            " + this.type + "\n" +
                "Vocabulary:      " + this.vocabulary + " words\n" +
                "Favorite Saying: \"" + this.favoriteSaying + "\"\n" +
                "Preferred Foods: " + this.preferredFoods + "\n\n" +
                "Description:\n" + this.description + "\n" +
                "-----------------------------------------------------------------------\n" );
    }

} /* ****************************************************************************** */
