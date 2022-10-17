package conservatory;

import birds.Bird;
import birds.attributes.*;

import java.util.HashMap;
import java.util.List;

/* ******************************************************************************
 * Interface  Aviary
 * Purpose    The Aviary interface models an Aviary that can hold at most 5 Birds.
 *            Methods given provide the ability to assign a Bird to the Aviary, to
 *            determine whether a Bird can be assigned to the Aviary, and to get
 *            the amount of food (in pounds) needed to feed all the Birds in the Aviary
 *            (represented by a HashMap where KEY = FoodCategory and VALUE = Integer.
 *            Methods are also given to determine whether an Aviary is empty or full,
 *            as well as to return the list of Birds in the Aviary and the number of
 *            Birds in the Aviary. A sign can also be printed with details about the
 *            Birds contained in the Aviary. The Aviary Interface is implemented by
 *            the AviaryImpl concrete class.
 * ****************************************************************************** */
public interface Aviary {

    /* -----------------------------------------------------------------------------
     * Method    assignBird
     * Purpose   Assigns a Bird obj to an Aviary and increments the numOfInhabitants
     *               attribute. Throws an Error if the Aviary is full. Throws an
     *               IllegalArgumentException if the Bird is extinct or if the Bird
     *               is incompatible with the other Birds in the Aviary (typeMatch).
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * ----------------------------------------------------------------------------*/
    void assignBird(Bird inBird);

    /* -----------------------------------------------------------------------------
     * Method    typeMatch
     * Purpose   Determines whether a Bird can be placed into this Aviary. Specifically,
     *               a BirdOfPrey, FlightlessBird, or Waterfowl cannot share an Aviary
     *               with any Birds of a different type. That is, a BirdOfPrey, for
     *               example, can only be placed into an Aviary if the only other Birds
     *               in the Aviary (if there are any) are BirdOfPrey objects.
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * @returns  (boolean)  true if the Bird can be placed into the Aviary;
     *                      false if the Bird cannot be placed into the Aviary
     * ----------------------------------------------------------------------------*/
    boolean typeMatch(Bird inBird);

    /* -----------------------------------------------------------------------------
     * Method    getFoodCount
     * Purpose   Iterates through the list of Birds currently in the Aviary, perusing
     *               the type of food each Bird prefers. Adds 5 pounds of each food
     *               type per instance to a Hashmap. Returns the HashMap.
     * @returns  (HashMap<FoodCategory, Integer>)   a HashMap of FoodCategories,
     *               tracking as its value in pounds the amount of that FoodCategory
     *               needed to feed all Birds in the Aviary.
     * ----------------------------------------------------------------------------*/
    HashMap<FoodCategory, Integer> getFoodCount();

    /* -----------------------------------------------------------------------------
     * Method   `getInhabitantsList` returns a List of Birds in the Aviary.
     *              Throws an Error if the Aviary is empty.
     * @param    None
     * @returns  (List<Bird>) a List of the Birds in the Aviary
     * ----------------------------------------------------------------------------*/
    List<Bird> getInhabitantsList();

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfInhabitants` returns the number of Birds in the Aviary.
     * @param    None
     * @returns  (int) the number of Birds in the Aviary
     * ----------------------------------------------------------------------------*/
    int getNumOfInhabitants();

    /* -----------------------------------------------------------------------------
     * Method   `isFull` returns true if the Aviary is full and false if it is not.
     * @param    None
     * @returns  (boolean) true if Aviary is full; false if not full
     * ----------------------------------------------------------------------------*/
    boolean isFull();

    /* -----------------------------------------------------------------------------
     * Method   `isEmpty` returns true if the Aviary is empty and false if it is not.
     * @param    None
     * @returns  (boolean) true if Aviary is empty; false if not empty
     * ----------------------------------------------------------------------------*/
    boolean isEmpty();

    /* -----------------------------------------------------------------------------
     * Method   `printSign` prints the number of Birds in the Aviary and details
     *              of each Bird (by calling the toString method of the Bird class).
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void printSign();

} /* ****************************************************************************** */
