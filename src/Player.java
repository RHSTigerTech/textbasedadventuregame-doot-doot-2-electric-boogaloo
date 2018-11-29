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

    @Override
    public String toString() {
        return "Health: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nDefense: " + getDefense() +
                "\nINVENTORY 1" + inventory[0] +
                "\nINVENTORY 2" + inventory[1] +
                "\nINVENTORY 3" + inventory[2] +
                "\nINVENTORY 4" + inventory[3] +
                "\nINVENTORY 5" + inventory[4];
    }
}
