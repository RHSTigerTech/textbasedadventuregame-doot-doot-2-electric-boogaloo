import java.util.Scanner;

public class PlayGame {

    /**
     * Main method of the package
     * @param args This param that every main method has
     */
    public static void main(String[] args) {
        Items screwdriver = new Items("Screwdriver", "An old screwdriver. It might be useful");
        Items plank = new Items("An Old Plank", "Looks sturdy enough... maybe?");
        Items crowbar = new Items("Rusty Crowbar", "Could be useful.. or harmful.");

        Room[][] ground = new Room[2][3];
        Room[][] cabin = new Room[3][3];

        ground[0][0] = new Room("Old Quarters", "What once was your living quarters is now a trashed and broken room with claw marks on your bed and wall. There " +
                "\nappears to be a loose board on the wall.", true, false,false,true,"BOARD");
        ground[0][1] = new Room("Airlock Room", "You are in a small room with an airlock however a key " +
                "\ncomponet seems to be missing from the activation panel. It looks as if a small creature must have" +
                "\nfiddled with it.",true,false,true,false,"BROKEN KEY PANEL");
        ground[0][2] = new Room("Control Room", "There is a screwdriver lying around in the corner and a lever that has been" +
                "\nhastily boarded up with spare planks and panels.",true,true,true,false, "BOARDS\nLEVER");
        ground[1][0] = new Room("Cabin Entrance","A shut trap door lays at your feet. You can't seem to open it.",false,false,true,true,"TRAPDOOR");
        ground[1][1] = new Room("The Bridge", "A large gap stands in your way. You could have sworn there WAS a bridge here.",true,false,true,false,"GAP");
        ground[1][2] = new Room("Maintenance Closet", "A ravaged room where the crew's supplies used to be." +
                "\nSupposedly the imps never deemed the spare crowbar important.",true,true,true,false,"NOTHING");

        cabin[0][0] = new Room("Trapdoor entrance","A ladder leads back up to the GROUND floor..." +
                "\nWhy would they call the floor above the CABIN the GROUND floor?",true,false,false,true,"LADDER");
        cabin[0][1] = new Room("Security Panel","STATUS: LOCKED. PLEASE ENTER 5 DIGIT CODE.",true,false,false,false,"KEY PANEL");
        cabin[0][2] = new Room("Right Statue Hall","An adjustable statue stands in your way.",true,true,true,false,"LEFT ARM\nHEAD\nRIGHT ARM");
        cabin[1][0] = new Room("Research lab","A lot of strewn notes and novels lay on the floor. \"Space Travel for DUMMIES\", " +
                "\n\"Tips and Tricks for Avoiding Space Imps\", and a torn piece of paper labelled \"Password Reminder\": Does anyone want" +
                "\na piece of pie?",false,false,false,true,"READ PAPER");
        cabin[1][1] = new Room("Janitor Closet","A lone can of boring \"ANTI-SKELE SPRAY\" lays at your feet. Its" +
                "\nmonochrome color could lull any imp to sleep. You almost don't want to take it.",false,true,false,true,"NOTHING");
        cabin[1][2] = new Room("Bathroom","Feces is on the wall, oil on the floor, and your key is in the toilet. You've spent" +
                "\nthe last 40 minutes for imps to mess with you beyond the grave. On second thought, dying here might not be so bad.",true,true,false,true,"FECES");
        cabin[2][0] = new Room("Left Statue Hall","An adjustable statue stands in your way.",false,false,true,true,"LEFT ARM\nHEAD\nRIGHT ARM");
        cabin[2][1] = new Room("Manor Hall","Up on the diner table lays a message. \nIN ORDER FOR YOU TO SOLVE THE RIDDLE OF THE TWO STATUES" +
                "\nYOU MUST MAKE THEM HIT THE DAB LIKE WIZ KHALIFA.",false,false,true,false,"NOTHING");
        cabin[2][2] = new Room("Courtyard","A floating skeleton head looms before you... It looks like you're gonna have a bad time.",false,true,true,false,"HAVE A BAD TIME");

        Scanner console = new Scanner(System.in);
        System.out.println("What is your name? ");
        String answer = console.nextLine();
        Player player1 = new Player(answer, "Player",11,5,5);

        boolean winCon = false;
        System.out.println("You are in a spaceship. " +
                "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                " \nYou are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship.| Use /help for a list of commands");

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
            if (player1.getFloor()==0) {
                System.out.println(ground[player1.getRoomRow()][player1.getRoomColumn()].getName());
                System.out.println(ground[player1.getRoomRow()][player1.getRoomColumn()].getDescription());
                System.out.println();
                printGroundMap(player1);
            }
            else {
                System.out.println(cabin[player1.getRoomRow()][player1.getRoomColumn()].getName());
                System.out.println(cabin[player1.getRoomRow()][player1.getRoomColumn()].getDescription());
                System.out.println();
                printCabinMap(player1);
            }
        }

        else if (answer.equalsIgnoreCase("/pickup")) {
            System.out.println(player1);
        }

        else if (answer.equalsIgnoreCase("/activate")) {
            if (player1.getFloor()==0){
                System.out.println("What would you like to activate: \n" + ground[player1.getRoomRow()][player1.getRoomColumn()].getActivatableDescription());
                if (player1.getRoomRow()==0&&player1.getRoomColumn()==0){
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("board")){
                        activateLooseBoard();
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==1) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("broken key panel")){
                        activateKeyPanel();
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("boards")){
                        activateBoards(player1.isBoardsGone, player1.isHasCrowbar, player1);
                    }
                    else if (answer.equalsIgnoreCase("lever")){
                        activateLever();
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==0) {

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==1) {

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==2) {

                }
                else {
                    System.out.println("something went wrong my dude");
                }
            }
            else{
                System.out.println("What would you like to activate: \n" + cabin[player1.getRoomRow()][player1.getRoomColumn()].getActivatableDescription());
                if (player1.getRoomRow()==0&&player1.getRoomColumn()==0){
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("ladder")){
                        activateLadder();
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==1) {

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==0) {

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==1) {

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==2) {

                }
                else if (player1.getRoomRow()==2&&player1.getRoomColumn()==0) {

                }
                else if (player1.getRoomRow()==2&&player1.getRoomColumn()==1) {

                }
                else if (player1.getRoomRow()==2&&player1.getRoomColumn()==2) {

                }
                else {
                    System.out.println("something went wrong my dude");
                }
            }
        }

        else if (answer.equalsIgnoreCase("/move west")) {
            if (player1.getFloor()==0){
                if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionWest())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomColumn(player1.getRoomColumn() - 1);
                    printGroundMap(player1);
                }
            }
            else if(player1.getFloor()==1) {
                if (cabin[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionWest())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomColumn(player1.getRoomColumn() - 1);
                    printCabinMap(player1);
                }

            }
            else {
                System.out.println("somethin went wrong");
            }

        }

        else if (answer.equalsIgnoreCase("/move east")) {
            if (player1.getFloor()==0) {
                if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionEast())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomColumn(player1.getRoomColumn() + 1);
                    printGroundMap(player1);
                }
            }
            else if (player1.getFloor()==1) {
                if (cabin[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionEast())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomColumn(player1.getRoomColumn() + 1);
                    printCabinMap(player1);
                }
            }
            else {
                System.out.println("somethin went wrong");
            }
        }
        else if (answer.equalsIgnoreCase("/move north")) {
            if (player1.getFloor()==0) {
                if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionNorth())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");

                else {
                    player1.setRoomRow(player1.getRoomRow() - 1);
                    printGroundMap(player1);
                }
            }
            else if (player1.getFloor()==1) {
                if (cabin[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionNorth())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomRow(player1.getRoomRow() - 1);
                    printCabinMap(player1);
                }
            }
            else {
                System.out.println("somethin went wrong");
            }
        }
        else if (answer.equalsIgnoreCase("/move south")) {
            if (player1.getFloor()==0) {
                if (ground[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionSouth())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomRow(player1.getRoomRow() + 1);
                    printGroundMap(player1);
                }
            }
            else if (player1.getFloor()==1) {
                if (cabin[player1.getRoomRow()][player1.getRoomColumn()].isRestrictionSouth())
                    System.out.println("You try to get through the solid wall but alas... you fail miserably.");
                else {
                    player1.setRoomRow(player1.getRoomRow() + 1);
                    printCabinMap(player1);
                }
            }
            else {
                System.out.println("somethin went wrong");
            }
        }

        else if (answer.equalsIgnoreCase("/escape")) {
            System.out.println("Try again wise guy.");
        }

        else{
            System.out.println("Oak's words echoed... There's a time and place for everything, but not now." +
                    "\nThis is strange because you don't know a Professor Oak but his warning probably means something important anyway.");
        }
    }

    /**
     * Prints the ground array on a reabable format
     * @param player1 The player object
     */
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

    /**
     * Prints the cabin array on a reabable format
     * @param player1 The player object
     */
    public static void printCabinMap(Player player1){
        String a = " ";
        String b = " ";
        String c = " ";
        String d = " ";
        String e = " ";
        String f = " ";
        String g = " ";
        String h = " ";
        String i = " ";

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
        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==0){
            g="@";
        }
        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==1){
            h="@";
        }
        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==2){
            i="@";
        }

        System.out.println(
                "-------------" +
                        "\n| "+a+" | "+b+" | "+c+" |" +
                        "\n---------xxx-" +
                        "\n| "+d+" | "+e+" X "+f+" |" +
                        "\n-------------" +
                        "\n| "+g+" | "+h+" | "+i+" |" +
                        "\n-------------");
    }

    //ground floor activatables
    public static boolean activateLooseBoard(boolean boardsGone, boolean hasCrowbar, Player player1){
        if(hasCrowbar) {
            boardsGone = true;
            return boardsGone;
        }
        else {
            System.out.println("You can't pry these boards off with you bare hands...\nIf only you had something to help.");
            boardsGone = false;
            return boardsGone;
        }
    }

    public static void activateKeyPanel(Player player1) {

    }

    public static void activateBoards(Player player1){

    }

    public static void activateLever(boolean boardsGone, Player player1){

    }

    public static void activateTrapdoor(Player player1){

    }

    public static void activateGap(Player player1){

    }

    //cabin floor activatables
    public static void activateLadder(Player player1){

    }
    public static void activateCodePanel(Player player1){

    }
    public static void activateRightStatue(Player player1){

    }

    public static void activateLeftStatue(Player player1){

    }
    public static void activateCourtdoor(Player player1){

    }
}