public class Enemy extends LivingThing {
    private String dialog;

    /**
     * Main constructor of Enemy
     * @param name Name of the enemy.
     * @param description Description of the enemy.
     * @param health Health points
     * @param strength Attack power
     * @param defense Ability to resist attacks
     * @param dialog A set speech from the enemy.
     */
    public Enemy(String name, String description, int health, int strength, int defense, String dialog) {
        super(name, description, health, strength, defense);
        this.dialog = dialog;
    }

    /**
     * Getter method for dialog
     * @return The dialog string
     */
    public String getDialog() {
        return dialog;
    }

    /**
     * Setter method for dialog
     * @param dialog The current dialog string
     */
    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
