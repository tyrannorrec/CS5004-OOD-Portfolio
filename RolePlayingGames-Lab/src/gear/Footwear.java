package gear;

/* ******************************************************************************
 * Class     Footwear
 * Purpose   The Footwear class extends the AbstractGear class and represents any
 *               gear that can be worn on a Character's feet, such as boots,
 *               sneakers, or hoverboards. It is a hybrid gear type that has both
 *               an attack and defense stat.
 * @attrib   'prefix'        --    (String)    the adjective describing the gear.Gear
 * @attrib   'baseName'      --    (String)    the base name of the gear.Gear
 * @attrib   'attackStat'    --    (int)       the attack stat of the gear.Gear
 * @attrib   'defenseStat'   --    (int)       the defense stat of the gear.Gear
 * ***************************************************************************** */
public class Footwear extends AbstractGear {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Calls the super constructor to instantiate the `prefix` and `baseName`
     *             attributes. Instantiates `attackStat` and `defenseStat` with inputs.
     * @param    'inPrefix'      --  (String)  the adjective describing the Gear
     * @param    'inBaseName'    --  (String)  the base name of the Gear
     * @param    'inAttackStat'  --  (int)     the attack stat of the Gear
     * @param    'inDefenseStat' --  (int)     the defense stat of the Gear
     * ----------------------------------------------------------------------------*/
    public Footwear(String inPrefix, String inBaseName, int inAttackStat, int inDefenseStat) {

        super(inPrefix, inBaseName);

        if (inAttackStat < 0 || inDefenseStat < 0) {
            throw new IllegalArgumentException("Attack and defense stats must be non-negative.");
        }

        this.attackStat = inAttackStat;
        this.defenseStat = inDefenseStat;
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
    protected Gear combineStats(Gear other) {

        if (!(other instanceof Footwear)) {
            throw new IllegalArgumentException("Arg is not the same class as this object.");
        }

        int combinedAttack = this.attackStat + ((Footwear) other).attackStat;
        int combinedDefense = this.defenseStat + ((Footwear) other).defenseStat;
        return new Footwear("", "", combinedAttack, combinedDefense);
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the full name and stat values of the Footwear.
     * @param    None
     * @returns  (String) the full name and stats of the Footwear
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return super.toString() + " -- defense: " + this.defenseStat +
                ", attack: " + this.attackStat;
    }

} /* ****************************************************************************** */

