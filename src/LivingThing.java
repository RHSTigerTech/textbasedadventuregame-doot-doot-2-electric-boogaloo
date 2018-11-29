public class LivingThing extends NamedThing {
    private int health;
    private int strength;
    private int defense;

    public LivingThing(String name, String description, int health, int strength, int defense) {
        super(name, description);
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
