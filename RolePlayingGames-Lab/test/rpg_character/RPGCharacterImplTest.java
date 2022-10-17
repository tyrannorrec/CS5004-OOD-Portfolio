package rpg_character;

import gear.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RPGCharacterImplTest {

    RPGCharacter testChar1;
    RPGCharacter testChar2;

    HeadGear testHeadGear1 = new HeadGear("Hunter's", "Pelt", 20);
    HeadGear testHeadGear2 = new HeadGear("Sorrowful", "Helm", 23);
    HeadGear testHeadGear3 = new HeadGear("Faded", "Crown", 40);
    HandGear testHandGear1 = new HandGear("Welded", "Morningstar", 18);
    HandGear testHandGear2 = new HandGear("Burning", "Dagger", 4);
    HandGear testHandGear3 = new HandGear("Royal", "Gloves", 5);
    Footwear testFootwear1 = new Footwear("Doom", "Greaves", 22, 44);
    Footwear testFootwear2 = new Footwear("Hallowed", "Boots", 3, 2);
    Footwear testFootwear3 = new Footwear("Forged", "Shinguards", 0, 16);

    /* -----------------------------------------------------------------------------
     * Testing Constructors
     * ----------------------------------------------------------------------------*/
    @Test
    public void testConstructor() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar2 = new RPGCharacterImpl("Melion", 4, 12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorException() {
        testChar1 = new RPGCharacterImpl("Claus", 2, -2);
    }

    /* -----------------------------------------------------------------------------
     * Testing Getters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetName() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals("Jax", testChar1.getName());
    }

    @Test
    public void testGetBaseAttackStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals(22, testChar1.getBaseAttackStat());
    }

    @Test
    public void testGetBaseDefenseStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals(18, testChar1.getBaseDefenseStat());
    }

    @Test
    public void testGetTotalAttackStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals(22, testChar1.getTotalAttackStat());
    }

    @Test
    public void testGetTotalDefenseStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals(18, testChar1.getTotalDefenseStat());
    }

    /* -----------------------------------------------------------------------------
     * Testing Setters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testSetName() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.setName("Orrin");
        assertEquals("Orrin", testChar1.getName());
    }

    @Test
    public void testSetBaseAttackStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.setBaseAttackStat(23);
        assertEquals(23, testChar1.getBaseAttackStat());
    }

    @Test
    public void testSetBaseDefenseStat() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.setBaseDefenseStat(25);
        assertEquals(25, testChar1.getBaseDefenseStat());
    }

    /* -----------------------------------------------------------------------------
     * Testing `equip` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testEquip() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.equip(testHeadGear1);
        testChar1.equip(testHeadGear2);
        testChar1.equip(testHeadGear3);
        testChar1.equip(testHandGear1);
        testChar1.equip(testHandGear2);
        testChar1.equip(testHandGear3);
        testChar1.equip(testFootwear1);
        testChar1.equip(testFootwear2);
        testChar1.equip(testFootwear3);
    }

    /* -----------------------------------------------------------------------------
     * Testing Boolean Methods
     * ----------------------------------------------------------------------------*/
    @Test
    public void testHasOpenHeadGearSlot() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        assertTrue(testChar1.hasOpenHeadGearSlot());
        testChar1.equip(testHeadGear1);
        assertFalse(testChar1.hasOpenHeadGearSlot());
    }

    @Test
    public void testHasOpenHandGearSlot() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.equip(testHandGear1);
        assertTrue(testChar1.hasOpenHandGearSlot());
        testChar1.equip(testHandGear2);
        assertFalse(testChar1.hasOpenHandGearSlot());
    }

    @Test
    public void testHasOpenFootwearSlot() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.equip(testFootwear1);
        assertTrue(testChar1.hasOpenFootwearSlot());
        testChar1.equip(testFootwear2);
        assertFalse(testChar1.hasOpenFootwearSlot());
    }

    /* -----------------------------------------------------------------------------
     * Testing `compareTo` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testCompareTo() {
        testChar1 = new RPGCharacterImpl("Jax", 0, 0);
        testChar2 = new RPGCharacterImpl("Melion", 0, 0);
        testChar1.equip(testHeadGear1);
        testChar2.equip(testHeadGear2);
        assertEquals(-1, testChar1.compareTo(testChar2));
        testChar1.setBaseAttackStat(3);
        assertEquals(0, testChar1.compareTo(testChar2));
        testChar1.equip(testFootwear3);
        testChar2.equip(testFootwear2);
        assertEquals(1, testChar1.compareTo(testChar2));
    }


    /* -----------------------------------------------------------------------------
     * Testing `equals` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testEquals() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar2 = new RPGCharacterImpl("Jax", 22, 18);
        assertEquals(testChar1, testChar2);
        testChar1.equip(testHandGear1);
        assertNotEquals(testChar1, testChar2);
        testChar2.equip(testHandGear1);
        assertEquals(testChar1, testChar2);
    }

    /* -----------------------------------------------------------------------------
     * Testing `toString` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testToString() {
        testChar1 = new RPGCharacterImpl("Jax", 22, 18);
        testChar1.equip(testHeadGear1);
        testChar1.equip(testHeadGear2);
        testChar1.equip(testHeadGear3);
        testChar1.equip(testHandGear1);

        System.out.println(testChar1.toString() + "\n\n");

        testChar1.equip(testHandGear2);
        testChar1.equip(testHandGear3);
        testChar1.equip(testFootwear1);
        testChar1.equip(testFootwear2);
        testChar1.equip(testFootwear3);

        System.out.println(testChar1.toString());
    }
}