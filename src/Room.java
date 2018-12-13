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

    public void setRestrictionNorth(boolean restrictionNorth) {
        this.restrictionNorth = restrictionNorth;
    }

    public void setRestrictionEast(boolean restrictionEast) {
        this.restrictionEast = restrictionEast;
    }

    public void setRestrictionSouth(boolean restrictionSouth) {
        this.restrictionSouth = restrictionSouth;
    }

    public void setRestrictionWest(boolean restrictionWest) {
        this.restrictionWest = restrictionWest;
    }

    public void setActivatableDescription(String activatableDescription) {
        this.activatableDescription = activatableDescription;
    }

    public String getPickupDescription() {
        return pickupDescription;
    }

    public void setPickupDescription(String pickupDescription) {
        this.pickupDescription = pickupDescription;
    }
}

