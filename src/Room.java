public class Room extends NamedThing {
    private boolean restrictionNorth;
    private boolean restrictionEast;
    private boolean restrictionSouth;
    private boolean restrictionWest;
    private String activatableDescription;
    private String pickupDescription;

    /**
     * Main constructor of Room
     * @param name The name of the room.
     * @param description The description of the room.
     */
    public Room(String name, String description) {
        super(name, description);
    }

    /**
     * Overloaded constructor of Room
     * @param name The name of the room.
     * @param description The description of the room.
     * @param restrictionNorth The northern border of the room.
     * @param restrictionEast The eastern border of the room.
     * @param restrictionSouth The southern border of the room.
     * @param restrictionWest The western border of the room.
     * @param activatableDescription The description of the room's activatable element.
     */
    public Room(String name, String description, boolean restrictionNorth, boolean restrictionEast, boolean restrictionSouth, boolean restrictionWest, String activatableDescription, String pickupDescription) {
        super(name, description);
        this.restrictionNorth = restrictionNorth;
        this.restrictionEast = restrictionEast;
        this.restrictionSouth = restrictionSouth;
        this.restrictionWest = restrictionWest;
        this.activatableDescription = activatableDescription;
        this.pickupDescription = pickupDescription;
    }

    /**
     * Getter method for the room's western border.
     * @return The western border of the room.
     */
    public boolean isRestrictionWest() {
        return restrictionWest;
    }

    /**
     * Getter method for the room's northern border.
     * @return The northern border of the room.
     */
    public boolean isRestrictionNorth() {
        return restrictionNorth;
    }

    /**
     * Getter method for the room's eastern border.
     * @return The eastern border of the room.
     */
    public boolean isRestrictionEast() {
        return restrictionEast;
    }

    /**
     * Getter method for the room's southern border.
     * @return The southern border of the room.
     */
    public boolean isRestrictionSouth() {
        return restrictionSouth;
    }

    /**
     * Getter method for the room's activatable
     * @return The current activatable description
     */
    public String getActivatableDescription() {
        return activatableDescription;
    }

    /**
     * Setter method for the room's northern border
     * @param restrictionNorth The new northern border of the room
     */
    public void setRestrictionNorth(boolean restrictionNorth) {
        this.restrictionNorth = restrictionNorth;
    }

    /**
     * Setter method for the room's eastern border
     * @param restrictionEast The new eastern border of the room
     */
    public void setRestrictionEast(boolean restrictionEast) {
        this.restrictionEast = restrictionEast;
    }

    /**
     * Setter method for the room's southern border
     * @param restrictionSouth The new southern border of the room
     */
    public void setRestrictionSouth(boolean restrictionSouth) {
        this.restrictionSouth = restrictionSouth;
    }

    /**
     * Setter method for the room's western border
     * @param restrictionWest The new western border of the room
     */
    public void setRestrictionWest(boolean restrictionWest) {
        this.restrictionWest = restrictionWest;
    }

    /**
     * Setter method for the activatable's description
     * @param activatableDescription The new description of the activatable
     */
    public void setActivatableDescription(String activatableDescription) {
        this.activatableDescription = activatableDescription;
    }

    /**
     * Getter method for the pickup description
     * @return The pickup description
     */
    public String getPickupDescription() {
        return pickupDescription;
    }

    /**
     * Setter method for the pickup item's description
     * @param pickupDescription The new description of the pickup
     */
    public void setPickupDescription(String pickupDescription) {
        this.pickupDescription = pickupDescription;
    }
}

