public class Items extends NamedThing {
    private Room location;

    public Items(String name, String descripion, Room location) {
        super(name, descripion);
        this.location = location;
    }
}
