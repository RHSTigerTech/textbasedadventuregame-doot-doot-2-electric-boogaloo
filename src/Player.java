public class Player extends LivingThing {
    private Items[] inventory;
    private int roomRow;
    private int roomColumn;
    private int floor;
    private boolean boardsGone;
    private boolean hasCrowbar;
    private boolean activatedLever;
    private boolean hasScrewdriver;
    private boolean hasBoard;
    private boolean crossable;

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
        floor = 0;
        boardsGone = false;
        hasCrowbar = false;
        activatedLever = false;
        hasScrewdriver = false;
        hasBoard = false;
        crossable = false;
        inventory = new Items[4];
        inventory[0] = new Items("NOTHING", "STILL NOTHING");
        inventory[1] = new Items("NOTHING", "STILL NOTHING");
        inventory[2] = new Items("NOTHING", "STILL NOTHING");
        inventory[3] = new Items("NOTHING", "STILL NOTHING");
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
        for (int i = 0; i < 4; i++){
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
                "\nINVENTORY 1: " + inventory[0].toString() +
                "\nINVENTORY 2: " + inventory[1].toString() +
                "\nINVENTORY 3: " + inventory[2].toString() +
                "\nINVENTORY 4: " + inventory[3].toString();
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

    /**
     * Getter method for the player's level state
     * @return The state of the player's location. (Ground or cabin)
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Setter method for the player's level state
     * @param floor The new state of the player's location.
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isBoardsGone() {
        return boardsGone;
    }

    public boolean isHasCrowbar() {
        return hasCrowbar;
    }

    public void setBoardsGone(boolean boardsGone) {
        this.boardsGone = boardsGone;
    }

    public void setHasCrowbar(boolean hasCrowbar) {
        this.hasCrowbar = hasCrowbar;
    }

    public boolean isActivatedLever() {
        return activatedLever;
    }

    public void setActivatedLever(boolean activatedLever) {
        this.activatedLever = activatedLever;
    }

    public boolean isHasScrewdriver() {
        return hasScrewdriver;
    }

    public void setHasScrewdriver(boolean hasScrewdriver) {
        this.hasScrewdriver = hasScrewdriver;
    }

    public boolean isHasBoard() {
        return hasBoard;
    }

    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }

    public boolean isCrossable() {
        return crossable;
    }

    public void setCrossable(boolean crossable) {
        this.crossable = crossable;
    }
}
