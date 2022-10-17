package battle;

import gear.*;
import org.junit.Test;
import rpg_character.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BattleImplTest {

    Battle testBattle;
    RPGCharacter playerChar = new RPGCharacterImpl("Jax", 5, 5);
    RPGCharacter enemyChar = new RPGCharacterImpl("Melion", 7, 3);

    HeadGear head1 = new HeadGear("Hunter's", "Pelt", 20);
    HeadGear head2 = new HeadGear("Sorrowful", "Helm", 23);
    HeadGear head3 = new HeadGear("Faded", "Crown", 25);
    HandGear hand1 = new HandGear("Welded", "Morningstar", 18);
    HandGear hand2 = new HandGear("Burning", "Dagger", 12);
    HandGear hand3 = new HandGear("Royal", "Gloves", 5);
    Footwear foot1 = new Footwear("Doom", "Greaves", 11, 20);
    Footwear foot2 = new Footwear("Hallowed", "Boots", 3, 2);
    Footwear foot3 = new Footwear("Forged", "Shinguards", 0, 16);
    Footwear foot4 = new Footwear("Shrouded", "Greaves", 30, 9);

    List<Gear> sampleItemsList = new ArrayList<>(Arrays.asList
            (head1, head2, head3, hand1, hand2, hand3, foot1, foot2, foot3, foot4));

    /* -----------------------------------------------------------------------------
     * Testing Constructors
     * ----------------------------------------------------------------------------*/
    @Test
    public void testConstructor() {
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorException() {
        HeadGear head4 = new HeadGear("Horned", "Mask", 20);
        sampleItemsList.add(head4);
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
    }

    /* -----------------------------------------------------------------------------
     * Testing Getters
     * ----------------------------------------------------------------------------*/
    @Test
    public void testGetPlayer() {
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
        assertEquals(playerChar, testBattle.getPlayer());
    }

    @Test
    public void testGetEnemy() {
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
        assertEquals(enemyChar, testBattle.getEnemy());
    }

    @Test
    public void testGetItemsList() {
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
        assertEquals(sampleItemsList, testBattle.getItemsList());
    }

    /* -----------------------------------------------------------------------------
     * Testing `chooseItem` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testChooseItem() {
        playerChar = new RPGCharacterImpl("Jax", 0, 0);
        enemyChar = new RPGCharacterImpl("Melion", 0, 0);
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);

        testBattle.chooseItem(testBattle.getPlayer());
        assertEquals(30, testBattle.getPlayer().getTotalAttackStat());
        assertEquals(9, testBattle.getPlayer().getTotalDefenseStat());

        testBattle.chooseItem(testBattle.getEnemy());
        assertEquals(18, testBattle.getEnemy().getTotalAttackStat());
        assertEquals(0, testBattle.getEnemy().getTotalDefenseStat());

        testBattle.chooseItem(testBattle.getPlayer());
        assertEquals(42, testBattle.getPlayer().getTotalAttackStat());
        assertEquals(9, testBattle.getPlayer().getTotalDefenseStat());

        testBattle.chooseItem(testBattle.getEnemy());
        assertEquals(29, testBattle.getEnemy().getTotalAttackStat());
        assertEquals(20, testBattle.getEnemy().getTotalDefenseStat());
    }

    @Test (expected = IllegalStateException.class)
    public void testChooseItemException() {
        sampleItemsList = new ArrayList<>(List.of());
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
        testBattle.chooseItem(testBattle.getPlayer());
    }

    /* -----------------------------------------------------------------------------
     * Testing `printBattle` Method
     * ----------------------------------------------------------------------------*/
    @Test
    public void testPrintBattle() {
        testBattle = new BattleImpl(playerChar, enemyChar, sampleItemsList);
        testBattle.printBattle();
    }

}