package rpg_character;

import gear.*;

/* ******************************************************************************
 * Interface  RPGCharacter
 * Purpose    The RPGCharacter interface models the methods available to any class
 *            depicting a character in a role-playing game. These methods include
 *            getters and setters for the name and base stats of the Character,
 *            as well as getters for its total attack and defense stats. A piece of
 *            Gear can be equipped to the character via the `equip` method. The
 *            RPGCharacter interface extends the Comparable interface. It is
 *            implemented by the RPGCharacterImpl class.
 * ***************************************************************************** */
public interface RPGCharacter extends Comparable<RPGCharacter> {

    /* -----------------------------------------------------------------------------
     * Method   `getName` returns the name of the RPGCharacter.
     * @param    None
     * @returns  (String) name of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    String getName();

    /* -----------------------------------------------------------------------------
     * Method   `getBaseAttackStat` returns the base attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) base attack stat of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    int getBaseAttackStat();

    /* -----------------------------------------------------------------------------
     * Method   `getBaseDefenseStat` returns the base attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) base defense stat of the RPGCharacter.
     * ----------------------------------------------------------------------------*/
    int getBaseDefenseStat();

    /* -----------------------------------------------------------------------------
     * Method   `getTotalAttackStat` returns the total attack stat of the RPGCharacter.
     * @param    None
     * @returns  (int) total attack stat of the RPGCharacter, considering equipment
     * ----------------------------------------------------------------------------*/
    int getTotalAttackStat();

    /* -----------------------------------------------------------------------------
     * Method   `getTotalDefenseStat` returns the total defense stat of the RPGCharacter.
     * @param    None
     * @returns  (int) total defense stat of the RPGCharacter, considering equipment
     * ----------------------------------------------------------------------------*/
    int getTotalDefenseStat();

    /* -----------------------------------------------------------------------------
     * Method   `setName` replaces the RPGCharacter's name with a new name.
     * @param    (String) new name for the RPGCharacter
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setName(String inName);

    /* -----------------------------------------------------------------------------
     * Method   `setBaseAttackStat` updates RPGCharacter's base attack to a new value.
     *            Also updates the totalAttackStat attribute to reflect this change.
     * @param    (int) new total attack value for the RPGCharacter.
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setBaseAttackStat(int inBaseAttackStat);

    /* -----------------------------------------------------------------------------
     * Method   `setBaseDefenseStat` updates RPGCharacter's base defense to a new value.
     *            Also updates the totalDefenseStat attribute to reflect this change.
     * @param    (int) new total defense value for the RPGCharacter.
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setBaseDefenseStat(int inBaseDefenseStat);

    /* -----------------------------------------------------------------------------
     * Method   `equip` takes in a piece of Gear as a parameter, determines the
     *            class of that Gear, and equips it to the Character. If there are
     *            no empty slots of that kind, `combine` is called to combine the
     *            new piece of gear with an equipped piece of Gear.
     * @param    'inGear'  (Gear)  Gear to be equipped by the character
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void equip(Gear inGear);

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenHeadGearSlot` returns true if there is an open slot for new
     *            HeadGear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    boolean hasOpenHeadGearSlot();

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenHandGearSlot` returns true if there is an open slot for new
     *            HandGear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    boolean hasOpenHandGearSlot();

    /* -----------------------------------------------------------------------------
     * Method   `hasOpenFootwearSlot` returns true if there is an open slot for new
     *            Footwear to be equipped and false if all slots are full.
     * @param    None
     * @returns  (boolean)  true or false
     * ----------------------------------------------------------------------------*/
    boolean hasOpenFootwearSlot();

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
    int compareTo(RPGCharacter other);

    /* -----------------------------------------------------------------------------
     * Method   `equals` determines whether two RPGCharacters' attributes are equivalent
     *            to each other's. Overridden to be used in testing.
     * @param    'obj'    (Object)      the RPGCharacter to be compared to
     * @returns  (boolean) true if the characters are equal; false if they are not
     * ----------------------------------------------------------------------------*/
    @Override
    boolean equals(Object obj);

    /* -----------------------------------------------------------------------------
     * Method   `toString` prints a snapshot of the character's profile including
     *            their stats and details of the equipment they have equipped.
     * @param    None
     * @returns  (String) a text block with all the character's details
     * ----------------------------------------------------------------------------*/
    @Override
    String toString();

} /* ****************************************************************************** */
