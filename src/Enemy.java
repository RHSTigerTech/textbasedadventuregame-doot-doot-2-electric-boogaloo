public class Enemy extends LivingThing {
    private String[] dialog;

    public Enemy(String name, String description, int health, int strength, int defense, String[] dialog) {
        super(name, description, health, strength, defense);
        this.dialog = dialog;
    }

    public String[] getDialog() {
        return dialog;
    }

    public void setDialog(String[] dialog) {
        this.dialog = dialog;
    }
}
