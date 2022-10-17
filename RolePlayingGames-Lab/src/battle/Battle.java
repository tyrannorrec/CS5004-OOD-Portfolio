package battle;

import gear.*;
import rpg_character.*;

import java.util.List;

/* ******************************************************************************
 * Interface  Battle
 * Purpose    The Battle interface models the methods available to a driver class
 *            depicting a battle between two RPGCharacter objects. Each battle
 *            must depict a conflict between a player character and an enemy character;
 *            during the battle, the player and enemy take turns to choose the most
 *            powerful piece of equipment from a list of 10 pieces of Gear until
 *            no Gear is left. The status of each character should be printed after
 *            each turn. The results of the battle should then be printed. The Battle
 *            interface is implemented by the BattleImpl class.
 * ***************************************************************************** */
public interface Battle {

    /* -----------------------------------------------------------------------------
     * Method   `getPlayer` returns the player RPGCharacter in the Battle.
     * @param    None
     * @returns  (RPGCharacter) the player RPGCharacter
     * ----------------------------------------------------------------------------*/
    RPGCharacter getPlayer();

    /* -----------------------------------------------------------------------------
     * Method   `getEnemy` returns the enemy RPGCharacter in the Battle.
     * @param    None
     * @returns  (RPGCharacter) the enemy RPGCharacter
     * ----------------------------------------------------------------------------*/
    RPGCharacter getEnemy();

    /* -----------------------------------------------------------------------------
     * Method   `getItemsList` returns the contents of the itemsList attribute.
     * @param    None
     * @returns  (List<Gear>) all pieces of gear to be chosen in the battle
     * ----------------------------------------------------------------------------*/
    List<Gear> getItemsList();

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
    void chooseItem(RPGCharacter inChar);

    /* -----------------------------------------------------------------------------
     * Method   `printBattleStatus` prints the current status of both Characters
     *            involved in the Battle, and which turn it currently is.
     * @param   'turn'      --    (int)    the current turn in the Battle
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void printBattle();

} /* ****************************************************************************** */
