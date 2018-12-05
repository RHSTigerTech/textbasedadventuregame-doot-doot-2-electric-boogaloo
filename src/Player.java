public class Player extends LivingThing {
    private Items[] inventory;
    private int roomRow;
    private int roomColumn;

    /**
     * Main constructor of Player.
     * @param name Name of the player.
     * @param description Description of the player.
     * @param health Health points
     * @param strength Attack power
     * @param defense Ability to resist attacks
     */
    public Player(String name, String description, int health, int strength, int defense) {
        super(name, description, health, strength, defense);
        roomRow = 0;
        roomColumn = 1;
    }

    /**
     * Getter method for the inventory list
     * @return The current inventory array
     */
    public Items[] getInventory() {
        return inventory;
    }

    /**
     * Setter method for the inventory list
     * @param inventory The current inventory array
     */
    public void setInventory(Items[] inventory) {
        this.inventory = inventory;
    }

    /**
     * toString() method for Player
     * @return A formatted string of Player's properties.
     */
    @Override
    public String toString() {
        return "Health: " + getHealth() +
                "\nStrength: " + getStrength() +
                "\nDefense: " + getDefense() +
                "\nINVENTORY 1: " + inventory[0] +
                "\nINVENTORY 2: " + inventory[1] +
                "\nINVENTORY 3: " + inventory[2] +
                "\nINVENTORY 4: " + inventory[3] +
                "\nINVENTORY 5: " + inventory[4];
    }

    public int getRoomRow() {
        return roomRow;
    }

    public int getRoomColumn() {
        return roomColumn;
    }

    public void setRoomRow(int roomRow) {
        this.roomRow = roomRow;
    }

    public void setRoomColumn(int roomColumn) {
        this.roomColumn = roomColumn;
    }
}
