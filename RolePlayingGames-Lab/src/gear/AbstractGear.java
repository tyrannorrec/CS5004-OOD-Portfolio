package gear;

import java.util.Objects;

/* ******************************************************************************
 * Class     AbstractGear
 * Purpose   The AbstractGear class represents the parent class of three categories
 *               of Gear, namely HeadGear, HandGear, and Footwear. Each AbstractGear
 *               object has a prefix, base name, and an attack and defense stat.
 *               If the child class is a purely offensive gear, as in HandGear, then
 *               the defense stat is set to zero. The reverse is true of HeadGear, a
 *               purely defensive gear. Any two pieces of AbstractGear of the same
 *               child class can be combined into a single piece of Gear. The `compareTo`
 *               method compares any two pieces of Gear from any child class primarily
 *               by their attack stat and secondarily by their defense stat.
 * @attrib   'prefix'        --    (String)    the adjective describing the Gear
 * @attrib   'baseName'      --    (String)    the base name of the Gear
 * @attrib   'attackStat'    --    (int)       the attack stat of the Gear
 * @attrib   'defenseStat'   --    (int)       the defense stat of the Gear
 * ***************************************************************************** */
public abstract class AbstractGear implements Gear {

    protected String prefix;
    protected String baseName;
    protected int attackStat;
    protected int defenseStat;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Only called by child class constructors. Instantiates `prefix` and
     *             `baseName` attributes with inputs.
     * @param    'inPrefix'     --  (String)  the adjective describing the Gear
     * @param    'inBaseName'   --  (String)  the base name of the Gear
     * ----------------------------------------------------------------------------*/
    AbstractGear(String inPrefix, String inBaseName) {
        this.prefix = inPrefix;
        this.baseName = inBaseName;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getPrefix` returns the prefix of the Gear.
     * @param    None
     * @returns  (String) adjective describing the Gear
     * ----------------------------------------------------------------------------*/
    @Override
    public String getPrefix() { return this.prefix; }

    /* -----------------------------------------------------------------------------
     * Method   `getBaseName` returns the base name of the Gear.
     * @param    None
     * @returns  (String) the name of the Gear, without its prefix
     * ----------------------------------------------------------------------------*/
    @Override
    public String getBaseName() { return this.baseName; }

    /* -----------------------------------------------------------------------------
     * Method   `getAttackStat` returns the attack stat of the Gear.
     * @param    None
     * @returns  (int) the attack strength provided by the Gear when used in combat
     * ----------------------------------------------------------------------------*/
    @Override
    public int getAttackStat() { return this.attackStat; }

    /* -----------------------------------------------------------------------------
     * Method   `getDefenseStat` returns the defense stat of the Gear.
     * @param    None
     * @returns  (int) the defense strength provided by the Gear when used in combat
     * ----------------------------------------------------------------------------*/
    @Override
    public int getDefenseStat() { return this.defenseStat; }

    /* -----------------------------------------------------------------------------
     * Method   `setPrefix` replaces the Gear's prefix with a new adjective.
     * @param    (String) new prefix for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setPrefix(String inPrefix) { this.prefix = inPrefix; }

    /* -----------------------------------------------------------------------------
     * Method   `setBaseName` replaces the Gear's base name with a new name.
     * @param    (String) new base name for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setBaseName(String inBaseName) { this.baseName = inBaseName; }

    /* -----------------------------------------------------------------------------
     * Method   `setAttackStat` replaces the Gear's attack stat with a new value.
     * @param    (int) new attack value for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    public void setAttackStat(int inAttackStat) {

        if (this instanceof HeadGear) {
            throw new IllegalStateException("HeadGear cannot have a non-zero attack stat.");
        }
        this.attackStat = inAttackStat;
    }

    /* -----------------------------------------------------------------------------
     * Method   `setDefenseStat` replaces the Gear's defense stat with a new value.
     * @param    (int) new defense value for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    public void setDefenseStat(int inDefenseStat) {

        if (this instanceof HandGear) {
            throw new IllegalStateException("HandGear cannot have a non-zero defense stat.");
        }
        this.defenseStat = inDefenseStat; }

    /* -----------------------------------------------------------------------------
     * Method   `combine` creates a new piece of Gear whose stats are the sum of
     *            the stats of the two pieces of Gear to be combined. The `other`
     *            Gear's prefix becomes the prefix of the new Gear and the
     *            full name of `this` Gear (prefix + base name) becomes the base
     *            name of the new Gear.
     * @param    `other`    (Gear)      the piece of Gear to combine with this Gear
     * @returns             (Gear)      the resulting piece of Gear
     * ----------------------------------------------------------------------------*/
    @Override
    public Gear combine(Gear other) {

        Gear combinedGear = combineStats(other);
        combinedGear.setBaseName(this.prefix + " " + this.baseName);
        combinedGear.setPrefix(other.getPrefix());
        return combinedGear;
    }

    /* -----------------------------------------------------------------------------
     * Method   `combineStats` checks whether the two pieces of Gear to be combined
     *            are of the same type. Then, if applicable, a new piece of Gear
     *            is created and returned with the combined stats of the two pieces
     *            of Gear.
     * @param    `other`    (Gear)      the piece of Gear to be combined
     * @returns             (Gear)      the piece of Gear with combined stats
     * ----------------------------------------------------------------------------*/
    protected abstract Gear combineStats(Gear other);

    /* -----------------------------------------------------------------------------
     * Method   `compareTo` determines whether a piece of Gear is greater than,
     *            less than, or equal in strength with another piece of Gear.
     *            Relative strength is determined first by comparing the attack stat,
     *            and if those are equal, by comparing the defense stat.
     * @param    `other`    (Gear)      the piece of Gear to be compared to
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public int compareTo(Gear other) {

        if (this.attackStat > other.getAttackStat()) {
            return 1;
        }
        else if (this.attackStat < other.getAttackStat()) {
            return -1;
        }
        else { // if (this.attackStat == other.getAttackStat())
            return Integer.compare(this.defenseStat, other.getDefenseStat());
        }
    }

    /* -----------------------------------------------------------------------------
     * Method   `equals` returns true if all attributes of two AbstractGear match,
     *            and false if they do not match.
     * @param    None
     * @returns  (boolean) true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }

        if (!(obj instanceof AbstractGear)) {
            throw new IllegalArgumentException("Argument must be an instance " +
                    "of the AbstractGear class hierarchy.");
        }

        AbstractGear other = (AbstractGear) obj;
        return (Objects.equals(this.prefix, other.prefix)) &&
                (Objects.equals(this.baseName, other.baseName)) &&
                (this.attackStat == other.attackStat) &&
                (this.defenseStat == other.defenseStat);
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the full name and stat values of the Gear.
     * @param    None
     * @returns  (String) the full name and stats of the Gear
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return prefix + " " + baseName;
    }

} /* ****************************************************************************** */
