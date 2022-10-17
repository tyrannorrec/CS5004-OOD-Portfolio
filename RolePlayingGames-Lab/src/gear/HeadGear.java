package gear;

/* ******************************************************************************
 * Class     HeadGear
 * Purpose   The HeadGear class extends the AbstractGear class and represents any
 *               gear that can be worn on a Character's head, such as hats,
 *               helmets, or visors. It is a purely defensive Gear type that has
 *               only a defense stat; its `attackStat` attribute is always 0.
 * @attrib   'prefix'        --    (String)    the adjective describing the Gear
 * @attrib   'baseName'      --    (String)    the base name of the Gear
 * @attrib   'attackStat'    --    (int)       the attack stat of the Gear
 * @attrib   'defenseStat'   --    (int)       the defense stat of the Gear
 * ***************************************************************************** */
public class HeadGear extends AbstractGear {

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Calls the super constructor to instantiate the `prefix` and `baseName`
     *             attributes. Instantiates `defenseStat` with input and sets `attackStat`
     *             to 0, since HeadGear do not have defensive properties.
     * @param    'inPrefix'      --  (String)  the adjective describing the Gear
     * @param    'inBaseName'    --  (String)  the base name of the Gear
     * @param    'inDefenseStat'  --  (int)     the defense stat of the Gear
     * ----------------------------------------------------------------------------*/
    public HeadGear(String inPrefix, String inBaseName, int inDefenseStat) {
        super(inPrefix, inBaseName);

        if (inDefenseStat < 0) {
            throw new IllegalArgumentException("Defense stat must be non-negative.");
        }

        this.attackStat = 0;
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
    public Gear combineStats(Gear other) {

        if (!(other instanceof HeadGear)) {
            throw new IllegalArgumentException("Arg is not the same class as this object.");
        }
        int combinedDefense = this.defenseStat + ((HeadGear) other).defenseStat;
        return new HeadGear("", "", combinedDefense);
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the full name and stat values of the HeadGear.
     * @param    None
     * @returns  (String) the full name and stats of the HeadGear
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return super.toString() + " -- defense: " + this.defenseStat;
    }

} /* ****************************************************************************** */

