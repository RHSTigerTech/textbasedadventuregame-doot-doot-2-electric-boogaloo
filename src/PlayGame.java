import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Room[][] ground = new Room[2][3];
        Room[][] cabin = new Room[3][3];

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
    }
}