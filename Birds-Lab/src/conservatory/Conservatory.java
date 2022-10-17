package conservatory;

import birds.Bird;
import birds.attributes.*;

import java.util.HashMap;
import java.util.List;

/* ******************************************************************************
 * Interface  Conservatory
 * Purpose    The Conservatory interface models a Conservatory that contain up to
 *            20 Aviaries. Methods given provide the ability to rescue a Bird,
 *            look up the Aviary a Bird is in, get the amount of food that must
 *            be stored to feed the Birds (presented as a HashMap), and to return
 *            the list of Aviaries in the Conservatory and the number of Aviaries
 *            that are open. Methods also include the ability to print a
 *            lexicographically ordered index of Birds that are housed in the
 *            Conservatory, and also to print a 'map' of the Conservatory, listing
 *            the Birds that are housed in each separate Aviary. The Conservatory
 *            interface is implemented by the ConservatoryImpl concrete class.
 * ***************************************************************************** */
public interface Conservatory {

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
    void rescue(Bird inBird);

    /* -----------------------------------------------------------------------------
     * Method    lookup
     * Purpose   Iterates through contents of aviaryList to find the Bird obj.
     *               Returns the Aviary the Bird is in. Otherwise, if the Bird
     *               is not in the Conservatory, return null.
     * @param    'inBird'   --  (Bird)  a Bird of any AbstractBird subtype
     * @returns  (Aviary) the Aviary the Bird is in. Otherwise, null.
     * ----------------------------------------------------------------------------*/
    Aviary lookup(Bird inBird);

    /* -----------------------------------------------------------------------------
     * Method    getFoodCount
     * Purpose   Iterates through each open Aviary in aviaryList, calling `getFoodCount`
     *               (Aviary method) on each Aviary. Returns a HashMap depicting the
     *               amount of food, in pounds (VALUE), the Conservatory needs to store for
     *               each FoodCategory (KEY).
     * @param    None
     * @returns  (HashMap<FoodCategory, Integer>) Amount of food needed to feed the Birds
     * ----------------------------------------------------------------------------*/
    HashMap<FoodCategory, Integer> getFoodCount();

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
    HashMap<String, List<HashMap<Bird, Integer>>> getBirdIndex();

    /* -----------------------------------------------------------------------------
     * Method   `getAviaryList` returns the List of Aviaries in the Conservatory
     * @param    None
     * @returns  (List<Aviary>) the List of Aviaries in the Conservatory
     * ----------------------------------------------------------------------------*/
    List<Aviary> getAviaryList();

    /* -----------------------------------------------------------------------------
     * Method   `getNumOfOpenAviaries` returns the number of open Aviaries
     * @param    None
     * @returns  (int) the number of open Aviaries in the Conservatory
     * ----------------------------------------------------------------------------*/
    int getNumOfOpenAviaries();

    /* -----------------------------------------------------------------------------
     * Method    printMap
     * Purpose   Prints a 'map' of the Conservatory. Iterates (in order) through all
     *               open Aviaries in aviaryList; for each open Aviary, print the
     *               Aviary number (index + 1), and a list of Birds in that Aviary.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void printMap();

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
    void printBirdIndex();

} /* ****************************************************************************** */
