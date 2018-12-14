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
    private boolean winCon;
    private boolean defeatedSkeleton;
    private boolean hasKey;
    private int addedDamage;

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
        winCon = false;
        defeatedSkeleton = false;
        hasKey = false;
        addedDamage = 0;
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

    /**
     * Getter method for boardsGone
     * @return Are the boards gone?
     */
    public boolean isBoardsGone() {
        return boardsGone;
    }

    /**
     * Getter method for hasCrowbar
     * @return Does the Player have the crowbar?
     */
    public boolean isHasCrowbar() {
        return hasCrowbar;
    }

    /**
     * Setter method for boardsGone
     * @param boardsGone The new state of the boards
     */
    public void setBoardsGone(boolean boardsGone) {
        this.boardsGone = boardsGone;
    }

    /**
     * Setter method for hasCrowbar
     * @param hasCrowbar The new state of the crowbar
     */
    public void setHasCrowbar(boolean hasCrowbar) {
        this.hasCrowbar = hasCrowbar;
    }

    /**
     * Getter method for activatedLever
     * @return Is the lever activated?
     */
    public boolean isActivatedLever() {
        return activatedLever;
    }

    /**
     * Setter method for activatedLever
     * @param activatedLever The new state of the lever
     */
    public void setActivatedLever(boolean activatedLever) {
        this.activatedLever = activatedLever;
    }

    /**
     * Getter method for hasScrewdriver
     * @return Does the player have the screwdriver?
     */
    public boolean isHasScrewdriver() {
        return hasScrewdriver;
    }

    /**
     * Setter method for screwdriver
     * @param hasScrewdriver The new state of the screwdriver
     */
    public void setHasScrewdriver(boolean hasScrewdriver) {
        this.hasScrewdriver = hasScrewdriver;
    }

    /**
     * Getter method for hasBoard
     * @return Does the player have the board?
     */
    public boolean isHasBoard() {
        return hasBoard;
    }

    /**
     * Setter method for hasBoard
     * @param hasBoard The new state of the board
     */
    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }

    /**
     * Getter method for crossable
     * @return The current state of crossable
     */
    public boolean isCrossable() {
        return crossable;
    }

    /**
     * Setter method for the crossable
     * @param crossable The new state of crossable
     */
    public void setCrossable(boolean crossable) {
        this.crossable = crossable;
    }

    /**
     * Getter method for win condition
     * @return Is the win condition met?
     */
    public boolean isWinCon() {
        return winCon;
    }

    /**
     * Setter method for win condition
     * @param winCon The new state of winCon
     */
    public void setWinCon(boolean winCon) {
        this.winCon = winCon;
    }

    /**
     * Getter method for the skeleton's state
     * @return Is the skeleton defeated?
     */
    public boolean isDefeatedSkeleton() {
        return defeatedSkeleton;
    }

    /**
     * Setter method for the skeleton's state
     * @param defeatedSkeleton The new state of the player defeating skeleton
     */
    public void setDefeatedSkeleton(boolean defeatedSkeleton) {
        this.defeatedSkeleton = defeatedSkeleton;
    }

    /**
     * Getter method for additive damage
     * @return The added damage received
     */
    public int getAddedDamage() {
        return addedDamage;
    }

    /**
     * Getter method for the player having the key
     * @return Does the player have a key?
     */
    public boolean isHasKey() {
        return hasKey;
    }

    /**
     * Setter method for the player having the key
     * @param hasKey The new state of the player's key
     */
    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    /**
     * Setter method for added damage
     * @param addedDamage New added damage received
     */
    public void setAddedDamage(int addedDamage) {
        this.addedDamage = addedDamage;
    }
}
