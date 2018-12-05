import java.util.Scanner;

public class PlayGame {

    /**
     * Main method of the package
     * @param args This param that every main method has
     */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("What is your name? ");
        String answer = console.nextLine();
        Player player1 = new Player(answer, "Player",10,5,5);

        Room[][] ground = new Room[2][3];
        Room[][] cabin = new Room[3][3];


        ground[0][0] = new Room("Old Quarters", "What once was your living quarters is now a trashed and broken room with claw marks on your bed and wall. There " +
                "\nappears to be a loose board on the wall.");
        ground[0][1] = new Room("Airlock Room", "You are in a small room with an airlock however a key " +
                "\ncomponet seems to be missing from the activation panel. It looks as if a small creature must have" +
                "\n fiddled with it.");

        boolean winCon = false;

        while (!winCon) {
            System.out.println("You are in a spaceship. " +
                    "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                    " \nYou are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship. Use /help for a list of commands");
            command();

            winCon = true;
        }
        System.out.println("You win!");
    }

    /**
     * Command method for the user input
     */
    public static void command() {
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("/help")) {
            System.out.println("\nCommands:" +
                    "\n/help: displays a list of commands" +
                    "\n/move (WEST,NORTH,EAST,SOUTH): move in a direction" +
                    "\n/look: provides a description of your current room" +
                    "\n/pickup: prompts you if you would like to pickup any nearby objects" +
                    "\n/activate: prompts you if you would like to activate any nearby objects");
        }

        if (answer.equalsIgnoreCase("/look")) {
            Room[player1.getRoomRow()][getRoomcolumn()].getDescription;

        }

        if (answer.equalsIgnoreCase("/pickup")) {

        }

        if (answer.equalsIgnoreCase("/activate")) {

        }
    }
}