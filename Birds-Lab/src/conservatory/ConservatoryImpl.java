package conservatory;

import birds.Bird;
import birds.attributes.BirdType;
import birds.attributes.FoodCategory;

import java.util.*;

/* ******************************************************************************
 * Class     Conservatory
 * Purpose   The Conservatory class represents a Conservatory with room for
 *               a maximum of 20 Aviaries. Each Aviary can hold 5 Birds.
 *               Birds can be rescued and automatically assigned to an open
 *               Aviary or, if there is no room available, a new Aviary can
 *               be opened to hold the new Bird. Additional methods include
 *               `getFoodCount`, `printBirdIndex`, and `printMap`, which
 *               iterate through open Aviaries to tally or print information
 *               on their inhabitants.
 * @attrib   'aviaryList'        --  (List<Aviary>) List of Aviaries in Conservatory
 * @attrib   'numOfOpenAviaries' --  (int)          Number of currently open Aviaries
 * ***************************************************************************** */
public class ConservatoryImpl implements Conservatory {

    private List<Aviary> aviaryList;
    private int numOfOpenAviaries;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates an empty Conservatory obj. Declares aviaryList as a fixed List
     *           of 20 Aviaries; each slot is set to null.
     * @param    None
     * ----------------------------------------------------------------------------*/
    public ConservatoryImpl() {

        this.aviaryList = Arrays.asList(new Aviary[20]);
        this.numOfOpenAviaries = 0;
    }

    /* -----------------------------------------------------------------------------
     * Method    rescue
     * Purpose   Assigns a Bird obj to an Aviary with the smallest possible index.
     *               iterates through aviaryList, checking whether the Bird
     *               typeMatches the current Aviary. If typeMatch is false for
     *               every open Aviary, open a new Aviary. If all 20 Aviaries are
     *               open and typeMatch is false for each, or there is no room,
     *               throw IllegalStateException.
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void rescue(Bird inBird) {

        // For every Aviary in the List:
        for (int i = 0; i < aviaryList.size(); i++) {

            // Set currAviary var to current Aviary
            Aviary currAviary = aviaryList.get(i);

            // If current Aviary is null, create new Aviary.
            if (currAviary == null) {
                currAviary = new AviaryImpl();
                aviaryList.set(i, currAviary);
                currAviary.assignBird(inBird);
                this.numOfOpenAviaries++;
                return;
            }

            // If current Aviary is not full, check if typeMatch.
            // If true, assignBird. If false, skip Aviary.
            else if (!currAviary.isFull()) {
                if (currAviary.typeMatch(inBird)) {
                    currAviary.assignBird(inBird);
                    return;
                }
            }
            // If current Aviary is full, skip Aviary.
        }

        // If Bird does not fit into any existing Aviaries and
        // there are no more null spots in the Conservatory,
        // then there is no possible spot for the Bird.
        throw new IllegalStateException("There are no possible spots in any Aviary for the Bird.");
    }

    /* -----------------------------------------------------------------------------
     * Method    lookup
     * Purpose   Iterates through contents of aviaryList to find the Bird obj.
     *               Returns the Aviary the Bird is in. Otherwise, if the Bird
     *               is not in the Conservatory, return null.
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * @returns  (Aviary) the Aviary the Bird is in. Otherwise, null.
     * ----------------------------------------------------------------------------*/
    @Override
    public Aviary lookup(Bird inBird) {

        // For every open Aviary in the List:
        for (int i = 0; i < this.numOfOpenAviaries; i++) {

            Aviary currAviary = this.aviaryList.get(i);

            // For every Bird in currAviary, check every Bird
            for (Bird currBird : currAviary.getInhabitantsList()) {

                // If inBird is found in the Aviary, return currAviary
                if (inBird == currBird) {
                    return currAviary;
                }
            }
        }

        // If Bird is not found, return null
        return null;
    }

    /* -----------------------------------------------------------------------------
     * Method    getFoodCount
     * Purpose   Iterates through each open Aviary in aviaryList, calling `getFoodCount`
     *               (Aviary method) on each Aviary. Returns a HashMap depicting the
     *               amount of food, in pounds (VALUE), the Conservatory needs to store for
     *               each FoodCategory (KEY).
     * @param    None
     * @returns  (HashMap<FoodCategory, Integer>) Amount of food needed to feed the Birds
     * ----------------------------------------------------------------------------*/
    @Override
    public HashMap<FoodCategory, Integer> getFoodCount() {

        // Create a new HashMap to store FoodCategory as Key and pounds (int) as Value
        HashMap<FoodCategory, Integer> totalFoodMap = new HashMap<>();

        // For every open Aviary,
        for (int i = 0; i < this.numOfOpenAviaries; i++) {

            // Set currAviary to current Aviary
            Aviary currAviary = aviaryList.get(i);

            // Call Aviary method `getFoodCount` to get HashMap
            HashMap<FoodCategory, Integer> currFoodMap = currAviary.getFoodCount();

            // Add current HashMap to the total HashMap
            totalFoodMap.putAll(currFoodMap);
        }

        return totalFoodMap;
    }

    /* -----------------------------------------------------------------------------
     * Method    getBirdIndex
     * Purpose   Iterates through every open Aviary in aviaryList, adding each Bird (KEY)
     *               and the num of the Aviary it is in (VALUE) to a singleton HashMap.
     *               Then, adds that HashMap to a List of Birds of a certain type. These
     *               Lists are placed in a greater HashMap whose KEYs are the types of
     *               Birds seen in the Conservatory (String), and the VALUES are the Lists
     *               of Birds of that type.
     *
     *                              STRUCTURE OF THE BIRD INDEX HASHMAP
     *              * ---------------------------------------------------------------- *
     *              |           KEY                     VALUE                          |
     *              |                                                                  |
     *              |                              k, v        k, v        k, v        |
     *              |          "Duck"           {(Duck1, 0), (Duck2, 3), (Duck3, 3)}   |
     *              |          "Eagle"          {(Eagle2, 1)                       }   |
     *              |          "Emu"            {(Emu1, 3)                         }   |
     *              |          "Goose"          {(Goose1, 0), (Goose2, 3)          }   |
     *              |           ...                      ...                           |
     *              * ---------------------------------------------------------------- *
     *
     * @param    None
     * @returns  (HashMap<String, List<HashMap<Bird, Integer>>>) A HashMap, where the
     *               KEY is the type of Bird seen in the Conservatory (String), and the
     *               VALUE is a List of Birds of that type, along with the index of the
     *               Aviary they are housed in (Integer).
     * ----------------------------------------------------------------------------*/
    @Override
    public HashMap<String, List<HashMap<Bird, Integer>>> getBirdIndex() {

        // Declare HashMap to hold total Bird Index
        HashMap<String, List<HashMap<Bird, Integer>>> birdIndexMap = new HashMap<>();

        // For each open Aviary
        for (int i = 0; i < this.numOfOpenAviaries; i++) {

            // Set currAviary to current Aviary in aviaryList
            Aviary currAviary = aviaryList.get(i);

            // For every inhabitant in currAviary
            for (int j = 0; j < currAviary.getNumOfInhabitants(); j++) {

                // Set currBird to current Bird in inhabitantsList
                Bird currBird = currAviary.getInhabitantsList().get(j);

                // Create new singleton HashMap (Key-Value pair) to hold current Bird and Aviary num
                HashMap<Bird, Integer> currBirdMap = new HashMap<>();
                currBirdMap.put(currBird, i + 1);

                // Get BirdType of currBird
                BirdType currType = currBird.getType();

                // If toString field of BirdType already a Key in master HashMap,
                if (birdIndexMap.containsKey(currType.toString())) {

                    // Add current Bird's Key-Value pair to the List under that BirdType
                    List<HashMap<Bird, Integer>> extantList = birdIndexMap.get(currType.toString());
                    extantList.add(currBirdMap);
                    birdIndexMap.put(currType.toString(), extantList);
                }

                // Otherwise,
                else { // If birdIndexMap does not contain current BirdType as a key:

                    // Make new List, put current Bird's Key-Value pair in that List,
                    // and add (BirdType, List) as KEY-VALUE pair in master HashMap
                    List<HashMap<Bird, Integer>> newList = new ArrayList<>(List.of(currBirdMap));
                    birdIndexMap.put(currType.toString(), newList);
                }
            }
        }

        return birdIndexMap;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getAviaryList` returns the List of Aviaries in the Conservatory
     * @param    None
     * @returns  (List<Aviary>) the List of Aviaries in the Conservatory
     * ----------------------------------------------------------------------------*/
    @Override
    public List<Aviary> getAviaryList() {

        return this.aviaryList;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfOpenAviaries` returns the number of open Aviaries
     * @param    None
     * @returns  (int) the number of open Aviaries in the Conservatory
     * ----------------------------------------------------------------------------*/
    @Override
    public int getNumOfOpenAviaries() {

        return this.numOfOpenAviaries;
    }

    /* -----------------------------------------------------------------------------
     * Method    printMap
     * Purpose   Prints a 'map' of the Conservatory. Iterates (in order) through all
     *               open Aviaries in aviaryList; for each open Aviary, print the
     *               Aviary number (index + 1), and a list of Birds in that Aviary.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void printMap() {

        System.out.println("* * * * * * * * * * * * * * CONSERVATORY MAP * * * * * * * * * * * * * *\n" +
                "The Conservatory has " + this.numOfOpenAviaries + " open Aviaries.");

        for (int i = 0; i < this.numOfOpenAviaries; i++) {
            Aviary currAviary = aviaryList.get(i);
            System.out.println(
                    "-----------------------------------------------------------------------\n" +
                    "\t\tAVIARY " + (i + 1) + "\n\n" +
                    "This Aviary houses " + currAviary.getNumOfInhabitants() + " bird(s):\n");

            for (int j = 0; j < currAviary.getNumOfInhabitants(); j++) {
                Bird currBird = currAviary.getInhabitantsList().get(j);
                System.out.println(
                        "\"" + currBird.getName() + "\" the " + currBird.getType());
            }

            System.out.println(
                    "-----------------------------------------------------------------------\n");
        }

        System.out.println("* * * * * * * * * * * * * * * * MAP END * * * * * * * * * * * * * * * *\n\n");
    }

    /* -----------------------------------------------------------------------------
     * Method    printBirdIndex
     * Purpose   Prints a List of Birds in the Conservatory and the Aviary number
     *               (index + 1) they are housed in, organized lexicographically
     *               by BirdType. Calls `getBirdIndex` to retrieve a HashMap where
     *               (KEY = toString field of BirdType) and (VALUE = a List of Birds
     *               in the Conservatory of that type as well as the number of the
     *               Aviary they are housed in). Sorts the keys in the HashMap by
     *               casting to TreeMap, then prints all Birds of each type and their
     *               location in the Conservatory.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void printBirdIndex() {

        // Call `getBirdIndex` to get master HashMap
        HashMap<String, List<HashMap<Bird, Integer>>> birdIndexMap = getBirdIndex();

        // Sort HashMap Keys (toString field of BirdType) by casting to TreeMap
        Map<String, List<HashMap<Bird, Integer>>> sortedBirdIndexMap = new TreeMap<>(birdIndexMap);

        // Print header
        System.out.print("""
                * * * * * * * * * * * * * * * * BIRD INDEX * * * * * * * * * * * * * *
                -----------------------------------------------------------------------

                \t\t\t[ TYPE ]\t\t\t[ NAME ]\t\t\t[ AVIARY ]
                
                """);

        // For every entry in the TreeMap
        for (Map.Entry<String,List<HashMap<Bird, Integer>>> entry : sortedBirdIndexMap.entrySet()) {

            // Set `key` to this entry's KEY
            String key = entry.getKey();

            // Set `birdsOfCurrTypeList` to this entry's VALUE
            List<HashMap<Bird, Integer>> birdsOfCurrTypeList = entry.getValue();

            // For each Key-Value pair in `birdsOfCurrTypeList`
            for (HashMap<Bird, Integer> currMap : birdsOfCurrTypeList) {
                // Get the KEY -- the Bird
                Bird currBird = currMap.entrySet().stream().findFirst().get().getKey();
                // Get the VALUE -- the number of the Aviary the Bird is housed in
                int currAviary = currMap.get(currBird);
                // Print the Bird's type, name, and location
                System.out.printf("\t\t\t  %1$-19s %2$-20s %3$3d\n",
                        key.toUpperCase(), currBird.getName(), currAviary);
            }
        }

        // Print footer
        System.out.println("""
                \n-----------------------------------------------------------------------
                * * * * * * * * * * * * * * * * END INDEX * * * * * * * * * * * * * * *

                """);
    }

} /* ****************************************************************************** */
