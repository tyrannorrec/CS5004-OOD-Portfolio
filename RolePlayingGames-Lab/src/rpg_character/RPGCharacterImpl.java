package rpg_character;

import gear.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* ******************************************************************************
 * Class     RPGCharacterImpl
 * Purpose   The RPGCharacterImpl class implements the RPGCharacter interface, and
 *               represents a character in a role-playing game. Each object of this
 *               class has a name, base attack and defense stats, and total attack
 *               and defense stats which increase when pieces of Gear are equipped.
 *               Each RPGCharacter also has a HeadGear slot, as well as multiple
 *               HandGear and Footwear slots; these are represented by separate
 *               attributes. While a Character can only wear one piece of HeadGear,
 *               the number of HandGear and Footwear that can be equipped is
 *               governed by the static constants declared as MAX_HANDGEAR and
 *               MAX_FOOTWEAR. Gear can be equipped via the `equip` function.
 *               Characters can also be compared via the `compareTo` function, which
 *               determines which of two characters would win a battle by evaluating
 *               their totalAttackStat and totalDefenseStat attribute values.
 * @attrib   'name'              --    (String)           name of the character
 * @attrib   'baseAttackStat'    --    (int)              base attack value
 * @attrib   'baseDefenseStat'   --    (int)              base defense value
 * @attrib   'totalAttackStat'   --    (int)              attack value considering gear
 * @attrib   'totalDefenseStat'  --    (int)              defense value considering gear
 * @attrib   'equippedHeadGear'  --    (HeadGear)         HeadGear equipped by character
 * @attrib   'equippedHandGear'  --    (List<HandGear>)   HandGear equipped by character
 * @attrib   'equippedFootwear'  --    (List<Footwear>)   Footwear equipped by character
 * ***************************************************************************** */
public class RPGCharacterImpl implements RPGCharacter {

    private static final int MAX_HANDGEAR = 2;
    private static final int MAX_FOOTWEAR = 2;

    String name;
    int baseAttackStat;
    int baseDefenseStat;
    int totalAttackStat;
    int totalDefenseStat;
    HeadGear equippedHeadGear;
    List<HandGear> equippedHandGear;
    List<Footwear> equippedFootwear;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Instantiates all attributes of the RPGCharacter. equippedHeadGear
     *             is set to null while equippedHandGear and equippedFootwear are
     *             instantiated as empty ArrayLists. Throws IllegalArgumentException
     *             if base stat parameters are negative.
     * @param    'inName'              --  (String)  name of the character
     * @param    'inBaseAttackStat'    --  (int)     base attack value of character
     * @param    'inBaseDefenseStat'   --  (int)     base defense value of character
     * ----------------------------------------------------------------------------*/
    public RPGCharacterImpl(String inName, int inBaseAttackStat, int inBaseDefenseStat) {

        if (inBaseAttackStat < 0 || inBaseDefenseStat < 0) {
            throw new IllegalArgumentException("Base stats must be non-negative.");
        }

        this.name = inName;
        this.baseAttackStat = inBaseAttackStat;
        this.baseDefenseStat  = inBaseDefenseStat;
        this.totalAttackStat = this.baseAttackStat;
        this.totalDefenseStat = this.baseDefenseStat;
        this.equippedHeadGear = null;
        this.equippedHandGear = new ArrayList<>(MAX_HANDGEAR);
        this.equippedFootwear = new ArrayList<>(MAX_FOOTWEAR);
    }

    /* -----------------------------------------------------------------------------
     * Method   `getName` returns the name of the RPGCharacter.
     * @param    None
     * @returns  (String) name of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    @Override
    public String getName() { return this.name; }

    /* -----------------------------------------------------------------------------
     * Method   `getBaseAttackStat` returns the base attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) base attack stat of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    @Override
    public int getBaseAttackStat() { return this.baseAttackStat; }

    /* -----------------------------------------------------------------------------
     * Method   `getBaseDefenseStat` returns the base attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) base defense stat of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    @Override
    public int getBaseDefenseStat() { return this.baseDefenseStat; }

    /* -----------------------------------------------------------------------------
     * Method   `getTotalAttackStat` returns the total attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) total attack stat of the RPGCharacter, considering equipment
     * ----------------------------------------------------------------------------*/
    @Override
    public int getTotalAttackStat() { return this.totalAttackStat; }

    /* -----------------------------------------------------------------------------
     * Method   `getTotalDefenseStat` returns the total defense stat of the RPGCharacter.
     * @param    None
     * @returns  (int) total defense stat of the RPGCharacter, considering equipment
     * ----------------------------------------------------------------------------*/
    @Override
    public int getTotalDefenseStat() { return this.totalDefenseStat; }

    /* -----------------------------------------------------------------------------
     * Method   `setName` replaces the RPGCharacter's name with a new name.
     * @param    (String) new name for the RPGCharacter
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setName(String inName) { this.name = inName; }

    /* -----------------------------------------------------------------------------
     * Method   `setBaseAttackStat` updates RPGCharacter's base attack to a new value.
     *            Also updates the totalAttackStat attribute to reflect this change.
     * @param    (int) new total attack value for the RPGCharacter.
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setBaseAttackStat(int inBaseAttackStat) {
        int difference = this.baseAttackStat - inBaseAttackStat;
        this.totalAttackStat -= difference;
        this.baseAttackStat = inBaseAttackStat;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setBaseDefenseStat` updates RPGCharacter's base defense to a new value.
     *            Also updates the totalDefenseStat attribute to reflect this change.
     * @param    (int) new total defense value for the RPGCharacter.
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setBaseDefenseStat(int inBaseDefenseStat) {
        int difference = this.baseDefenseStat - inBaseDefenseStat;
        this.totalDefenseStat -= difference;
        this.baseDefenseStat = inBaseDefenseStat;
    }

    /* -----------------------------------------------------------------------------
     * Method   `equip` takes in a piece of Gear as a parameter, determines the
     *            class of that Gear, and equips it to the Character. If there are
     *            no empty slots of that kind, `combine` is called to combine the
     *            new piece of gear with an equipped piece of Gear.
     * @param    'inGear'  (Gear)  Gear to be equipped by the character
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void equip(Gear inGear) {

        // If new gear is HeadGear
        if (inGear instanceof HeadGear) {

            // If no HeadGear equipped, equip new HeadGear
            if (this.equippedHeadGear == null) {
                this.equippedHeadGear = (HeadGear) inGear;
            }
            // Else, combine with existing HeadGear
            else {
                this.equippedHeadGear = (HeadGear) (this.equippedHeadGear.combine(inGear));
            }
        }

        // If new gear is HandGear
        if (inGear instanceof HandGear) {

            // If max number of HandGear already equipped, find weakest and combine with new HeadGear
            if (this.equippedHandGear.size() == MAX_HANDGEAR) {
                int weakIndex = 0;
                for (int i = 1; i < this.equippedHandGear.size(); i++) {
                    if (this.equippedHandGear.get(i).compareTo(this.equippedHandGear.get(weakIndex)) < 0) {
                        weakIndex = i;
                    }
                }
                HandGear inHandGear = (HandGear) (this.equippedHandGear.get(weakIndex).combine(inGear));
                this.equippedHandGear.set(weakIndex, inHandGear);
            }
            // Else, equip new HandGear in empty slot
            else {
                this.equippedHandGear.add(this.equippedHandGear.size(), (HandGear) inGear);
            }
        }

        // If new gear is Footwear
        if (inGear instanceof Footwear) {

            // If max number of Footwear already equipped, find weakest and combine with new Footwear
            if (this.equippedFootwear.size() == MAX_FOOTWEAR) {
                int weakIndex = 0;
                for (int i = 1; i < this.equippedFootwear.size(); i++) {
                    if (this.equippedFootwear.get(i).compareTo(this.equippedFootwear.get(weakIndex)) < 0) {
                        weakIndex = i;
                    }
                }
                Footwear inFootwear = (Footwear) (this.equippedFootwear.get(weakIndex).combine(inGear));
                this.equippedFootwear.set(weakIndex, inFootwear);
            }
            // Else, equip new Footwear in empty slot
            else {
                this.equippedFootwear.add(this.equippedFootwear.size(), (Footwear) inGear);
            }
        }

        // Update total attack and defense stats
        this.totalAttackStat += inGear.getAttackStat();
        this.totalDefenseStat += inGear.getDefenseStat();
    }

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenHeadGearSlot` returns true if there is an open slot for new
     *            HeadGear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean hasOpenHeadGearSlot() { return this.equippedHeadGear == null; }

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenHandGearSlot` returns true if there is an open slot for new
     *            HandGear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean hasOpenHandGearSlot() { return this.equippedHandGear.size() < MAX_HANDGEAR; }

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenFootwearSlot` returns true if there is an open slot for new
     *            Footwear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean hasOpenFootwearSlot() { return this.equippedFootwear.size() < MAX_FOOTWEAR; }

    /* -----------------------------------------------------------------------------
     * Method   `compareTo` determines whether a Character would win in a battle with
     *            another Character, by evaluating the difference between one's
     *            attack stat with the other's defense stat, and vice versa, to
     *            determine who sustained more damage in battle.
     * @param    'other'    (RPGCharacter)      the RPGCharacter to be compared to
     * @returns  (int) 1 if this Character would win the battle, -1 if they would lose,
     *                 or 0 if the battle would end in a draw
     * ----------------------------------------------------------------------------*/
    @Override
    public int compareTo(RPGCharacter other) {

        int damageOnThis = other.getTotalAttackStat() - this.getTotalDefenseStat();
        int damageOnOther = this.getTotalAttackStat() - other.getTotalDefenseStat();
        return Integer.compare(damageOnOther, damageOnThis);
    }

    /* -----------------------------------------------------------------------------
     * Method   `equals` determines whether two RPGCharacters' attributes are equivalent
     *            to each other's. Overridden to be used in testing.
     * @param    'obj'    (Object)      the RPGCharacter to be compared to
     * @returns  (boolean) true if the characters are equal; false if they are not
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }

        if (!(obj instanceof RPGCharacterImpl)) {
            throw new IllegalArgumentException("Argument must be an instance " +
                    "of the Character class hierarchy.");
        }

        RPGCharacterImpl other = (RPGCharacterImpl) obj;
        return (Objects.equals(this.name, other.name)) &&
                (this.baseAttackStat == other.baseAttackStat) &&
                (this.baseDefenseStat == other.baseDefenseStat) &&
                (this.totalAttackStat == other.totalAttackStat) &&
                (this.totalDefenseStat == other.totalDefenseStat) &&
                (this.equippedHeadGear == other.equippedHeadGear) &&
                (this.equippedHandGear.equals(other.equippedHandGear)) &&
                (this.equippedFootwear.equals(other.equippedFootwear));
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` prints a snapshot of the character's profile including
     *            their stats and details of the equipment they have equipped.
     * @param    None
     * @returns  (String) a text block with all the character's details
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        String printString = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n*\n" +
                "*    <<<  " + this.name + "  >>>\n*\n" +
                "*    Base Attack    >>   " + this.baseAttackStat + "\n" +
                "*    Base Defense   >>   " + this.baseDefenseStat + "\n" +
                "*    Total Attack   >>   " + this.totalAttackStat + "\n" +
                "*    Total Defense  >>   " + this.totalDefenseStat + "\n*\n" +
                "*   - - - - - - - - - - - - - -  EQUIPPED  - - - - - - - - - - - - - - - - *\n*\n" +
                "*    Head Gear  >>  ";

        if (this.equippedHeadGear == null) {
            printString = printString.concat("None\n");
        }
        else {
            printString = printString.concat(this.equippedHeadGear.toString() + "\n");
        }

        for (int i = 0; i < MAX_HANDGEAR; i++) {
            printString = printString.concat("*    Hand Gear  >>  ");
            if ( i < this.equippedHandGear.size()) {
                printString = printString.concat(this.equippedHandGear.get(i).toString() + "\n");
            }
            else {
                printString = printString.concat("None\n");
            }
        }

        for (int j = 0; j < MAX_FOOTWEAR; j++) {
            printString = printString.concat("*    Footwear   >>  ");
            if (j < this.equippedFootwear.size()) {
                printString = printString.concat(this.equippedFootwear.get(j).toString() + "\n");
            }
            else {
                printString = printString.concat("None\n");
            }
        }
        printString = printString.concat
                ("*\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        return printString;
    }

} /* ****************************************************************************** */
