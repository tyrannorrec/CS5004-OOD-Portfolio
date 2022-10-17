package battle;

import gear.*;
import rpg_character.*;

import java.util.ArrayList;
import java.util.List;

/* ******************************************************************************
 * Class     BattleImpl
 * Purpose   The BattleImpl class implements the Battle interface, and is a driver
 *               class representing a conflict between two characters in a role-playing
 *               game. Each object of this driver class will be instantiated with
 *               a player RPGCharacter, an enemy RPGCharacter, and a list of 10 items
 *               from which the two characters must equip themselves turn by turn.
 *               The `chooseItem` method implements a priority check for characters
 *               to choose the best gear during each turn. The `printBattle` method
 *               automates the battle and prints the results of each turn and the
 *  `            entirety of the battle.
 * @attrib   'player'      --    (RPGCharacter)    the player character
 * @attrib   'enemy'       --    (RPGCharacter)    the enemy character
 * @attrib   'itemsList'   --    (List<Gear>)      a list of 10 pieces of gear
 * ***************************************************************************** */
public class BattleImpl implements Battle {

    private static final int MAX_ITEMS = 10;

    private final RPGCharacter player;
    private final RPGCharacter enemy;
    private final List<Gear> itemsList;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Instantiates all attributes of the BattleImpl object. Throws
     *             an IllegalArgumentException if number of elements in inItemsList
     *             is greater than MAX_ITEMS static constant.
     * @param   'inPlayer'      --    (RPGCharacter)    the player character
     * @param   'inEnemy'       --    (RPGCharacter)    the enemy character
     * @param   'inItemsList'   --    (List<Gear>)      a list of 10 pieces of gear
     * ----------------------------------------------------------------------------*/
    public BattleImpl(RPGCharacter inPlayer, RPGCharacter inEnemy, List<Gear> inItemsList) {

        if (inItemsList.size() > MAX_ITEMS) {
            throw new IllegalArgumentException("Items list is too large.");
        }
        this.player = inPlayer;
        this.enemy = inEnemy;
        this.itemsList = inItemsList;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getPlayer` returns the player RPGCharacter in the Battle.
     * @param    None
     * @returns  (RPGCharacter) the player RPGCharacter
     * ----------------------------------------------------------------------------*/
    @Override
    public RPGCharacter getPlayer() { return this.player; }

    /* -----------------------------------------------------------------------------
     * Method   `getEnemy` returns the enemy RPGCharacter in the Battle.
     * @param    None
     * @returns  (RPGCharacter) the enemy RPGCharacter
     * ----------------------------------------------------------------------------*/
    @Override
    public RPGCharacter getEnemy() { return this.enemy; }

    /* -----------------------------------------------------------------------------
     * Method   `getItemsList` returns the contents of the itemsList attribute.
     * @param    None
     * @returns  (List<Gear>) all pieces of gear to be chosen in the battle
     * ----------------------------------------------------------------------------*/
    @Override
    public List<Gear> getItemsList() { return this.itemsList; }

    /* -----------------------------------------------------------------------------
     * Method   `chooseItem` determines which gear is to be chosen by the character
     *            during their turn, based on 1) whether that character has an open
     *            slot for a type of gear, 2) which gear has the highest attack,
     *            and 3) which gear has the highest defense. The gear chosen is
     *            equipped to the character and removed from itemsList. If itemsList
     *            is empty when method is called, throw an IllegalStateException.
     * @param   'inChar'      --    (RPGCharacter)    the character choosing the item
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void chooseItem(RPGCharacter inChar) {

        if (itemsList.size() == 0) {
            throw new IllegalStateException("The item list is empty!");
        }

        // Instantiate array lists to hold specific gear types
        List<Gear> headGearList = new ArrayList<>();
        List<Gear> handGearList = new ArrayList<>();
        List<Gear> footwearList = new ArrayList<>();

        // Parse through itemsList and copy gear to appropriate lists
        for (Gear gear : this.itemsList) {
            if (gear instanceof HeadGear) {
                headGearList.add(gear);
            }
            else if (gear instanceof HandGear) {
                handGearList.add(gear);
            }
            else {
                footwearList.add(gear);
            }
        }

        // Instantiate new list from which gear will be chosen
        List<Gear> candidatesList = new ArrayList<>();

        // If char has open head, hand, or foot slot, add that type's list
        // to the candidatesList

        if (inChar.hasOpenHeadGearSlot()) {
            candidatesList.addAll(headGearList);
        }

        if (inChar.hasOpenHandGearSlot()) {
            candidatesList.addAll(handGearList);
        }

        if (inChar.hasOpenFootwearSlot()) {
            candidatesList.addAll(footwearList);
        }

        // If char has all slots already filled, add all items in itemsList to
        // candidatesList
        if (candidatesList.isEmpty()) {
            candidatesList.addAll(this.itemsList);
        }

        // Find the gear with the best stats in the candidatesList
        Gear maxStatsGear = findBestGear(candidatesList);
        // Equip the gear and remove it from this.itemsList
        inChar.equip(maxStatsGear);
        this.itemsList.removeIf(gear -> gear == maxStatsGear);
    }

    /* -----------------------------------------------------------------------------
     * Method   `findBestGear` determines which Gear obj in a list of Gear has the
     *            highest stats, and that obj
     * @param   'inList'      --    (List<Gear>)    the list of Gear to parse from
     * @returns  None
     * ----------------------------------------------------------------------------*/
    private Gear findBestGear(List<Gear> inList) {
        Gear maxStatsGear = inList.get(0);
        for (Gear gear: inList) {
            if (gear.compareTo(maxStatsGear) > 0) {
                maxStatsGear = gear;
            }
        }
        return maxStatsGear;
    }

    /* -----------------------------------------------------------------------------
     * Method   `printBattleStatus` prints the current status of both Characters
     *            involved in the Battle, and which turn it currently is.
     * @param   'turn'      --    (int)    the current turn in the Battle
     * @returns  None
     * ----------------------------------------------------------------------------*/
    private void printBattleStatus(int turn) {
        System.out.println(
                "\t\t\t\t\t > > > > >     TURN " + turn + "     < < < < <\n\n" +
                        "/ / / / / / / / / / / / / / /      PLAYER      / / / / / / / / / / / / / / /\n"
                        + this.player + "\n\n" +
                        "/ / / / / / / / / / / / / / /      ENEMY      / / / / / / / / / / / / / / /\n"
                        + this.enemy + "\n\n" +
                        "\t\t\t\t    > > > > >     TURN " + turn + " END     < < < < <\n\n" +
                        "\t\t\t\t    --------------------------------------\n");
    }

    /* -----------------------------------------------------------------------------
     * Method   `printBattle` prints the entire battle, including the status of each
     *            character after choosing a piece of Gear. Also prints the results
     *            of the Battle.
     * @param    None
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void printBattle() {

        System.out.println(
                "The battle begins!\n" + MAX_ITEMS + " pieces of gear are strewn across the battlefield...\n");

        printBattleStatus(0);
        int turn = 1;
        while (!this.itemsList.isEmpty()) {
            this.chooseItem(this.player);
            this.chooseItem(this.enemy);
            printBattleStatus(turn);
            turn++;
        }

        int playerDamage = this.enemy.getTotalAttackStat() - this.player.getTotalDefenseStat();
        int enemyDamage = this.player.getTotalAttackStat() - this.enemy.getTotalDefenseStat();

        System.out.println("\t\t\t\t\t > > > > >     RESULTS     < < < < <\n\n" +
                "(PLAYER) " + this.player.getName() + " has " + this.player.getTotalAttackStat() +
                " attack strength and " + this.player.getTotalDefenseStat() + " defense strength.\n" +
                "(ENEMY) " + this.enemy.getName() + " has " + this.enemy.getTotalAttackStat() +
                " attack strength and " + this.enemy.getTotalDefenseStat() + " defense strength.\n\n" +
                "The battle ends with " + this.player.getName() + " having " + playerDamage +
                " units of damage and " + this.enemy.getName() + " having " + enemyDamage +
                " units of damage.\n");

        if (this.player.compareTo(this.enemy) < 0) {
            System.out.println(this.enemy.getName() + " wins the battle!");
        }

        else if (this.player.compareTo(this.enemy) > 0) {
            System.out.println(this.player.getName() + " wins the battle!");
        }

        else {
            System.out.println("The battle ends in a draw!");
        }
    }

} /* ****************************************************************************** */
