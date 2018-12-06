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
        inventory = new Items[5];
        inventory[0] = new Items("NOTHING", "STILL NOTHING");
        inventory[1] = new Items("NOTHING", "STILL NOTHING");
        inventory[2] = new Items("NOTHING", "STILL NOTHING");
        inventory[3] = new Items("NOTHING", "STILL NOTHING");
        inventory[4] = new Items("NOTHING", "STILL NOTHING");
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
     * @param item The current inventory array
     */
    public void setInventory(Items item) {
        for (int i = 0; i < 5; i++){
            if (item.getName().equals("NOTHING"))
                inventory[i] = item;
        }

    }

    /**
     * toString() method for Player
     * @return A formatted string of Player's properties.
     */
    @Override
    public String toString() {
        return "Health: " + super.getHealth() +
                "\nStrength: " + super.getStrength() +
                "\nDefense: " + super.getDefense() +
                "\nINVENTORY 1: " + inventory[0] +
                "\nINVENTORY 2: " + inventory[1] +
                "\nINVENTORY 3: " + inventory[2] +
                "\nINVENTORY 4: " + inventory[3] +
                "\nINVENTORY 5: " + inventory[4];
    }

    /**
     * Getter method for roomRow
     * @return The current roomRow
     */
    public int getRoomRow() {
        return roomRow;
    }

    /**
     * Getter method for roomColumn
     * @return The current roomColumn
     */
    public int getRoomColumn() {
        return roomColumn;
    }

    /**
     * Setter method for roomRow
     * @param roomRow The new roomRow of the player
     */
    public void setRoomRow(int roomRow) {
        this.roomRow = roomRow;
    }

    /**
     * Setter method for roomColumn
     * @param roomColumn The new roomColumn of the player
     */
    public void setRoomColumn(int roomColumn) {
        this.roomColumn = roomColumn;
    }


}
