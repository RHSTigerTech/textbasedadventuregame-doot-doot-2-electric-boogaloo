public class Room extends NamedThing {

    /**
     * Main constructor of Room
     * @param name The name of the room.
     * @param description The description of the room.
     */
    private boolean restrictionNorth;
    private boolean restrictionEast;
    private boolean restrictionSouth;
    private boolean restrictionWest;

    public Room(String name, String description) {
        super(name, description);
    }

    public Room(String name, String description, boolean restrictionNorth, boolean restrictionEast, boolean restrictionSouth, boolean restrictionWest) {
        super(name, description);
        this.restrictionNorth = restrictionNorth;
        this.restrictionEast = restrictionEast;
        this.restrictionSouth = restrictionSouth;
        this.restrictionWest = restrictionWest;
    }

    public boolean isRestrictionWest() {
        return restrictionWest;
    }

    public boolean isRestrictionNorth() {
        return restrictionNorth;
    }

    public boolean isRestrictionEast() {
        return restrictionEast;
    }

    public boolean isRestrictionSouth() {
        return restrictionSouth;
    }
}
