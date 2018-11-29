public class PlayGame {
    public static void main(String [] args) {
        Room[][] ground = new Room[2][3];
        Room[][] cabin = new Room[3][3];

        boolean winCon = false;

        while (!winCon) {

            System.out.println("You are in a spaceship. " +
                    "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                    " You are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship. Use /help for a list of commands");



            winCon = true;
        }
        System.out.println("You win!");
    }
}
