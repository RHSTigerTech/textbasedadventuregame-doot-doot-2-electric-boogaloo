public class LivingThing extends NamedThing {
    private int health;
    private int strength;
    private int defense;

    /**
     * Main constructor of LivingThing.
     * @param name Name of the living thing
     * @param description Description of the living thing
     * @param health Health points
     * @param strength Attack power
     * @param defense Ability to resist attacks
     */
    public LivingThing(String name, String description, int health, int strength, int defense) {
        super(name, description);
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    }

    /**
     * Getter method for health
     * @return Current health of the living thing
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter method for health
     * @param health New health of the living thing
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter method for strength
     * @return Current strength of the living thing
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Setter method for strength
     * @param strength New strength of the living thing
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Getter method for defense
     * @return Current defesne of the living thing
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Setter method for defense
     * @param defense New defense of the living thing
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}
