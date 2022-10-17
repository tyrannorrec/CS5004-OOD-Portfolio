package dungeon;

public class MedievalLevelBuilder {

    private Level currLevel;
    private final int levelNumber;
    private final int targetRoomCount;
    private final int targetMonsterCount;
    private final int targetTreasureCount;

    private int currRoomCount;
    private int currMonsterCount;
    private int currTreasureCount;


    public MedievalLevelBuilder(int inLevelNumber, int inTargetRoomCount,
                         int inTargetMonsterCount, int inTargetTreasureCount) {

        if (inLevelNumber < 0 || inTargetRoomCount < 0 ||
                inTargetMonsterCount < 0 || inTargetTreasureCount < 0) {
            throw new IllegalArgumentException("All parameters should be non-negative integers.");
        }

        this.levelNumber = inLevelNumber;
        this.currLevel = new Level(this.levelNumber);
        this.targetRoomCount = inTargetRoomCount;
        this.targetMonsterCount = inTargetMonsterCount;
        this.targetTreasureCount = inTargetTreasureCount;
        this.currRoomCount = 0;
        this.currMonsterCount = 0;
        this.currTreasureCount = 0;
    }

    public Level build() {

        if (this.currRoomCount != this.targetRoomCount) {
            throw new IllegalStateException("The level is not complete. More rooms must be added.");
        }

        else if (this.currMonsterCount != this.targetMonsterCount) {
            throw new IllegalStateException("The level is not complete. More monsters must be added.");
        }

        else if (this.currTreasureCount != this.targetTreasureCount) {
            throw new IllegalStateException("The level is not complete. More treasures must be added.");
        }

        return this.currLevel;
    }

    public void addRoom(String inDescription) {

        if (this.currRoomCount == this.targetRoomCount) {
            throw new IllegalStateException("No more rooms can be added to this level.");
        }
        currLevel.addRoom(inDescription);
        this.currRoomCount++;
    }

    public void addGoblins(int inRoomNumber, int numGoblins) {

        throwAddMonsterExceptions(inRoomNumber);

        if (numGoblins < 0) {
            throw new IllegalArgumentException("Number of goblins must be non-negative.");
        }

        String inName = "goblin";
        String inDescription = "mischievous and very unpleasant, vengeful, and greedy creature " +
                "whose primary purpose is to cause trouble to humankind";
        int inHitpoints = 7;

        for (int i = 0; i < numGoblins; i++) {
            Monster inGoblin = new Monster(inName, inDescription, inHitpoints);
            this.currLevel.addMonster(inRoomNumber, inGoblin);
            this.currMonsterCount++;
        }
    }

    public void addOrc(int inRoomNumber) {

        throwAddMonsterExceptions(inRoomNumber);

        String inName = "orc";
        String inDescription = "brutish, aggressive, malevolent being serving evil";
        int inHitpoints = 20;

        Monster inOrc = new Monster(inName, inDescription, inHitpoints);
        this.currLevel.addMonster(inRoomNumber, inOrc);
        this.currMonsterCount++;
    }

    public void addOgre(int inRoomNumber) {

        throwAddMonsterExceptions(inRoomNumber);

        String inName = "ogre";
        String inDescription = "large, hideous man-like being that likes to eat humans for lunch";
        int inHitpoints = 50;

        Monster inOgre = new Monster(inName, inDescription, inHitpoints);
        this.currLevel.addMonster(inRoomNumber, inOgre);
        this.currMonsterCount++;
    }

    public void addHuman(int inRoomNumber, String inName, String inDescription, int inHitpoints) {

        throwAddMonsterExceptions(inRoomNumber);

        Monster inHuman = new Monster(inName, inDescription, inHitpoints);
        this.currLevel.addMonster(inRoomNumber, inHuman);
        this.currMonsterCount++;
    }

    private void throwAddMonsterExceptions(int inRoomNumber) {

        if (inRoomNumber < 0) {
            throw new IllegalArgumentException("The room number must be a non-negative number.");
        }

        if (inRoomNumber >= currRoomCount) {
            throw new IllegalArgumentException("The target room does not yet exist.");
        }

        if (this.currMonsterCount == this.targetMonsterCount) {
            throw new IllegalStateException("No more monsters can be added to this level.");
        }
    }

    public void addPotion(int inRoomNumber) {

        throwAddTreasureExceptions(inRoomNumber);

        String inDescription = "a healing potion";
        int inValue = 1;

        Treasure inTreasure = new Treasure(inDescription, inValue);
        this.currLevel.addTreasure(inRoomNumber, inTreasure);
        this.currTreasureCount++;
    }

    public void addGold(int inRoomNumber, int inValue) {

        throwAddTreasureExceptions(inRoomNumber);

        if (inValue < 1) {
            throw new IllegalArgumentException("Value of gold should be greater than 0.");
        }

        String inDescription = "pieces of gold";

        Treasure inTreasure = new Treasure(inDescription, inValue);
        this.currLevel.addTreasure(inRoomNumber, inTreasure);
        this.currTreasureCount++;
    }

    public void addWeapon(int inRoomNumber, String inDescription) {

        throwAddTreasureExceptions(inRoomNumber);

        int inValue = 10;

        Treasure inTreasure = new Treasure(inDescription, inValue);
        this.currLevel.addTreasure(inRoomNumber, inTreasure);
        this.currTreasureCount++;
    }

    public void addSpecial(int inRoomNumber, String inDescription, int inValue) {

        throwAddTreasureExceptions(inRoomNumber);

        if (inValue < 0) {
            throw new IllegalArgumentException("Value of gold should be non-negative.");
        }

        Treasure inTreasure = new Treasure(inDescription, inValue);
        this.currLevel.addTreasure(inRoomNumber, inTreasure);
        this.currTreasureCount++;
    }

    private void throwAddTreasureExceptions(int inRoomNumber) {

        if (inRoomNumber < 0) {
            throw new IllegalArgumentException("The room number must be a non-negative number.");
        }

        if (inRoomNumber >= currRoomCount) {
            throw new IllegalArgumentException("The target room does not yet exist.");
        }

        if (this.currTreasureCount == this.targetTreasureCount) {
            throw new IllegalStateException("No more treasures can be added to this level.");
        }
    }

    public Level getCurrLevel() { return this.currLevel; }

}
