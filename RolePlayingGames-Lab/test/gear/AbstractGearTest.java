package gear;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractGearTest {

    AbstractGear testAbstractGear;
    Footwear testFootwear;
    HandGear testHandGear;
    HeadGear testHeadGear;

    /* -----------------------------------------------------------------------------
     * Testing Constructors
     * ----------------------------------------------------------------------------*/
    @Test
    public void testConstructors() {
        testFootwear = new Footwear("Hallowed", "Boots", 3, 2);
        testHandGear = new HandGear("Ridged", "Buckler", 6);
        testHeadGear = new HeadGear("Festering", "Helm", 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorException() {
        testFootwear = new Footwear("Hallowed", "Boots", -2, 2);
    }

    /* -----------------------------------------------------------------------------
     * Testing Getters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetPrefix() {
        testHeadGear = new HeadGear("Festering", "Helm", 1);
        assertEquals("Festering", testHeadGear.getPrefix());
        testAbstractGear = (AbstractGear) testHeadGear;
        assertEquals("Festering", testAbstractGear.getPrefix());
    }

    @Test
    public void testGetBaseName() {
        testHandGear = new HandGear("Ridged", "Buckler", 6);
        assertEquals("Buckler", testHandGear.getBaseName());
        testAbstractGear = (AbstractGear) testHandGear;
        assertEquals("Buckler", testAbstractGear.getBaseName());
    }

    @Test
    public void testGetAttackStat() {
        testFootwear = new Footwear("Hallowed", "Boots", 3, 2);
        assertEquals(3, testFootwear.getAttackStat());
        testAbstractGear = (AbstractGear) testFootwear;
        assertEquals(3, testAbstractGear.getAttackStat());
        testHeadGear = new HeadGear("Festering", "Helm", 1);
        assertEquals(0, testHeadGear.getAttackStat());
    }

    @Test
    public void testGetDefenseStat() {
        testHeadGear = new HeadGear("Festering", "Helm", 1);
        assertEquals(1, testHeadGear.getDefenseStat());
        testAbstractGear = (AbstractGear) testHeadGear;
        assertEquals(1, testAbstractGear.getDefenseStat());
        testHandGear = new HandGear("Ridged", "Buckler", 6);
        assertEquals(0, testHandGear.getDefenseStat());
    }

    /* -----------------------------------------------------------------------------
     * Testing Setters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testSetPrefix() {
        testHeadGear = new HeadGear("Festering", "Helm", 1);
        testAbstractGear = (AbstractGear) testHeadGear;
        testAbstractGear.setPrefix("Royal");
        assertEquals("Royal", testAbstractGear.getPrefix());
    }

    @Test
    public void testSetBaseName() {
        testHandGear = new HandGear("Ridged", "Buckler", 6);
        testHandGear.setBaseName("Tower Shield");
        assertEquals("Tower Shield", testHandGear.getBaseName());
    }

    @Test
    public void testSetAttackStat() {
        testHandGear = new HandGear("Ridged", "Buckler", 6);
        testHandGear.setAttackStat(9);
        assertEquals(9, testHandGear.getAttackStat());
    }

    @Test
    public void testSetDefenseStat() {
        testFootwear = new Footwear("Hallowed", "Boots", 3, 2);
        testFootwear.setDefenseStat(10);
        testAbstractGear = (AbstractGear) testFootwear;
        assertEquals(10, testAbstractGear.getDefenseStat());
    }


    @Test (expected = IllegalStateException.class)
    public void testSetAttackStatException() {
        testHeadGear = new HeadGear("Faded", "Crown", 12);
        testHeadGear.setAttackStat(10);

    }

    @Test (expected = IllegalStateException.class)
    public void testSetDefenseStatException() {
        testHandGear = new HandGear("Jagged", "Shiv", 2);
        testHandGear.setDefenseStat(3);
    }

    /* -----------------------------------------------------------------------------
     * Testing `combine()` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testCombine() {
        HandGear testHandGear1 = new HandGear("Welded", "Morningstar", 18);
        HandGear testHandGear2 = new HandGear("Burning", "Dagger", 2);
        HandGear testHandGearExpected = new HandGear("Burning", "Welded Morningstar", 20);
        Gear testHandGearActual = testHandGear1.combine(testHandGear2);
        assertEquals(testHandGearExpected, testHandGearActual);

        HeadGear testHeadGear1 = new HeadGear("Hunter's", "Pelt", 20);
        HeadGear testHeadGear2 = new HeadGear("Sorrowful", "Helm", 23);
        HeadGear testHeadGearExpected = new HeadGear("Sorrowful", "Hunter's Pelt", 43);
        Gear testHeadGearActual = testHeadGear1.combine(testHeadGear2);
        assertEquals(testHeadGearExpected, testHeadGearActual);

        Footwear testFootwear1 = new Footwear("Doom", "Greaves", 22, 44);
        Footwear testFootwear2 = new Footwear("Iron", "Heels", 4, 10);
        Footwear testFootwearExpected = new Footwear("Iron", "Doom Greaves",
                26, 54);
        Gear testFootwearActual = testFootwear1.combine(testFootwear2);
        assertEquals(testFootwearExpected, testFootwearActual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCombineException() {
        testHeadGear = new HeadGear("Faded", "Crown", 12);
        testFootwear = new Footwear("Orion's", "Sandals", 32, 62);
        testHeadGear.combine(testFootwear);
    }

    /* -----------------------------------------------------------------------------
     * Testing `compareTo()` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testCompareTo() {
        HandGear testHandGear1 = new HandGear("Welded", "Morningstar", 20);
        HandGear testHandGear2 = new HandGear("Chipped", "Dagger", 2);
        int compareResult = testHandGear1.compareTo(testHandGear2);
        assertEquals(1, compareResult);

        HeadGear testHeadGear1 = new HeadGear("Hunter's", "Pelt", 20);
        HeadGear testHeadGear2 = new HeadGear("Sorrowful", "Helm", 23);
        compareResult = testHeadGear1.compareTo(testHeadGear2);
        assertEquals(-1, compareResult);

        compareResult = testHandGear1.compareTo(testHeadGear1);
        assertEquals(1, compareResult);
        compareResult = testHandGear2.compareTo(testHeadGear2);
        assertEquals(1, compareResult);

        Footwear testFootwear1 = new Footwear("Doom", "Greaves", 2, 80);
        Footwear testFootwear2 = new Footwear("Iron", "Heels", 4, 2);
        compareResult = testFootwear1.compareTo(testFootwear2);
        assertEquals(-1, compareResult);

        compareResult = testFootwear1.compareTo(testHandGear2);
        assertEquals(1, compareResult);

        HandGear testHandGear3 = new HandGear("Worn", "Hide Gloves", 2);
        compareResult = testHandGear2.compareTo(testHandGear3);
        assertEquals(0, compareResult);
    }

    /* -----------------------------------------------------------------------------
     * Testing `equals()` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testEquals() {
        HandGear testHandGear1 = new HandGear("Burning", "Dagger", 2);
        HandGear testHandGear2 = new HandGear("Burning", "Dagger", 2);
        HandGear testHandGear3 = new HandGear("Burning", "Dagger", 3);
        assertEquals(testHandGear1, testHandGear2);
        assertNotEquals(testHandGear1, testHandGear3);

        Footwear testFootwear1 = new Footwear("Hallowed", "Boots", 3, 2);
        Footwear testFootwear2 = new Footwear("Hallowed", "Boots", 3, 2);
        Footwear testFootwear3 = new Footwear("Shallow", "Boots", 3, 2);
        assertEquals(testFootwear1, testFootwear2);
        assertNotEquals(testFootwear1, testFootwear3);

        HeadGear testHeadGear1 = new HeadGear("Sorrowful", "Helm", 23);
        HeadGear testHeadGear2 = new HeadGear("Sorrowful", "Helm", 23);
        HeadGear testHeadGear3 = new HeadGear("Sorrowful", "Hat", 23);
        assertEquals(testHeadGear1, testHeadGear2);
        assertNotEquals(testHeadGear1, testHeadGear3);
    }


    /* -----------------------------------------------------------------------------
     * Testing `toString()` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testToString() {
        testHeadGear = new HeadGear("Sorrowful", "Hunter's Pelt", 43);
        testHandGear = new HandGear("Burning", "Welded Morningstar", 20);
        testFootwear = new Footwear("Iron", "Doom Greaves", 26, 54);
        System.out.println(testHeadGear);
        System.out.println(testHandGear);
        System.out.println(testFootwear);
    }

} /* ****************************************************************************** */