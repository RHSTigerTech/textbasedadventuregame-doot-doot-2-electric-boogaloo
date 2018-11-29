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
}
