package dungeon;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedievalLevelBuilderTest {

    MedievalLevelBuilder testBuilder;

    @Test
    public void testConstructor() {
        testBuilder = new MedievalLevelBuilder(1, 12,
                20, 6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorException() {
        testBuilder = new MedievalLevelBuilder(1, -1,
                20, 6);
    }

    @Test
    public void testAddRoom() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
    }

    @Test (expected = IllegalStateException.class)
    public void testAddRoomException() {
        testBuilder = new MedievalLevelBuilder(1, 2,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addRoom("A sole lantern flickers in the distance.");
        testBuilder.addRoom("A winding hallway.");
    }

    @Test
    public void testAddGoblins() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGoblins(0, 3);
    }

    @Test
    public void testAddOrc() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGoblins(0, 3);
        testBuilder.addOrc( 0);
    }

    @Test
    public void testAddOgre() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addRoom("A sole lantern flickers in the distance.");
        testBuilder.addGoblins(0, 3);
        testBuilder.addOrc( 0);
        testBuilder.addOgre(1);
    }

    @Test
    public void testAddHuman() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addRoom("A sole lantern flickers in the distance.");
        testBuilder.addGoblins(0, 3);
        testBuilder.addOrc( 0);
        testBuilder.addOgre(0);
        testBuilder.addHuman(1, "Devon", "a lost scholar.", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoblinInputException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGoblins(0, -8);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMonsterInputException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGoblins(-1, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddMonsterRoomException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGoblins(2, 8);
    }

    @Test (expected = IllegalStateException.class)
    public void testAddMonsterFullException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addRoom("A sole lantern flickers in the distance.");
        testBuilder.addGoblins(0, 8);
        testBuilder.addOrc( 0);
    }

    @Test
    public void testAddPotion() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addPotion(0);
    }

    @Test
    public void testAddGold() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGold(0, 55);
    }

    @Test
    public void testAddWeapon() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addWeapon(0, "a shining blade");
    }

    @Test
    public void testAddSpecial() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addSpecial(0, "a mysterious box", 9999);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoldInputException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGold(0, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddTreasureRoomException() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                8, 6);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addSpecial(3, "a mysterious box", 0);
    }

    @Test (expected = IllegalStateException.class)
    public void testAddTreasureFullException() {
        testBuilder = new MedievalLevelBuilder(1, 1,
                0, 2);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGold(0, 55);
        testBuilder.addWeapon(0, "a shining blade");
        testBuilder.addSpecial(0, "a mysterious box", 0);
    }

    @Test
    public void testBuild() {
        testBuilder = new MedievalLevelBuilder(1, 3,
                5, 3);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addRoom("A sole lantern flickers in the distance.");
        testBuilder.addRoom("A winding hallway.");

        testBuilder.addGoblins(0, 3);
        testBuilder.addOrc( 0);
        testBuilder.addOgre( 1);

        testBuilder.addGold(1, 55);
        testBuilder.addWeapon(0, "a shining blade");
        testBuilder.addSpecial(2, "a mysterious box", 0);
        testBuilder.build();
        System.out.println(testBuilder.getCurrLevel());
    }

    @Test (expected = IllegalStateException.class)
    public void testBuildException() {
        testBuilder = new MedievalLevelBuilder(1, 1,
                0, 5);
        testBuilder.addRoom("There is a black pit in the middle of the room.");
        testBuilder.addGold(0, 55);
        testBuilder.addWeapon(0, "a shining blade");
        testBuilder.addSpecial(0, "a mysterious box", 0);
        testBuilder.build();
    }

}