import java.util.Scanner;

public class PlayGame {

    /**
     * Main method of the package
     * @param args This param that every main method has
     */
    public static void main(String[] args) {
        Items screwdriver = new Items("Screwdriver", "An old screwdriver. It might be useful");
        Items crowbar = new Items("Rusty Crowbar", "Could be useful.. or harmful.");
        Items plank = new Items("An Old Plank", "Looks sturdy enough... maybe?");

        Room[][] ground = new Room[2][3];
        Room[][] cabin = new Room[3][3];

        ground[0][0] = new Room("Old Quarters", "What once was your living quarters is now a trashed and broken room with claw marks on your bed and wall. There " +
                "\nappears to be a loose board on the wall.", true, false,false,true,"BOARD","NOTHING");
        ground[0][1] = new Room("Airlock Room", "You are in a small room with an airlock however a key " +
                "\ncomponet seems to be missing from the activation panel. It looks as if a small creature must have" +
                "\nfiddled with it.",true,false,true,false,"BROKEN KEY PANEL", "NOTHING");
        ground[0][2] = new Room("Control Room", "There is a screwdriver lying around in the corner and a lever that has been" +
                "\nhastily boarded up with spare planks and panels.",true,true,true,false, "BOARDS\nLEVER","SCREWDRIVER");
        ground[1][0] = new Room("Cabin Entrance","A shut TRAPDOOR lays at your feet. You can't seem to open it.",false,false,true,true,"TRAPDOOR", "NOTHING");
        ground[1][1] = new Room("The Bridge", "A large gap stands in your way. You could have sworn there WAS a bridge here.",true,true,true,false,"GAP","NOTHING");
        ground[1][2] = new Room("Maintenance Closet", "A ravaged room where the crew's supplies used to be." +
                "\nSupposedly the imps never deemed the spare crowbar important.",true,true,true,false,"NOTHING", "CROWBAR");

        cabin[0][0] = new Room("Trapdoor entrance","A ladder leads back up to the GROUND floor..." +
                "\nWhy would they call the floor above the CABIN the GROUND floor?",true,false,false,true,"LADDER","NOTHING");
//        cabin[0][1] = new Room("Security Panel","STATUS: LOCKED. PLEASE ENTER 5 DIGIT CODE.",true,false,false,false,"KEY PANEL");
//        cabin[0][2] = new Room("Right Statue Hall","An adjustable statue stands in your way.",true,true,true,false,"LEFT ARM\nHEAD\nRIGHT ARM");
//        cabin[1][0] = new Room("Research lab","A lot of strewn notes and novels lay on the floor. \"Space Travel for DUMMIES\", " +
//                "\n\"Tips and Tricks for Avoiding Space Imps\", and a torn piece of paper labelled \"Password Reminder\": Does anyone want" +
//                "\na piece of pie?",false,false,false,true,"READ PAPER");
//        cabin[1][1] = new Room("Janitor Closet","A lone can of boring \"ANTI-SKELE SPRAY\" lays at your feet. Its" +
//                "\nmonochrome color could lull any imp to sleep. You almost don't want to take it.",false,true,false,true,"NOTHING");
        cabin[0][2] = new Room("Bathroom","Feces is on the wall, oil on the floor, and your key is in the toilet. You've spent" +
                "\nthe last 40 minutes for imps to mess with you beyond the grave. On second thought, dying here might not be so bad.",true,true,false,true,"FECES", "KEY");
//        cabin[2][0] = new Room("Left Statue Hall","An adjustable statue stands in your way.",false,false,true,true,"LEFT ARM\nHEAD\nRIGHT ARM");
//        cabin[2][1] = new Room("Manor Hall","Up on the diner table lays a message. \nIN ORDER FOR YOU TO SOLVE THE RIDDLE OF THE TWO STATUES" +
//                "\nYOU MUST MAKE THEM HIT THE DAB LIKE WIZ KHALIFA.",false,false,true,false,"NOTHING");
        cabin[0][1] = new Room("Courtyard","A floating skeleton head looms before you... It looks like you're gonna have a bad time.",false,true,true,false,"HAVE A BAD TIME","NOTHING");

        Scanner console = new Scanner(System.in);
        System.out.println("What is your name? ");
        String answer = console.nextLine();
        Player player1 = new Player(answer, "Player",11,5,5);

        boolean winCon = false;
        System.out.println("You are in a spaceship. " +
                "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                " \nYou are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship.| Use /help for a list of commands");

        while (!winCon) {
            command(ground,cabin,player1, plank, screwdriver, crowbar);

            //winCon = true;
        }
        System.out.println("You win!");
    }

    /**
     * Command method for the user input
     */
    public static void command(Room[][] ground, Room[][] cabin, Player player1, Items plank, Items screwdriver, Items crowbar) {
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("/help")) {
            System.out.println("\nCommands:" +
                    "\n/help: displays a list of commands" +
                    "\n/move (NORTH,EAST,SOUTH,WEST): move in a direction" +
                    "\n/look: provides a description of your current room" +
                    "\n/pickup: prompts you if you would like to pickup any nearby objects" +
                    "\n/activate: prompts you if you would like to activate any nearby objects" +
                    "\n/inventory: displays your current items");
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

        else if (answer.equalsIgnoreCase("/inventory")){
            System.out.println(player1);
        }

        else if (answer.equalsIgnoreCase("/pickup")) {
            if (player1.getFloor()==0){
                System.out.println("What would you like to pickup: \n" + ground[player1.getRoomRow()][player1.getRoomColumn()].getPickupDescription());
                if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("screwdriver")&&!player1.isHasScrewdriver()){
                        pickupScrewdriver(ground, player1, screwdriver);
                    }
                    else{
                        System.out.println("Uh.. What? Try /pickup again");
                    }
                }

                else if (player1.getRoomRow()==1 && player1.getRoomColumn()==2) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("crowbar") && !player1.isHasCrowbar()){
                        pickupCrowbar(ground, player1, crowbar);
                    }
                    else {
                        System.out.println("Uh.. What? Try /pickup again");
                    }
                }
            }
            else{
                System.out.println("What would you like to pickup: \n" + cabin[player1.getRoomRow()][player1.getRoomColumn()].getActivatableDescription());

                if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {

                }
            }
        }

        else if (answer.equalsIgnoreCase("/activate")) {
            if (player1.getFloor()==0){
                System.out.println("What would you like to activate: \n" + ground[player1.getRoomRow()][player1.getRoomColumn()].getActivatableDescription());
                if (player1.getRoomRow()==0&&player1.getRoomColumn()==0){
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("board")&& !player1.isHasBoard()){
                        activateLooseBoard(ground, player1, plank);
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==1) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("broken key panel")){
                        activateKeyPanel(player1);
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("boards") && !player1.isBoardsGone()){
                        activateBoards(ground, player1);
                    }
                    else if (answer.equalsIgnoreCase("lever") && !player1.isActivatedLever()){
                        activateLever(ground, player1.isBoardsGone(),player1);
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }
                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==0) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("trapdoor")){
                        activateTrapdoor(player1);
                    }

                }
                else if (player1.getRoomRow()==1&&player1.getRoomColumn()==1) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("gap")&& !player1.isCrossable()){
                        activateGap(ground, player1);
                    }
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
                        activateLadder(player1);
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==1) {

                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {

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
                    System.out.println("I don't think you can go that way");
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
     * @param player1 The current player object
     */
    public static void printCabinMap(Player player1){
        String a = " ";
        String b = " ";
        String c = " ";
//        String d = " ";
//        String e = " ";
//        String f = " ";
//        String g = " ";
//        String h = " ";
//        String i = " ";

        if (player1.getRoomRow()==0 && player1.getRoomColumn()==0){
            a="@";
        }
        else if (player1.getRoomRow()==0 && player1.getRoomColumn()==1){
            b="@";
        }
        else if (player1.getRoomRow()==0 && player1.getRoomColumn()==2){
            c="@";
        }
//        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==0){
//            d="@";
//        }
//        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==1){
//            e="@";
//        }
//        else if (player1.getRoomRow()==1 && player1.getRoomColumn()==2){
//            f="@";
//        }
//        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==0){
//            g="@";
//        }
//        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==1){
//            h="@";
//        }
//        else if (player1.getRoomRow()==2 && player1.getRoomColumn()==2){
//            i="@";
//        }

        System.out.println(
                "-------------" +
                        "\n| "+a+" | "+b+" | "+c+" |" +
//                        "\n---------xxx-" +
//                        "\n| "+d+" | "+e+" X "+f+" |" +
//                        "\n-------------" +
//                        "\n| "+g+" | "+h+" | "+i+" |" +
                        "\n-------------");
    }

    //ground floor activatables

    /**
     * Activator for the loose board
     * @param player1 The current player object
     * @param plank The plank to be broken
     */
    public static void activateLooseBoard(Room[][] ground, Player player1, Items plank){
        if (!player1.isHasScrewdriver()) {
            System.out.println("This board is loose but you need some kind of tool to help it off");
        }
        else if (player1.isHasBoard()){

        }
        else if (player1.isHasScrewdriver()){
            System.out.println("You got the wooden plank off the wall!");
            player1.setInventory(plank);
            player1.setHasBoard(true);
            ground[0][0].setActivatableDescription("NOTHING");
        }
    }

    /**
     * Activator for the key panel.
     * @param player1 The current player object
     */
    public static void activateKeyPanel(Player player1) {

    }

    /**
     * Activator for the boards
     * @param ground The ground state of Room
     * @param player1 The current player object
     */
    public static void activateBoards(Room[][] ground, Player player1){
        if(player1.isHasCrowbar()) {
            player1.setBoardsGone(true);
            System.out.println("You pryed the boards off with your trusty crowbar and SHEER GRIT.\nCongratulations you have average human strength. Or you're maybe a really weak/strong alien.");
            ground[0][2].setActivatableDescription("LEVER");

        }
        else {
            System.out.println("You can't pry these boards off with you bare hands...\nIf only you had something to help.");
            player1.setBoardsGone(false);
        }
    }

    /**
     * Activator for the lever
     * @param ground The ground state of Room
     * @param boardsGone Are the boards gone?
     * @param player1 The current player object
     */
    public static void activateLever(Room[][] ground, boolean boardsGone, Player player1){
        if (boardsGone) {
            player1.setActivatedLever(true);
            ground[0][2].setActivatableDescription("NOTHING");
            ground[1][0].setDescription("An open TRAPDOOR lays at your feet as thick cold air blows at your feet.");
            System.out.println("You flipped the LEVER and heard a loud noise.");

            if (player1.isHasScrewdriver()) {
                ground[0][2].setDescription("Nothing remains in this room except a flipped lever");
            }
            else {
                ground[0][2].setDescription("A SCREWDRIVER remains...");
            }
        }

        else
            System.out.println("There are BOARDS in the way...");

    }

    /**
     * Activator for the cabin trap door
     * @param player1 The current player object
     */
    public static void activateTrapdoor(Player player1){
        if (player1.isActivatedLever()) {
            System.out.println("You went into the CABIN floor!");
            player1.setRoomRow(0);
            player1.setRoomColumn(0);
            player1.setFloor(1);
            printCabinMap(player1);
        }
        else {
            System.out.println("The TRAPDOOR is firm shut...");
        }

    }

    /**
     * Activator for the board gaps
     * @param ground The ground state of Room
     * @param player1 The current player object
     */
    public static void activateGap(Room[][] ground, Player player1){
        if (player1.isHasBoard()) {
            ground[1][1].setRestrictionEast(false);
            System.out.println("You can now use the board to /move EAST!");
            ground[1][1].setDescription("What once was a gap now is a questionably sturdy walk way!");
            ground[1][1].setActivatableDescription("NOTHING");
            player1.setCrossable(true);
        }
        else {
            System.out.println("This gap is rather daunting... If only you had a way to get across");
        }

    }

    //cabin floor activatables

    /**
     * Activator for the cabin ladder
     * @param player1 The current player object
     */
    public static void activateLadder(Player player1){
        player1.setRoomColumn(0);
        player1.setRoomRow(1);
        player1.setFloor(0);
        printGroundMap(player1);
        System.out.println("You went to the GROUND floor!");
    }

    /**
     * Pickup method for the crowbar
     * @param ground The ground state of Room
     * @param player1 The current player object
     * @param crowbar The crowbar Item
     */
    public static void pickupCrowbar(Room[][] ground, Player player1, Items crowbar) {
        player1.setInventory(crowbar);
        player1.setHasCrowbar(true);
        System.out.println("You got the CROWBAR!");
        ground[1][2].setPickupDescription("NOTHING");
        ground[1][2].setDescription("This room has been SACKED");


    }

    /**
     * Pickup method for the screwdriver
     * @param ground The ground state of Room
     * @param player1 The current player object
     * @param screwdriver The screwdriver Item
     */
    public static void pickupScrewdriver(Room[][] ground, Player player1, Items screwdriver) {
        player1.setInventory(screwdriver);
        System.out.println("You got the SCREWDRIVER!");
        player1.setHasScrewdriver(true);
        ground[0][2].setPickupDescription("NOTHING");
        if (player1.isActivatedLever()) {
            ground[0][2].setDescription("Nothing remains in this room except a flipped lever");
        }
        else {
            ground[0][2].setDescription("A LEVER that has been hastily boarded up remains");
        }
    }
}