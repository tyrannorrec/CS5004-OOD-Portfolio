package birds;

import birds.attributes.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class AbstractBirdTest {

    /* -----------------------------------------------------------------------------
     * Testing Constructors
     * ----------------------------------------------------------------------------*/
    @Test
    public void testConstructors() {

        // Constructing Classes with no types
        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");

        // Constructing BirdsOfPrey
        BirdOfPrey testHawk = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        BirdOfPrey testEagle = new BirdOfPrey(BirdType.EAGLE, "Clyde",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        BirdOfPrey testOsprey = new BirdOfPrey(BirdType.OSPREY, "June",
                List.of(FoodCategory.FISH));

        // Constructing FlightlessBirds
        FlightlessBird testEmu = new FlightlessBird(BirdType.EMU, "Shannon",
                List.of(FoodCategory.BERRIES, FoodCategory.FRUIT, FoodCategory.INSECTS));
        FlightlessBird testKiwi = new FlightlessBird(BirdType.KIWI, "Ben",
                List.of(FoodCategory.NUTS, FoodCategory.VEGETATION, FoodCategory.INSECTS));
        FlightlessBird testMoa = new FlightlessBird(BirdType.MOA, "Mira",
                List.of(FoodCategory.SEEDS, FoodCategory.FRUIT, FoodCategory.VEGETATION));

        // Constructing Shorebirds
        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        Shorebird testAfricanJacana = new Shorebird(BirdType.AFRICAN_JACANA, "Gallus",
                List.of(FoodCategory.INSECTS, FoodCategory.AQUATIC_INVERTEBRATES));

        // Constructing Waterfowl
        Waterfowl testDuck = new Waterfowl(BirdType.DUCK, "Reno",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        Waterfowl testSwan = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        Waterfowl testGoose = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
    }

    /* -----------------------------------------------------------------------------
     * Testing Constructor Exceptions
     * ----------------------------------------------------------------------------*/
    @Test(expected = IllegalArgumentException.class)
    public void testBirdOfPreyConstructorException() {

        BirdOfPrey test = new BirdOfPrey(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFlightlessBirdConstructorException() {

        FlightlessBird test = new FlightlessBird(BirdType.OSPREY, "June",
                List.of(FoodCategory.FISH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShorebirdConstructorException() {

        Shorebird test = new Shorebird(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWaterfowlConstructorException() {

        Waterfowl testDuck = new Waterfowl(BirdType.AFRICAN_JACANA, "Gallus",
                List.of(FoodCategory.INSECTS, FoodCategory.AQUATIC_INVERTEBRATES));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParrotConstructorNegativeVocabularyException() {

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                -1, "Hello");
    }

    /* -----------------------------------------------------------------------------
     * Testing Parrot-Specific Getters/Setters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testParrotGetVocabulary() {

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        assertEquals(256, testParrot.getVocabulary());
        assertNotEquals(1, testParrot.getVocabulary());
    }

    @Test
    public void testParrotGetFavoriteSaying() {

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        assertEquals("Hello", testParrot.getFavoriteSaying());
        assertNotEquals("hello", testParrot.getFavoriteSaying());
    }

    @Test
    public void testParrotSetVocabulary() {

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        testParrot.setVocabulary(257);
        assertEquals(257, testParrot.getVocabulary());
    }

    @Test
    public void testParrotSetFavoriteSaying() {

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        testParrot.setFavoriteSaying("Goodbye");
        assertEquals("Goodbye", testParrot.getFavoriteSaying());
    }

    /* -----------------------------------------------------------------------------
     * Testing AquaticBird-Specific Getter
     * ----------------------------------------------------------------------------*/

    @Test
    public void testAquaticBirdGetEnvirons() {

        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        assertEquals(WaterSource.OCEAN, testGreatAuk.getEnvirons());

        Waterfowl testDuck = new Waterfowl(BirdType.DUCK, "Reno",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        assertEquals(WaterSource.WETLANDS, testDuck.getEnvirons());
    }

    /* -----------------------------------------------------------------------------
     * Testing General AbstractBird Getters/Setters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetName() {

        Shorebird testAfricanJacana = new Shorebird(BirdType.AFRICAN_JACANA, "Gallus",
                List.of(FoodCategory.INSECTS, FoodCategory.AQUATIC_INVERTEBRATES));
        assertEquals("Gallus", testAfricanJacana.getName());
    }

    @Test
    public void testGetType() {

        BirdOfPrey testOsprey = new BirdOfPrey(BirdType.OSPREY, "June",
                List.of(FoodCategory.FISH));
        assertEquals(BirdType.OSPREY, testOsprey.getType());

        Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        assertEquals(BirdType.PIGEON, testPigeon.getType());
    }

    @Test
    public void testGetDescription() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        String owlDescription = """
                    Owls are nocturnal, crepuscular, or diurnal birds, distinguished\s
                    by the facial disks that frame the eyes and bill. They live in\s
                    virtually all habitats, and hunt by sustained flight.""";
        assertEquals(owlDescription, testOwl.getDescription());

        Waterfowl testSwan = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        String swanDescription = """
                    Swans are the largest Waterfowl species. They are gracefully long-necked,\s
                    heavy-bodied, big-footed birds that glide majestically when swimming and fly\s
                    with slow wingbeats and with necks outstretched.""";
        assertEquals(swanDescription, testSwan.getDescription());
    }

    @Test
    public void testGetPreferredFoods() {

        Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        assertEquals(List.of(FoodCategory.SEEDS), testPigeon.getPreferredFoods());

        FlightlessBird testEmu = new FlightlessBird(BirdType.EMU, "Shannon",
                List.of(FoodCategory.BERRIES, FoodCategory.FRUIT, FoodCategory.INSECTS));
        assertEquals(List.of(FoodCategory.BERRIES, FoodCategory.FRUIT, FoodCategory.INSECTS),
                testEmu.getPreferredFoods());
    }

    @Test
    public void testGetNumOfWings() {

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        assertEquals(2, testOwl.getNumOfWings());
    }

    @Test
    public void testGetIsExtinct() {

        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        assertTrue(testGreatAuk.getIsExtinct());

        Waterfowl testDuck = new Waterfowl(BirdType.DUCK, "Reno",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        assertFalse(testDuck.getIsExtinct());
    }

    @Test
    public void testSetName() {

        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        testHornedPuffin.setName("Mira");
        assertEquals("Mira", testHornedPuffin.getName());
    }

    /* -----------------------------------------------------------------------------
     * Testing `equals` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testEquals() {

        Owl testOwl1 = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Owl testOwl2 = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        Owl testOwl3 = new Owl("Sheila", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));

        BirdOfPrey testHawk1 = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        BirdOfPrey testHawk2 = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.EGGS));
        BirdOfPrey testHawk3 = new BirdOfPrey(BirdType.HAWK, "Drew",
                List.of(FoodCategory.SMALL_MAMMALS));

        Waterfowl testGoose1 = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
        Waterfowl testGoose2 = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES, FoodCategory.BUDS));
        Waterfowl testGoose3 = new Waterfowl(BirdType.GOOSE, "Carson",
                List.of(FoodCategory.SEEDS, FoodCategory.BERRIES));

        Parrot testParrot1 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot2 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        Parrot testParrot3 = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                12, "Hello");

        assertEquals(testOwl1, testOwl2);
        assertEquals(testOwl2, testOwl1);
        assertNotEquals(testOwl1, testOwl3);

        assertEquals(testHawk1, testHawk2);
        assertEquals(testHawk2, testHawk1);
        assertNotEquals(testHawk1, testHawk3);

        assertEquals(testGoose1, testGoose2);
        assertEquals(testGoose2, testGoose1);
        assertNotEquals(testGoose1, testGoose3);

        assertEquals(testParrot1, testParrot2);
        assertEquals(testParrot2, testParrot1);
        assertNotEquals(testParrot1, testParrot3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEqualsNullException() {

        Shorebird testGreatAuk = new Shorebird(BirdType.GREAT_AUK, "Wendy",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES));
        Shorebird nullObj = null;
        assertEquals(testGreatAuk, nullObj);
    }

    /* -----------------------------------------------------------------------------
     * Testing `toString` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testToString() {

        BirdOfPrey testOsprey = new BirdOfPrey(BirdType.OSPREY, "June",
                List.of(FoodCategory.FISH));
        System.out.println(testOsprey);

        FlightlessBird testMoa = new FlightlessBird(BirdType.MOA, "Mira",
                List.of(FoodCategory.SEEDS, FoodCategory.FRUIT, FoodCategory.VEGETATION));
        System.out.println(testMoa);

        Owl testOwl = new Owl("Sam", List.of(FoodCategory.SMALL_MAMMALS, FoodCategory.OTHER_BIRDS));
        System.out.println(testOwl);

        Parrot testParrot = new Parrot("Tennessee", List.of(FoodCategory.FRUIT, FoodCategory.INSECTS),
                256, "Hello");
        System.out.println(testParrot);

        Pigeon testPigeon = new Pigeon("Rico", List.of(FoodCategory.SEEDS));
        System.out.println(testPigeon);

        Shorebird testHornedPuffin = new Shorebird(BirdType.HORNED_PUFFIN, "Fran",
                List.of(FoodCategory.FISH, FoodCategory.AQUATIC_INVERTEBRATES, FoodCategory.VEGETATION));
        System.out.println(testHornedPuffin);

        Waterfowl testSwan = new Waterfowl(BirdType.SWAN, "King",
                List.of(FoodCategory.VEGETATION));
        System.out.println(testSwan);
    }

} /* ****************************************************************************** */