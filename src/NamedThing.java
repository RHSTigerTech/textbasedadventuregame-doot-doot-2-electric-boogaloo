public class NamedThing {
    private String name;
    private String description;

    /**
     * Main constructor of the named thing
     * @param name Name of the named thing
     * @param description Description of the named thing
     */
    public NamedThing(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Getter method for name
     * @return The current name of the named thing
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name
     * @param name New name of the named thing
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for description
     * @return The current description of the named thing
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description
     * @param description New description of the named thing
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
