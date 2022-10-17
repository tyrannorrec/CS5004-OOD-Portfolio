package conservatory;

import birds.*;
import birds.attributes.BirdType;
import birds.attributes.FoodCategory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AviaryImplTest {

    Aviary testAviary1;
    Aviary testAviary2;
    Aviary testAviary3;
    Aviary testAviary4;

    /* -----------------------------------------------------------------------------
     * Testing Constructor
     * ----------------------------------------------------------------------------*/
    @Test
    public void testConstructor() {

        testAviary1 = new AviaryImpl();
    }

    /* -----------------------------------------------------------------------------
     * Testing `assignBird` Method and Relevant Exceptions
     * ----------------------------------------------------------------------------*/
    @Test
    public void testAssignBird() {

        BirdOfPrey testHawk = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");

        testAviary1 = new AviaryImpl();
        testAviary2 = new AviaryImpl();

        testAviary1.assignBird(testHawk);
        testAviary2.assignBird(testHornedPuffin);
        testAviary2.assignBird(testParrot);
    }

    @Test (expected = IllegalStateException.class)
    public void testAssignBirdAviaryFullException() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Pigeon testPigeon1 = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        Pigeon testPigeon2 = new Pigeon("Louise", List.of(FoodCategory.SEEDS));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT),
                415, "Goodbye");

        testAviary1 = new AviaryImpl();

        testAviary1.assignBird(testOwl);
        testAviary1.assignBird(testPigeon1);
        testAviary1.assignBird(testPigeon2);
        testAviary1.assignBird(testHornedPuffin);
        testAviary1.assignBird(testParrot1);
        testAviary1.assignBird(testParrot2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAssignBirdExtinctException() {

        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));

        testAviary1 = new AviaryImpl();
        testAviary1.assignBird(testGreatAuk);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAssignBirdTypeMatchException() {

        BirdOfPrey testHawk = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        FlightlessBird testKiwi = new FlightlessBird(BirdType.KIWI, "Ben",
                List.of(FoodCategory.NUTS, FoodCategory.VEGETATION, FoodCategory.INSECTS));

        testAviary1 = new AviaryImpl();
        testAviary1.assignBird(testHawk);
        testAviary1.assignBird(testKiwi);
    }

    /* -----------------------------------------------------------------------------
     * Testing `typeMatch` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testTypeMatch() {

        BirdOfPrey testHawk1 = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        BirdOfPrey testHawk2 = new BirdOfPrey(BirdType.HAWK, "Ulysses",
                List.of(FoodCategory.SMALL_MAMMALS));
        FlightlessBird testKiwi = new FlightlessBird(BirdType.KIWI, "Ben",
                List.of(FoodCategory.NUTS, FoodCategory.VEGETATION, FoodCategory.INSECTS));
        FlightlessBird testEmu = new FlightlessBird(BirdType.EMU, "Shannon",
                List.of(FoodCategory.BERRIES, FoodCategory.FRUIT, FoodCategory.INSECTS));
        Waterfowl testSwan = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        Waterfowl testGoose = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");

        // Testing on an Aviary with a BirdOfPrey
        testAviary1 = new AviaryImpl();
        testAviary1.assignBird(testHawk1);
        assertFalse(testAviary1.typeMatch(testKiwi));
        assertFalse(testAviary1.typeMatch(testOwl));
        assertTrue(testAviary1.typeMatch(testHawk2));

        // Testing on an Aviary with a FlightlessBird
        testAviary2 = new AviaryImpl();
        testAviary2.assignBird(testKiwi);
        assertFalse(testAviary2.typeMatch(testHawk1));
        assertFalse(testAviary2.typeMatch(testSwan));
        assertTrue(testAviary2.typeMatch(testEmu));

        // Testing on an Aviary with a Waterfowl
        testAviary3 = new AviaryImpl();
        testAviary3.assignBird(testSwan);
        assertFalse(testAviary3.typeMatch(testParrot));
        assertFalse(testAviary3.typeMatch(testOwl));
        assertTrue(testAviary3.typeMatch(testGoose));

        // Testing on an Aviary in the General Case
        testAviary4 = new AviaryImpl();
        testAviary4.assignBird(testParrot);
        assertFalse(testAviary4.typeMatch(testHawk2));
        assertFalse(testAviary4.typeMatch(testEmu));
        assertFalse(testAviary4.typeMatch(testSwan));
        assertTrue(testAviary4.typeMatch(testOwl));
    }

    /* -----------------------------------------------------------------------------
     * Testing `getFoodCount` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetFoodCount() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS));
        Pigeon testPigeon1 = new Pigeon("Rico", List.of(FoodCategory.SEEDS, FoodCategory.FRUIT));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT, FoodCategory.SEEDS),
                415, "Goodbye");

        testAviary1 = new AviaryImpl();

        testAviary1.assignBird(testOwl);
        testAviary1.assignBird(testPigeon1);
        testAviary1.assignBird(testHornedPuffin);
        testAviary1.assignBird(testParrot1);
        testAviary1.assignBird(testParrot2);

        HashMap<FoodCategory, Integer> expectedFoodMap = new HashMap<FoodCategory, Integer>();
        expectedFoodMap.put(FoodCategory.SMALL_MAMMALS, 5);
        expectedFoodMap.put(FoodCategory.SEEDS, 10);
        expectedFoodMap.put(FoodCategory.FISH, 5);
        expectedFoodMap.put(FoodCategory.AQUATIC_INVERTEBRATES, 5);
        expectedFoodMap.put(FoodCategory.VEGETATION, 5);
        expectedFoodMap.put(FoodCategory.FRUIT, 15);
        expectedFoodMap.put(FoodCategory.INSECTS, 5);

        HashMap<FoodCategory, Integer> actualFoodMap = testAviary1.getFoodCount();
        assertEquals(expectedFoodMap, actualFoodMap);
    }

    /* -----------------------------------------------------------------------------
     * Testing Getters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetInhabitantsList() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Pigeon testPigeon1 = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        Pigeon testPigeon2 = new Pigeon("Louise", List.of(FoodCategory.SEEDS));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT),
                415, "Goodbye");

        testAviary1 = new AviaryImpl();

        testAviary1.assignBird(testOwl);
        testAviary1.assignBird(testPigeon1);
        testAviary1.assignBird(testPigeon2);
        testAviary1.assignBird(testHornedPuffin);
        testAviary1.assignBird(testParrot1);

        List<Bird> expectedListOfBirds = List.of(testOwl, testPigeon1, testPigeon2,
                testHornedPuffin, testParrot1);
        List<Bird> actualListOfBirds = testAviary1.getInhabitantsList();

        assertEquals(expectedListOfBirds, actualListOfBirds);
    }

    @Test
    public void testGetNumOfInhabitants() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Pigeon testPigeon1 = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        Pigeon testPigeon2 = new Pigeon("Louise", List.of(FoodCategory.SEEDS));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT),
                415, "Goodbye");

        testAviary1 = new AviaryImpl();

        assertEquals(0, testAviary1.getNumOfInhabitants());
        testAviary1.assignBird(testOwl);
        assertEquals(1, testAviary1.getNumOfInhabitants());
        testAviary1.assignBird(testPigeon1);
        assertEquals(2, testAviary1.getNumOfInhabitants());
        testAviary1.assignBird(testPigeon2);
        assertEquals(3, testAviary1.getNumOfInhabitants());
        testAviary1.assignBird(testHornedPuffin);
        assertEquals(4, testAviary1.getNumOfInhabitants());
        testAviary1.assignBird(testParrot1);
        assertEquals(5, testAviary1.getNumOfInhabitants());
    }

    /* -----------------------------------------------------------------------------
     * Testing `isEmpty`/`isFull` Methods
     * ----------------------------------------------------------------------------*/
    @Test
    public void testIsEmpty() {

        testAviary1 = new AviaryImpl();
        assertTrue(testAviary1.isEmpty());

        Waterfowl testSwan = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        testAviary1.assignBird(testSwan);
        assertFalse(testAviary1.isEmpty());
    }

    @Test
    public void testIsFull() {

        Waterfowl testSwan1 = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        Waterfowl testSwan2 = new Waterfowl(BirdType.SWAN, "Vera",
                List.of(FoodCategory.VEGETATION, FoodCategory.BUDS));
        Waterfowl testDuck1 = new Waterfowl(BirdType.DUCK, "Reno",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        Waterfowl testDuck2 = new Waterfowl(BirdType.DUCK, "Major",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        Waterfowl testGoose = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));

        testAviary1 = new AviaryImpl();
        assertFalse(testAviary1.isFull());

        testAviary1.assignBird(testSwan1);
        assertFalse(testAviary1.isFull());

        testAviary1.assignBird(testSwan2);
        testAviary1.assignBird(testDuck1);
        testAviary1.assignBird(testDuck2);
        testAviary1.assignBird(testGoose);
        assertTrue(testAviary1.isFull());
    }

    /* -----------------------------------------------------------------------------
     * Testing `printSign` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testPrintSign() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Richie", List.of(FoodCategory.FRUIT),
                415, "Goodbye");

        testAviary1 = new AviaryImpl();

        testAviary1.assignBird(testOwl);
        testAviary1.assignBird(testPigeon);
        testAviary1.assignBird(testHornedPuffin);
        testAviary1.assignBird(testParrot1);
        testAviary1.assignBird(testParrot2);

        testAviary1.printSign();
    }

} /* ****************************************************************************** */