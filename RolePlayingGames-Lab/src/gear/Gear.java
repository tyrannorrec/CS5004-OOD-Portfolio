package gear;

/* ******************************************************************************
 * Interface  Gear
 * Purpose    The Gear interface models the methods available to any class
 *            depicting a piece of Gear. These methods include getters and
 *            setters for the prefix and base name of the Gear, as well as
 *            its attack and defense stats. Two pieces of Gear can have their
 *            names and stats be fused via the `combine()` method; The Gear
 *            interface extends the Comparable interface. It is implemented
 *            by the AbstractGear class, which in turn is extended by three
 *            concrete classes of Gear: HeadGear, HandGear, and Footwear.
 * ***************************************************************************** */
public interface Gear extends Comparable<Gear> {

    /* -----------------------------------------------------------------------------
     * Method   `getPrefix` returns the prefix of the Gear.
     * @param    None
     * @returns  (String) adjective describing the Gear
     * ----------------------------------------------------------------------------*/
    String getPrefix();

    /* -----------------------------------------------------------------------------
     * Method   `getBaseName` returns the base name of the Gear.
     * @param    None
     * @returns  (String) the name of the Gear, without its prefix
     * ----------------------------------------------------------------------------*/
    String getBaseName();

    /* -----------------------------------------------------------------------------
     * Method   `getAttackStat` returns the attack stat of the Gear.
     * @param    None
     * @returns  (int) the attack strength provided by the Gear when used in combat
     * ----------------------------------------------------------------------------*/
    int getAttackStat();

    /* -----------------------------------------------------------------------------
     * Method   `getDefenseStat` returns the defense stat of the Gear.
     * @param    None
     * @returns  (int) the defense strength provided by the Gear when used in combat
     * ----------------------------------------------------------------------------*/
    int getDefenseStat();

    /* -----------------------------------------------------------------------------
     * Method   `setPrefix` replaces the Gear's prefix with a new adjective.
     * @param    (String) new prefix for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setPrefix(String inPrefix);

    /* -----------------------------------------------------------------------------
     * Method   `setBaseName` replaces the Gear's base name with a new name.
     * @param    (String) new base name for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setBaseName(String inBaseName);

    /* -----------------------------------------------------------------------------
     * Method   `setAttackStat` replaces the Gear's attack stat with a new value.
     * @param    (int) new attack value for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setAttackStat(int inAttackStat);

    /* -----------------------------------------------------------------------------
     * Method   `setDefenseStat` replaces the Gear's defense stat with a new value.
     * @param    (int) new defense value for the Gear
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setDefenseStat(int inDefenseStat);

    /* -----------------------------------------------------------------------------
     * Method   `combine` creates a new piece of Gear whose stats are the sum of
     *            the stats of the two pieces of Gear to be combined. The `other`
     *            Gear's prefix becomes the prefix of the new Gear and the
     *            full name of `this` Gear (prefix + base name) becomes the base
     *            name of the new Gear.
     * @param    `other`    (Gear)      the piece of Gear to combine with this Gear
     * @returns             (Gear)      the resulting piece of Gear
     * ----------------------------------------------------------------------------*/
    Gear combine(Gear other);

    /* -----------------------------------------------------------------------------
     * Method   `compareTo` determines whether a piece of Gear is greater than,
     *            less than, or equal in strength with another piece of Gear.
     *            Relative strength is determined first by comparing the attack stat,
     *            and if those are equal, by comparing the defense stat.
     * @param    `other`    (Gear)      the piece of Gear to be compared to
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    int compareTo(Gear other);

    /* -----------------------------------------------------------------------------
     * Method   `equals` returns true if all attributes of two AbstractGear match,
     *            and false if they do not match.
     * @param    None
     * @returns  (boolean) true or false
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj);

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the full name and stat values of the Gear.
     * @param    None
     * @returns  (String) the full name and stats of the Gear
     * ----------------------------------------------------------------------------*/
    @Override
    String toString();

} /* ****************************************************************************** */
