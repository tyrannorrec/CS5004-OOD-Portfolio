package birds.attributes;


/* ******************************************************************************
 * Enum       BirdType
 * Purpose    Contains as constant values the types or subcategories of Birds
 *            as defined within the concrete child classes of AbstractBird
 *            (BirdOfPrey, FlightlessBird, etc.) Types are organized below by
 *            these classes. Each type also includes three fields:
 *
 * @field     printableNames    --    (String)  the name of the bird type
 * @field     isExtinct         --    (boolean) whether the type is extinct
 * @field     typeDescription   --    (String)  a brief description of the type
 * ***************************************************************************** */
public enum BirdType {

    // Note: All type descriptions are taken and paraphrased from britannica.com //
    //       and Wikipedia.org.                                                  //

    /* -----------------------------------------------------------------------------
     * Classes Without Types
     * ----------------------------------------------------------------------------*/
    OWL("Owl", false,
            """
                    Owls are nocturnal, crepuscular, or diurnal birds, distinguished\s
                    by the facial disks that frame the eyes and bill. They live in\s
                    virtually all habitats, and hunt by sustained flight."""),

    PARROT("Parrot", false,
            """
                    Parrots have a short, curved beak and are known for their intelligence\s
                    and ability to mimic sounds. Many pet parrots can learn a vocabulary\s
                    of up to 100 words and often adopt a single "favorite" saying."""),

    PIGEON("Pigeon", false,
            """
                    Pigeons (or Doves) are known for feeding their young "bird milk",\s
                    very similar to the milk of mammals. Pigeons are gentle, plump, small-\s
                    billed birds that strut about with a characteristic bobbing of the head.
                    """),

    /* -----------------------------------------------------------------------------
     * BirdOfPrey Types
     * ----------------------------------------------------------------------------*/
    HAWK("Hawk", false,
            """
                    Hawks are small to medium sized Birds of Prey with powerful talons\s
                    and a strong pointed beak that it uses to catch and kill prey.\s
                    These birds tend to eat small mammals, reptiles, and insects."""),
    EAGLE("Eagle", false,
            """
                    Eagles are a Bird of Prey with a fully feathered head and great\s
                    curved talons they use to capture and decapitate live prey. Eagles\s
                    are monogamous who are known to mate for life."""),
    OSPREY("Osprey", false,
            """
                    Ospreys are large, long-winged hawks that rely on a diet of fish,\s
                    flying over the water to hunt They live along seacoasts and larger\s
                    interior waterways."""),

    /* -----------------------------------------------------------------------------
     * FlightlessBird Types
     * ----------------------------------------------------------------------------*/
    EMU("Emu", false,
            """
                    A Flightless Bird, the Emu is the second largest living bird, easily\s
                    standing more than 5 feet tall. They are brownish, with a stout body\s
                    and long legs that can propel them at 30 miles an hour."""),
    KIWI("Kiwi", false,
            """
                    Kiwis are a Flightless Bird native to New Zealand. They have vestigial\s
                    wings hidden within their plumage, and stout, muscular legs. Dwelling\s
                    in forests, kiwis sleep by day and forage for insects at night."""),
    MOA("Moa", true,
            """
                    Moa are an extinct Flightless Bird that stood as tall as 10 feet. Related\s
                    to the Ostrich, they were swift runners that defended themselves by kicking\s
                    with their long legs when cornered."""),

    /* -----------------------------------------------------------------------------
     * Shorebird Types
     * ----------------------------------------------------------------------------*/
    GREAT_AUK("Great Auk", true,
            """
                    The Great Auk is an extinct seabird. They had a black bill and small wings\s
                    that they used for swimming underwater. They bred in colonies on rocky\s
                    islands off North Atlantic coasts."""),

    HORNED_PUFFIN("Horned Puffin", false,
            """
                    Also called Bottlenose or Sea Parrot, the Horned Puffin is a diving\s
                    bird that are distinguished by their large, brightly colored, triangular\s
                    beaks. Puffins nest in large colonies on seaside and island cliffs."""),
    AFRICAN_JACANA("African Jacana", false,
            """
                    African Jacanas are identifiable by long toes and long claws that enable\s
                    them to walk on floating vegetation in shallow lakes. This particular\s
                    species is found in sub-Saharan Africa."""),

    /* -----------------------------------------------------------------------------
     * Waterfowl Types
     * ----------------------------------------------------------------------------*/
    DUCK("Duck", false,
            """
                    Ducks are any of various species of small, short-necked, large-billed\s
                    Waterfowl. They have rearward pointing legs, which results in their distinctive\s
                    waddling gait. Ducks mature in the first year and pair only for the season."""),
    SWAN("Swan", false,
            """
                    Swans are the largest Waterfowl species. They are gracefully long-necked,\s
                    heavy-bodied, big-footed birds that glide majestically when swimming and fly\s
                    with slow wingbeats and with necks outstretched."""),
    GOOSE("Goose", false,
            """
                    Geese are medium-sized Waterfowl associated mainly with fresh water and\s
                    living in the Northern Hemisphere. Their neck is always shorter than the\s
                    body, and they have longer legs that allow them to walk readily.""");

    /* -----------------------------------------------------------------------------
     * BirdType Enum Fields
     * ----------------------------------------------------------------------------*/
    private final String printableName;
    private final boolean isExtinct;
    private final String typeDescription;

    /* -----------------------------------------------------------------------------
     * Enum Constructor (implicitly private)
     * ----------------------------------------------------------------------------*/
    BirdType(String printableName, boolean isExtinct, String typeDescription) {
        this.printableName = printableName;
        this.isExtinct = isExtinct;
        this.typeDescription = typeDescription;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getIsExtinct` returns the bool associated with the isExtinct field.
     * @param    None
     * @returns  (boolean) true if the Bird type is extinct; false if not extinct
     * ----------------------------------------------------------------------------*/
    public boolean getIsExtinct() {
        return isExtinct;
    }

    /* -----------------------------------------------------------------------------
     * Method   `getTypeDescription` returns the String associated with the
     *               typeDescription field.
     * @param    None
     * @returns  (String) a short description of the bird type
     * ----------------------------------------------------------------------------*/

    public String getTypeDescription() {
        return typeDescription;
    }

    /* -----------------------------------------------------------------------------
     * Method   `toString` returns the String value contained in 'printableName'
     * @param    None
     * @returns  (String) the name of the bird type
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return printableName;
    }

} /* ****************************************************************************** */
