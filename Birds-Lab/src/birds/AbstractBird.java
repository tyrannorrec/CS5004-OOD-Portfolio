package birds;

import birds.attributes.*;
import java.util.List;

/* ******************************************************************************
 * Class     AbstractBird
 * Purpose   The AbstractBird class represents the parent class of seven categories
 *               of birds, namely BirdOfPrey, FlightlessBird, Owl, Parrot, Pigeon,
 *               Shorebird, and Waterfowl. An obj of any child class has a type --
 *               for example, a Duck, an Eagle, or a Horned Puffin, which determines
 *               the categorical information about that type or subspecies,
 *               represented by the other attributes. Birds are defined by having
 *               two wings, so the numOfWings variable is final.
 * @attrib   'name'           --    (String)    name given to the individual Bird
 * @attrib   'type'           --    (BirdType)  subspecies of Bird
 * @attrib   'description'    --    (String)    defining features of Bird category
 * @attrib   'preferredFoods' --    (List)      see FoodCategory enum in birds.attributes
 * @attrib   'isExtinct'      --    (boolean)   height of rectangle; must be positive
 * @attrib   'numOfWings'     --    (int)       set at 2; final
 * ***************************************************************************** */
public abstract class AbstractBird implements Bird {

    protected String name;
    protected BirdType type;
    protected String description;
    protected List<FoodCategory> preferredFoods;
    protected boolean isExtinct;
    protected final int numOfWings;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Only called by child class constructors. Only instantiates numOfWings
     *           variable by 2, since some child classes (Owl, Parrot, Pigeon) have
     *           no type, and thus most attributes cannot be instantiated here.
     * @param    'inType'   --  (BirdType)  type of the Bird
     * @param    'inName'   --  (String)    name of the Bird
     * @param    'inPreferredFoods' -- (List<FoodCategory>)   the foods eaten by the Bird
     * ----------------------------------------------------------------------------*/
    public AbstractBird(BirdType inType, String inName, List<FoodCategory> inPreferredFoods) {

        this.numOfWings = 2;
        this.name = inName;
        this.type = inType;
        this.preferredFoods = inPreferredFoods;
        this.description = this.type.getTypeDescription();
        this.isExtinct = this.type.getIsExtinct();
    }
    /* -----------------------------------------------------------------------------
     * Method   `getName` returns the given name of the Bird.
     * @param    None
     * @returns  (String) nickname / given name of the Bird.
     * ----------------------------------------------------------------------------*/
    @Override
    public String getName() {
        return this.name;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getType` returns the type or subcategory of the AbstractBird.
     * @param    None
     * @returns  (BirdType) Subcategory of Bird, defined by enum in birds.attributes
     * ----------------------------------------------------------------------------*/
    @Override
    public BirdType getType() {
        return this.type;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getDescription` returns a String description of the category of bird.
     * @param    None
     * @returns  (String) description of the category of Bird
     * ----------------------------------------------------------------------------*/
    @Override
    public String getDescription() {
        return this.description;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getPreferredFoods` returns a List of foods eaten by the subcategory
     *               of Bird, represented by a child class of AbstractBird.
     * @param    None
     * @returns  (List<FoodCategory>) a List of enum type FoodCategory
     * ----------------------------------------------------------------------------*/
    @Override
    public List<FoodCategory> getPreferredFoods() {
        return this.preferredFoods;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfWings` returns the number of wings an AbstractBird has.
     * @param    None
     * @returns  (int) always returns 2
     * ----------------------------------------------------------------------------*/
    @Override
    public int getNumOfWings() {
        return this.numOfWings;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getIsExtinct` returns true if the Bird type is extinct, else false.
     * @param    None
     * @returns  (boolean) true if Bird type/subcategory is extinct. Otherwise, false.
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean getIsExtinct() {
        return this.isExtinct;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setName` replaces the Bird's name with a new name.
     * @param    (String) new name for the Bird
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setName(String inName) {
        this.name = inName;
    }

    /* -----------------------------------------------------------------------------
     * Method   `equals` returns true if all attributes of two Birds match, and
     *              false if they do not match. Overridden by AquaticBird abstract
     *              class and Parrot concrete class.
     * @param    None
     * @returns  (boolean) true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        // Check for null pointer
        if (obj == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }

        // Check for AutomaticTransmission Class; cast and rename if true
        if (!(obj instanceof AbstractBird)) {
            throw new IllegalArgumentException("Argument must be an instance " +
                    "of the AbstractBird class hierarchy.");
        }

        // If all vars equivalent, return true. Else, return false
        AbstractBird other = (AbstractBird) obj;
        return (this.name == other.name) &&
                (this.type == other.type) &&
                (this.description == other.description) &&
                (this.preferredFoods.equals(other.preferredFoods)) &&
                (this.isExtinct == other.isExtinct) &&
                (this.numOfWings == other.numOfWings);
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns a String containing most attributes of an
     *           AbstractBird to print. Overridden by child classes with additional
     *           information to print, including Parrot, Shorebird, and Waterfowl.
     *           Does not include numOfWings and isExtinct attributes.
     * @param    None
     * @returns  (String) contains all values of an AbstractBird's attributes
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {

        return ("-----------------------------------------------------------------------\n" +
                "Name:            " + this.name + "\n" +
                "Type:            " + this.type + "\n" +
                "Preferred Foods: " + this.preferredFoods + "\n\n" +
                "Description:\n" + this.description + "\n" +
                "-----------------------------------------------------------------------\n" );
    }

} /* ****************************************************************************** */