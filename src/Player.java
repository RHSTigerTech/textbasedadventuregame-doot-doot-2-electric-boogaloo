public class Player extends LivingThing {
    private Items[] inventory;

    public Player(String name, String description, int health, int strength, int defense) {
        super(name, description, health, strength, defense);
    }

    public Items[] getInventory() {
        return inventory;
    }

    public void setInventory(Items[] inventory) {
        this.inventory = inventory;
    }
}
