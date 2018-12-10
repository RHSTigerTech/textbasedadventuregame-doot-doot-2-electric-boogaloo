public class Items extends NamedThing {
    //private Room location;

    /**
     * Main constructor of Items
     * @param name The name of the item.
     * @param description The description of the item.
     */
    public Items(String name, String description) {
        super(name, description);
    }

    /**
     * Returns Item's properties on a readable format.
     * @return The name of the item.
     */
    public String toString(){
        return getName();
    }
}
