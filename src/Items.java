public class Items extends NamedThing {
    private Room location;

    /**
     * Main constructor of Items
     * @param name The name of the item.
     * @param description The description of the item.
     * @param location Where the item is on the map.
     */
    public Items(String name, String description, Room location) {
        super(name, description);
        this.location = location;
    }

    /**
     * Getter method for location
     * @return The current location of the item.
     */
    public Room getLocation() {
        return location;
    }

    /**
     * Setter method for location
     * @param location The new location of the item.
     */
    public void setLocation(Room location) {
        this.location = location;
    }
}
