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
                "\nappears to be a loose board on the wall.", true, false,false,true);
        ground[0][1] = new Room("Airlock Room", "You are in a small room with an airlock however a key " +
                "\ncomponet seems to be missing from the activation panel. It looks as if a small creature must have" +
                "\nfiddled with it.",true,false,true,false);
        ground[0][2] = new Room("Control Room", "There is a screwdriver lying around in the corner and a lever that has been" +
                "\nhastily boarded up with spare planks and panels.",true,true,true,false);
        ground[1][0] = new Room("Cabin Entrance","A shut trap door lays at your feet. You can't seem to open it.",false,false,true,true);
        ground[1][1] = new Room("The Bridge", "A large gap stands in your way. You could have sworn there WAS a bridge here.",true,false,true,false);
        ground[1][2] = new Room("Maintenance Closet", "A ravaged room where the crew's supplies used to be." +
                "\nSupposedly the imps never deemed the spare crowbar important.",true,true,true,false);


        boolean winCon = false;
        System.out.println("You are in a spaceship. " +
                "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                " \nYou are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship. Use /help for a list of commands");

        while (!winCon) {

            command(ground,cabin,player1);

            //winCon = true;
        }
        System.out.println("You win!");
    }

    /**
     * Command method for the user input
     */
    public static void command(Room[][] ground, Room[][] cabin, Player player1) {
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("/help")) {
            System.out.println("\nCommands:" +
                    "\n/help: displays a list of commands" +
                    "\n/move (NORTH,EAST,SOUTH,WEST): move in a direction" +
                    "\n/look: provides a description of your current room" +
                    "\n/pickup: prompts you if you would like to pickup any nearby objects" +
                    "\n/activate: prompts you if you would like to activate any nearby objects");
        }

        else if (answer.equalsIgnoreCase("/look")) {
            System.out.println(ground[player1.getRoomRow()][player1.getRoomColumn()].getName());
            System.out.println(ground[player1.getRoomRow()][player1.getRoomColumn()].getDescription());
            System.out.println();
            printGroundMap(player1);
        }

        else if (answer.equalsIgnoreCase("/pickup")) {
            System.out.println(player1);
        }

        else if (answer.equalsIgnoreCase("/activate")) {
            System.out.println("Test");
        }

        else if (answer.equalsIgnoreCase("/move west")){
            if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionWest())
                System.out.println("You try to get through the solid wall but alas... you fail miserably.");
            else {
                player1.setRoomColumn(player1.getRoomColumn() - 1);
                printGroundMap(player1);
            }
        }

        else if (answer.equalsIgnoreCase("/move east")){
            if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionEast())
                System.out.println("You try to get through the solid wall but alas... you fail miserably.");
            else {
                player1.setRoomColumn(player1.getRoomColumn() + 1);
                printGroundMap(player1);
            }
        }
        else if (answer.equalsIgnoreCase("/move north")){
            if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionNorth())
                System.out.println("You try to get through the solid wall but alas... you fail miserably.");
            else {
                player1.setRoomRow(player1.getRoomRow() - 1);
                printGroundMap(player1);
            }
        }
        else if (answer.equalsIgnoreCase("/move south")){
            if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionSouth())
                System.out.println("You try to get through the solid wall but alas... you fail miserably.");
            else {
                player1.setRoomRow(player1.getRoomRow() + 1);
                printGroundMap(player1);
            }
        }
        else if (answer.equalsIgnoreCase("/escape")){
            System.out.println("Try again wise guy.");
        }
        else{
            System.out.println("Oak's words echoed... There's a time and place for everything, but not now." +
                    "\nThis is strange because you don't know a Professor Oak but his warning probably means something important anyway.");
        }
    }

    public static void printGroundMap(Player player1){

        String a = " ";
        String b = " ";
        String c = " ";
        String d = " ";
        String e = " ";
        String f = " ";


        if (player1.getRoomRow()==0 && player1.getRoomColumn()==0){
            a="@";
        }
        else if (player1.getRoomRow()==0 && player1.getRoomColumn()==1){
            b="@";
        }
        else if (player1.getRoomRow()==0 && player1.getRoomColumn()==2){
            c="@";
        }
        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==0){
            d="@";
        }
        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==1){
            e="@";
        }
        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==2){
            f="@";
        }


        System.out.println(
                "-------------" +
                "\n| "+a+" | "+b+" | "+c+" |" +
                "\n-----xxx-xxx-" +
                "\n| "+d+" | "+e+" | "+f+" |" +
                "\n-------------");
    }

}