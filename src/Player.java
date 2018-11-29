public class Player extends NamedThing {
    private int health;
    private int strength;
    private int defense;

    public Player(int health, int strength, int defense) {
        super("Player", "This is you.");
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
