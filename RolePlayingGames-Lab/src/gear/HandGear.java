package gear;

/* ******************************************************************************
 * Class     HandGear
 * Purpose   The HandGear class extends the AbstractGear class and represents any
 *               gear that can be used by a Character's hands, such as gloves,
 *               swords, or shields. It is a purely offensive gear type that has
 *               only an attack stat; its `defenseStat` attribute is always 0.
 * @attrib   'prefix'        --    (String)    the adjective describing the gear.Gear
 * @attrib   'baseName'      --    (String)    the base name of the gear.Gear
 * @attrib   'attackStat'    --    (int)       the attack stat of the gear.Gear
 * @attrib   'defenseStat'   --    (int)       the defense stat of the gear.Gear
 * ***************************************************************************** */
public class HandGear extends AbstractGear {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Calls the super constructor to instantiate the `prefix` and `baseName`
     *             attributes. Instantiates `attackStat` with input and sets `defenseStat`
     *             to 0, since HandGear do not have defensive properties.
     * @param    'inPrefix'      --  (String)  the adjective describing the gear.Gear
     * @param    'inBaseName'    --  (String)  the base name of the gear.Gear
     * @param    'inAttackStat'  --  (int)     the attack stat of the gear.Gear
     * ----------------------------------------------------------------------------*/
    public HandGear(String inPrefix, String inBaseName, int inAttackStat) {
        super(inPrefix, inBaseName);

        if (inAttackStat < 0) {
            throw new IllegalArgumentException("Attack stat must be non-negative.");
        }

        this.attackStat = inAttackStat;
        this.defenseStat = 0;
    }

    /* -----------------------------------------------------------------------------
     * Method   `combineStats` checks whether the two pieces of Gear to be combined
     *            are of the same type. Then, if applicable, a new piece of Gear
     *            is created and returned with the combined stats of the two pieces
     *            of Gear.
     * @param    `other`    (Gear)      the piece of Gear to be combined
     * @returns             (Gear)      the piece of Gear with combined stats
     * ----------------------------------------------------------------------------*/
    @Override
    public Gear combineStats(Gear other) {

        if (!(other instanceof HandGear)) {
            throw new IllegalArgumentException("Arg is not the same class as this object.");
        }
        int combinedAttack = this.attackStat + ((HandGear) other).attackStat;
        return new HandGear("", "", combinedAttack);
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the full name and stat values of the HandGear.
     * @param    None
     * @returns  (String) the full name and stats of the HandGear
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return super.toString() + " -- attack: " + this.attackStat;
    }

} /* ****************************************************************************** */

