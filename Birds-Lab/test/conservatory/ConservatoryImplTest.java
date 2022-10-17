package conservatory;

import birds.*;
import birds.attributes.BirdType;
import birds.attributes.FoodCategory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ConservatoryImplTest {

    /* -----------------------------------------------------------------------------
     * Declaring Conservatory and Declaring/Initializing Test Birds
     * ----------------------------------------------------------------------------*/
    Conservatory testConservatory;

    BirdOfPrey testHawk = new BirdOfPrey(BirdType.HAWK, "Drew",
            List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
    BirdOfPrey testEagle = new BirdOfPrey(BirdType.EAGLE, "Clyde",
            List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
    BirdOfPrey testOsprey = new BirdOfPrey(BirdType.OSPREY, "June",
            List.of(FoodCategory.FISH));
    Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
            List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
    Waterfowl testDuck1 = new Waterfowl(BirdType.DUCK, "Reno",
            List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
    Waterfowl testDuck2 = new Waterfowl(BirdType.DUCK, "Julie",
            List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
    Waterfowl testSwan1 = new Waterfowl(BirdType.SWAN, "King",
            List.of(FoodCategory.VEGETATION));
    Waterfowl testSwan2 = new Waterfowl(BirdType.SWAN, "Vera",
            List.of(FoodCategory.VEGETATION, FoodCategory.BUDS));
    Waterfowl testGoose = new Waterfowl(BirdType.GOOSE, "Carson",
            List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
    FlightlessBird testEmu = new FlightlessBird(BirdType.EMU, "Shannon",
            List.of(FoodCategory.BERRIES, FoodCategory.FRUIT, FoodCategory.INSECTS));
    FlightlessBird testKiwi = new FlightlessBird(BirdType.KIWI, "Ben",
            List.of(FoodCategory.NUTS, FoodCategory.VEGETATION, FoodCategory.INSECTS));
    Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS, FoodCategory.FRUIT));
    Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
            256, "Hello");
    Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT, FoodCategory.SEEDS),
            415, "Goodbye");
    Owl testOwl1 = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
    Owl testOwl2 = new Owl("Mara", List.of(FoodCategory.SMALL_MAMMALS));

    /* -----------------------------------------------------------------------------
     * Testing Constructor
     * ----------------------------------------------------------------------------*/
    @Before
    public void testConstructor() {

        testConservatory = new ConservatoryImpl();
    }

    /* -----------------------------------------------------------------------------
     * Testing `rescue` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testRescue() {

        testConservatory.rescue(testHornedPuffin);
        testConservatory.rescue(testParrot1);
        testConservatory.rescue(testHawk);
        testConservatory.rescue(testSwan1);
        testConservatory.rescue(testSwan2);
        testConservatory.rescue(testParrot2);
        testConservatory.rescue(testPigeon);
        testConservatory.rescue(testKiwi);
        testConservatory.rescue(testOsprey);
        testConservatory.rescue(testOwl1);
        testConservatory.rescue(testOwl2);

        // Horned Puffin placed in first Aviary (index 0)
        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testHornedPuffin));

        // Parrot1 placed in first Aviary (index 0) since there is no conflict
        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testParrot1));

        // Hawk placed in second Aviary (index 1) since it is a BirdOfPrey
        assertEquals(testConservatory.getAviaryList().get(1), testConservatory.lookup(testHawk));

        // Swan1 and Swan2 placed in third Aviary (index 2) since they are Waterfowl
        assertEquals(testConservatory.getAviaryList().get(2), testConservatory.lookup(testSwan1));
        assertEquals(testConservatory.getAviaryList().get(2), testConservatory.lookup(testSwan2));

        // Parrot2 and Pigeon placed in first Aviary (index 0)
        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testParrot2));
        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testPigeon));

        // Kiwi placed in fourth Aviary (index 0) since it is a FlightlessBird
        assertEquals(testConservatory.getAviaryList().get(3), testConservatory.lookup(testKiwi));

        // Osprey placed in second Aviary (index 1) alongside Hawk
        assertEquals(testConservatory.getAviaryList().get(1), testConservatory.lookup(testOsprey));

        // Owl1 placed in first Aviary (index 0)
        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testOwl1));

        // First Aviary full, so Owl2 placed in fifth Aviary (index 4)
        assertEquals(testConservatory.getAviaryList().get(4), testConservatory.lookup(testOwl2));
    }

    /* -----------------------------------------------------------------------------
     * Testing `rescue` Exceptions
     * ----------------------------------------------------------------------------*/
    @Test (expected = IllegalStateException.class)
    public void testRescueFullException() {

        for (int i = 0; i < 101; i++) {
            Pigeon newPigeon = new Pigeon("testPigeon", List.of(FoodCategory.SEEDS));
            testConservatory.rescue(newPigeon);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRescueExtinctException() {

        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        testConservatory.rescue(testGreatAuk);
    }

    /* -----------------------------------------------------------------------------
     * Testing `lookup` Method
     * ----------------------------------------------------------------------------*/

    @Test
    public void testLookup() {

        testConservatory.rescue(testKiwi);
        testConservatory.rescue(testHornedPuffin);
        testConservatory.rescue(testParrot1);
        testConservatory.rescue(testHawk);
        testConservatory.rescue(testSwan1);

        assertEquals(testConservatory.getAviaryList().get(0), testConservatory.lookup(testKiwi));
        assertEquals(testConservatory.getAviaryList().get(1), testConservatory.lookup(testHornedPuffin));
        assertEquals(testConservatory.getAviaryList().get(1), testConservatory.lookup(testParrot1));
        assertEquals(testConservatory.getAviaryList().get(2), testConservatory.lookup(testHawk));
        assertEquals(testConservatory.getAviaryList().get(3), testConservatory.lookup(testSwan1));
    }

    /* -----------------------------------------------------------------------------
     * Testing `getFoodCount` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetFoodCount() {

        HashMap<FoodCategory, Integer> expectedFoodCount = new HashMap<>();
        HashMap<FoodCategory, Integer> actualFoodCount = testConservatory.getFoodCount();
        assertEquals(expectedFoodCount, actualFoodCount);

        testConservatory.rescue(testHornedPuffin);
        testConservatory.rescue(testParrot1);
        testConservatory.rescue(testHawk);
        testConservatory.rescue(testSwan1);
        testConservatory.rescue(testSwan2);
        testConservatory.rescue(testParrot2);
        testConservatory.rescue(testPigeon);
        testConservatory.rescue(testKiwi);
        testConservatory.rescue(testOsprey);
        testConservatory.rescue(testOwl1);
        testConservatory.rescue(testOwl2);
        testConservatory.rescue(testEagle);
        testConservatory.rescue(testEmu);
        testConservatory.rescue(testDuck1);
        testConservatory.rescue(testDuck2);
        testConservatory.rescue(testGoose);

        int numOfOpenAviaries = testConservatory.getNumOfOpenAviaries();
        for (int i = 0; i < numOfOpenAviaries; i++) {
            expectedFoodCount.putAll(testConservatory.getAviaryList().get(i).getFoodCount());
        }

        actualFoodCount = testConservatory.getFoodCount();
        assertEquals(expectedFoodCount, actualFoodCount);
    }

    /* -----------------------------------------------------------------------------
     * Testing Getters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetAviaryList() {

        List<Aviary> expectedList = Arrays.asList(new Aviary[20]);
        assertEquals(expectedList, testConservatory.getAviaryList());

        testConservatory.rescue(testOwl1);
        testConservatory.rescue(testSwan1);
        testConservatory.rescue(testEagle);
        testConservatory.rescue(testEmu);

        expectedList.set(0, testConservatory.lookup(testOwl1));
        expectedList.set(1, testConservatory.lookup(testSwan1));
        expectedList.set(2, testConservatory.lookup(testEagle));
        expectedList.set(3, testConservatory.lookup(testEmu));

        assertEquals(expectedList, testConservatory.getAviaryList());
    }

    @Test
    public void testGetNumOfOpenAviaries() {

        assertEquals(0, testConservatory.getNumOfOpenAviaries());

        testConservatory.rescue(testOwl1);
        testConservatory.rescue(testSwan1);
        testConservatory.rescue(testEagle);

        assertEquals(3, testConservatory.getNumOfOpenAviaries());

        testConservatory.rescue(testEmu);

        assertEquals(4, testConservatory.getNumOfOpenAviaries());
    }

    /* -----------------------------------------------------------------------------
     * Testing Print Methods
     * ----------------------------------------------------------------------------*/

    @Test
    public void testPrintBirdIndexPrintMap() {

        testConservatory.rescue(testHornedPuffin);
        testConservatory.rescue(testParrot1);
        testConservatory.rescue(testHawk);
        testConservatory.rescue(testSwan1);
        testConservatory.rescue(testSwan2);
        testConservatory.rescue(testParrot2);
        testConservatory.rescue(testPigeon);
        testConservatory.rescue(testKiwi);
        testConservatory.rescue(testOsprey);
        testConservatory.rescue(testOwl1);
        testConservatory.rescue(testOwl2);
        testConservatory.rescue(testEagle);
        testConservatory.rescue(testEmu);
        testConservatory.rescue(testDuck1);
        testConservatory.rescue(testDuck2);
        testConservatory.rescue(testGoose);

        assertEquals(testConservatory.getAviaryList().get(1), testConservatory.lookup(testOsprey));
        assertEquals(testConservatory.getAviaryList().get(3), testConservatory.lookup(testKiwi));
        assertEquals(testConservatory.getAviaryList().get(4), testConservatory.lookup(testOwl2));

        System.out.println();
        testConservatory.printBirdIndex();
        testConservatory.printMap();
    }

} /* ****************************************************************************** */