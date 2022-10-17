package conservatory;

import birds.*;
import birds.attributes.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AviaryImpl implements Aviary {
    /* ******************************************************************************
     * Class     Aviary
     * Purpose   The Aviary class represents an Aviary within a Conservatory with
     *               room for a maximum of 5 Birds. Rescued Birds can be assigned
     *               to the Aviary if it is compatible with the other Birds within.
     *               Via the `printSign` method, details of the Birds in the Aviary
     *               can be outputted to the terminal.
     * @attrib   'inhabitantsList'  --  (List<Bird>)  List of Birds housed in the Aviary
     * @attrib   'numOfInhabitants' --  (int)         Number of Birds housed in the Aviary
     * ***************************************************************************** */

    private List<Bird> inhabitantsList;
    private int numOfInhabitants;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates an empty Aviary obj. Declares inhabitantsList as a fixed List
     *           of 5 Birds; each slot is set to null.
     * @param    None
     * ----------------------------------------------------------------------------*/
    public AviaryImpl() {

        this.inhabitantsList = Arrays.asList(new Bird[5]);
        this.numOfInhabitants = 0;
    }

    /* -----------------------------------------------------------------------------
     * Method    assignBird
     * Purpose   Assigns a Bird obj to an Aviary and increments the numOfInhabitants
     *               attribute. Throws an Error if the Aviary is full. Throws an
     *               IllegalArgumentException if the Bird is extinct or if the Bird
     *               is incompatible with the other Birds in the Aviary (typeMatch).
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * ----------------------------------------------------------------------------*/
    @Override
    public void assignBird(Bird inBird) {

        if (this.isFull()) {
            throw new IllegalStateException("The Aviary is full. No more birds can be added.");
        }

        else if (inBird.getIsExtinct()) {
            throw new IllegalArgumentException("Extinct birds cannot be rescued.");
        }

        else if (!this.typeMatch(inBird)) {
            throw new IllegalArgumentException("This bird is incompatible with the " +
                    "current birds in this Aviary.");
        }

        int index = this.numOfInhabitants;
        this.inhabitantsList.set(index, inBird);
        this.numOfInhabitants++;
    }

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
    @Override
    public boolean typeMatch(Bird inBird) {

        // Gets type of the Bird for switch statement
        BirdType currBirdType = inBird.getType();

        // Default: set class signifier String to "Other"
        String currBirdClass = "Other";

        // If a BirdOfPrey type, assign "BirdOfPrey" to class signifier String
        if (currBirdType == BirdType.HAWK || currBirdType == BirdType.EAGLE ||
                currBirdType == BirdType.OSPREY) {
            currBirdClass = "BirdOfPrey";
        }

        // If a FlightlessBird type, assign "FlightlessBird" to class signifier String
        else if (currBirdType == BirdType.EMU || currBirdType == BirdType.KIWI) {
            currBirdClass = "FlightlessBird";
        }

        // If a Waterfowl type, assign "Waterfowl" to class signifier String
        else if (currBirdType == BirdType.DUCK || currBirdType == BirdType.SWAN ||
                currBirdType == BirdType.GOOSE) {
            currBirdClass = "Waterfowl";
        }

        // SWITCH
        switch (currBirdClass) {

            // If BirdOfPrey, peruse current inhabitants and return false if
            // any Bird is not a BirdOfPrey. If no conflict, return true
            case "BirdOfPrey" -> {
                for (int i = 0; i < numOfInhabitants; i++) {
                    Bird currBird = inhabitantsList.get(i);
                    if (!(currBird instanceof BirdOfPrey)) {
                        return false;
                    }
                }
                return true;
            }

            // If FlightlessBird, peruse current inhabitants and return false if
            // any Bird is not a FlightlessBird. If no conflict, return true
            case "FlightlessBird" -> {
                for (int i = 0; i < numOfInhabitants; i++) {
                    Bird currBird = inhabitantsList.get(i);
                    if (!(currBird instanceof FlightlessBird)) {
                        return false;
                    }
                }
                return true;
            }

            // If Waterfowl, peruse current inhabitants and return false if
            // any Bird is not a Waterfowl. If no conflict, return true
            case "Waterfowl" -> {
                for (int i = 0; i < numOfInhabitants; i++) {
                    Bird currBird = inhabitantsList.get(i);
                    if (!(currBird instanceof Waterfowl)) {
                        return false;
                    }
                }
                return true;
            }

            // For general case, peruse current inhabitants and return false if
            // any Bird is a BirdOfPrey, FlightlessBird, or Waterfowl.
            // If no conflict, return true
            default -> {
                for (int i = 0; i < numOfInhabitants; i++) {
                    Bird currBird = inhabitantsList.get(i);
                    if ((currBird instanceof BirdOfPrey) ||
                            (currBird instanceof FlightlessBird) ||
                            (currBird instanceof Waterfowl)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    getFoodCount
     * Purpose   Iterates through the list of Birds currently in the Aviary, perusing
     *               the type of food each Bird prefers. Adds 5 pounds of each food
     *               type per instance to a Hashmap. Returns the HashMap.
     * @returns  (HashMap<FoodCategory, Integer>)   a HashMap of FoodCategories,
     *               tracking as its value in pounds the amount of that FoodCategory
     *               needed to feed all Birds in the Aviary.
     * ----------------------------------------------------------------------------*/
    @Override
    public HashMap<FoodCategory, Integer> getFoodCount() {

        // Initialize HashMap with FoodCategory as Key and num of pounds (int) as Value
        HashMap<FoodCategory, Integer> foodHashMap = new HashMap<>();

        // For every Bird in this Aviary:
        for (int i = 0; i < numOfInhabitants; i++) {

            // Access preferredFoods list in Bird obj
            Bird currBird = inhabitantsList.get(i);
            List<FoodCategory> currBirdFoods = currBird.getPreferredFoods();

            // For every item in preferredFoods list,
            for (FoodCategory currFoodItem : currBirdFoods) {

                // If FoodCategory already in HashMap, increment value by 5 pounds
                if (foodHashMap.containsKey(currFoodItem)) {
                    foodHashMap.put(currFoodItem, foodHashMap.get(currFoodItem) + 5);
                }
                // If FoodCategory NOT in HashMap, add to HashMap and set to 5 pounds
                else {
                    foodHashMap.put(currFoodItem, 5);
                }
            }
        }
        return foodHashMap;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getInhabitantsList` returns a List of Birds in the Aviary.
     * @param    None
     * @returns  (List<Bird>) a List of the Birds in the Aviary
     * ----------------------------------------------------------------------------*/
    @Override
    public List<Bird> getInhabitantsList() {

        return this.inhabitantsList;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfInhabitants` returns the number of Birds in the Aviary.
     * @param    None
     * @returns  (int) the number of Birds in the Aviary
     * ----------------------------------------------------------------------------*/
    @Override
    public int getNumOfInhabitants() {

        return this.numOfInhabitants;
    }

    /* -----------------------------------------------------------------------------
     * Method   `isFull` returns true if the Aviary is full and false if it is not.
     * @param    None
     * @returns  (boolean) true if Aviary is full; false if not full
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean isFull() {

        return this.numOfInhabitants == 5;
    }

    /* -----------------------------------------------------------------------------
     * Method   `isEmpty` returns true if the Aviary is empty and false if it is not.
     * @param    None
     * @returns  (boolean) true if Aviary is empty; false if not empty
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean isEmpty() {

        return this.numOfInhabitants == 0;
    }

    /* -----------------------------------------------------------------------------
     * Method   `printSign` prints the number of Birds in the Aviary and details
     *              of each Bird (by calling the toString method of the Bird class).
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void printSign() {

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
        "This Aviary houses " + this.numOfInhabitants + " bird(s):\n");
        for (int i = 0; i < numOfInhabitants; i++) {
            System.out.println(this.inhabitantsList.get(i));
        }
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
    }

} /* ****************************************************************************** */
