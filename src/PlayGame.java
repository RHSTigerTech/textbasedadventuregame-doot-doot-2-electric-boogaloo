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
        Items key = new Items("The Missing Key", "The last componet to your escape!");

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
                "\nWhy would they call the floor above the CABIN the GROUND floor?",true,false,true,true,"LADDER","NOTHING");
//        cabin[0][1] = new Room("Security Panel","STATUS: LOCKED. PLEASE ENTER 5 DIGIT CODE.",true,false,false,false,"KEY PANEL");
//        cabin[0][2] = new Room("Right Statue Hall","An adjustable statue stands in your way.",true,true,true,false,"LEFT ARM\nHEAD\nRIGHT ARM");
//        cabin[1][0] = new Room("Research lab","A lot of strewn notes and novels lay on the floor. \"Space Travel for DUMMIES\", " +
//                "\n\"Tips and Tricks for Avoiding Space Imps\", and a torn piece of paper labelled \"Password Reminder\": Does anyone want" +
//                "\na piece of pie?",false,false,false,true,"READ PAPER");
//        cabin[1][1] = new Room("Janitor Closet","A lone can of boring \"ANTI-SKELE SPRAY\" lays at your feet. Its" +
//                "\nmonochrome color could lull any imp to sleep. You almost don't want to take it.",false,true,false,true,"NOTHING");
        cabin[0][2] = new Room("Bathroom","Feces is on the wall, oil on the floor, and your key is in the toilet. You've spent" +
                "\nthe last 40 minutes for imps to mess with you beyond the grave. On second thought, dying here might not be so bad.",true,true,true,false,"NOTHING", "KEY");
//        cabin[2][0] = new Room("Left Statue Hall","An adjustable statue stands in your way.",false,false,true,true,"LEFT ARM\nHEAD\nRIGHT ARM");
//        cabin[2][1] = new Room("Manor Hall","Up on the diner table lays a message. \nIN ORDER FOR YOU TO SOLVE THE RIDDLE OF THE TWO STATUES" +
//                "\nYOU MUST MAKE THEM HIT THE DAB LIKE WIZ KHALIFA.",false,false,true,false,"NOTHING");
        cabin[0][1] = new Room("Courtyard","A SKELETON WARRIOR stands before you... It looks like you're gonna HAVE A BAD TIME.",true,true,true,false,"HAVE A BAD TIME","NOTHING");

        Scanner console = new Scanner(System.in);
        System.out.println("What is your name? ");
        String answer = console.nextLine();
        Player player1 = new Player(answer, "Player",11,5,5);

        boolean winCon = false;
        System.out.println("You are in a spaceship. " +
                "Your only chance at escaping is to dock onto a nearby ship that responded to your SOS." +
                " \nYou are out of fuel and space Imps have pulled all sorts of trickery onto the ship. |OBJECTIVE: Escape the ship.| Use /help for a list of commands");

        while (!player1.isWinCon()) {
            command(ground,cabin,player1, plank, screwdriver, crowbar, key);
        }
    }

    /**
     * Command method for the user input
     */
    public static void command(Room[][] ground, Room[][] cabin, Player player1, Items plank, Items screwdriver, Items crowbar, Items key) {
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
                System.out.println("What would you like to pickup: \n" + cabin[player1.getRoomRow()][player1.getRoomColumn()].getPickupDescription());

                if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("key") && !player1.isHasKey()) {
                        pickupKey(cabin, player1, key);
                    }
                    else
                        System.out.println("Uh.. What? Try /pickup again");
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
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("have a bad time")&&!player1.isDefeatedSkeleton()){
                        fightSkeleton(player1, cabin);
                    }
                    else{
                        System.out.println("Uh.. What? Try /activate again");
                    }
                }
                else if (player1.getRoomRow()==0&&player1.getRoomColumn()==2) {
                    activateKeyPanel(player1);
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
                    fight(player1);
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
                    fight(player1);
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
                    fight(player1);
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
                   fight(player1);
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
            ground[0][0].setDescription("You got a plank now... Cool... There was nothing behind the plank... Just more wall...");
        }
        player1.setAddedDamage(4);
    }

    /**
     * Activator for the key panel.
     * @param player1 The current player object
     */
    public static void activateKeyPanel(Player player1) {
        if (player1.isHasKey()) {
            System.out.println("You plugged the key and got rescued... Thank you for playing!");
            player1.setWinCon(true);
        }
        else
            System.out.println("You still need the key!");
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
        player1.setAddedDamage(6);

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
        player1.setAddedDamage(2);
    }

    /**
     * Pickup method for the key
     * @param cabin The cabin state of Room
     * @param player1 The current player object
     * @param key The key Item
     */
    public static void pickupKey(Room[][] cabin, Player player1, Items key) {
        player1.setInventory(key);
        System.out.println("You got the KEY!");
        player1.setHasKey(true);
        cabin[0][2].setPickupDescription("NOTHING");
        cabin[0][2].setDescription("Nothing remains in this room");
    }

    /**
     * Fight encounter method
     * @param player1 The current player object
     */
    public static void fight(Player player1){
        if (Math.random()<0.34){
            if (Math.random()>0.51){
                fightImp(player1);
            }
            else
                fightBrute(player1);
        }
    }

    /**
     * Fight method for the Imp
     * @param player1 The current player object
     */
    public static void fightImp(Player player1){
        Scanner console = new Scanner(System.in);
        String answer = "";
        int playerTurnDamage = 0;
        int enemyTurnDamage = 0;
        System.out.println(
                "                                    ,\n" +
                        "       ,  .   (          )          -.\\ |\n" +
                        "       | / .- |\\        /|         _  \\'/\n" +
                        "        \\'/   | \\.-\"\"-./ |          \\_) ;-'\n" +
                        "     `'-; (_/ ;   _  _   ;           ) /\n" +
                        "         \\ (   \\ (.\\/.) /    .-.    / |\n" +
                        "          \\ \\   \\ \\/\\/ /-._.'   \\   | |\n" +
                        "           \\ \\   \\ .. /_         \\  | |\n" +
                        "            \\ \\   |  |__)     |\\  \\ | |\n" +
                        "             \\ `\"`|==|_       | \\  \\| |\n" +
                        "              \\,-'|==| \\      |  \\    |\n" +
                        "                   \\/   '.    /   `\\ /\n" +
                        "                          |   |     `   ,\n" +
                        "                          |   |         )\\\n" +
                        "                __.....__/    |        /  \\\n" +
                        "              /`              \\        `//`\n" +
                        "              |  \\`-....-'\\    `-.____.'/\n" +
                        "              |  |        /   /`\"-----'`\n" +
                        "              |  |        |  |\n" +
                        "              | /         |  |\n" +
                        "       .------' \\         /  /\n" +
                        "      (((--------'        \\  |\n" +
                        "                           | \\\n" +
                        "                           | |\n" +
                        "                           | |\n" +
                        "                           | /\n" +
                        "                          /  )\n" +
                        "                         /   |\n" +
                        "                        (-(-('"

        );
        System.out.println("An IMP appears before you!");
        Imp newIMP = new Imp((int)(Math.random()*4+4),(int)(Math.random()*2+2),(int)(Math.random()*2+2));
        while (newIMP.getHealth()>0){
            answer = "";
            if(player1.getHealth()<=0){
                System.out.println("You died!");
                System.exit(0);
            }
            while (!answer.equalsIgnoreCase("/attack")) {
                System.out.println("Quick! Use /Attack to defeat this ENEMY!");
                answer = console.nextLine();
                if (!answer.equalsIgnoreCase("/attack")) {
                    System.out.println("Uh.. What? Try /attack again");
                }
            }
            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newIMP.getHealth());
            playerTurnDamage = (int)(((player1.getStrength()+player1.getAddedDamage())+(Math.random()*2))/(int)(newIMP.getDefense()-Math.random()*2));
            System.out.println("You did " + playerTurnDamage + " damage!");
            newIMP.setHealth(newIMP.getHealth()-playerTurnDamage);
            enemyTurnDamage = (int)((newIMP.getStrength()+(Math.random()*2))/(int)(player1.getDefense()-Math.random()*2));
            System.out.println("You took " + enemyTurnDamage + " damage!");
            player1.setHealth(player1.getHealth()-enemyTurnDamage);
            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newIMP.getHealth());

            System.out.println(
                    "                                    ,\n" +
                            "       ,  .   (          )          -.\\ |\n" +
                            "       | / .- |\\        /|         _  \\'/\n" +
                            "        \\'/   | \\.-\"\"-./ |          \\_) ;-'\n" +
                            "     `'-; (_/ ;   _  _   ;           ) /\n" +
                            "         \\ (   \\ (.\\/.) /    .-.    / |\n" +
                            "          \\ \\   \\ \\/\\/ /-._.'   \\   | |\n" +
                            "           \\ \\   \\ .. /_         \\  | |\n" +
                            "            \\ \\   |  |__)     |\\  \\ | |\n" +
                            "             \\ `\"`|==|_       | \\  \\| |\n" +
                            "              \\,-'|==| \\      |  \\    |\n" +
                            "                   \\/   '.    /   `\\ /\n" +
                            "                          |   |     `   ,\n" +
                            "                          |   |         )\\\n" +
                            "                __.....__/    |        /  \\\n" +
                            "              /`              \\        `//`\n" +
                            "              |  \\`-....-'\\    `-.____.'/\n" +
                            "              |  |        /   /`\"-----'`\n" +
                            "              |  |        |  |\n" +
                            "              | /         |  |\n" +
                            "       .------' \\         /  /\n" +
                            "      (((--------'        \\  |\n" +
                            "                           | \\\n" +
                            "                           | |\n" +
                            "                           | |\n" +
                            "                           | /\n" +
                            "                          /  )\n" +
                            "                         /   |\n" +
                            "                        (-(-('"

            );
            System.out.println(newIMP.getDialog());
        }
        System.out.println("\n\n\n\n\n\n\n\n" +
                "You defeated the IMP!");
        player1.setHealth(11);
    }

    /**
     * Fight method for the Brute
     * @param player1 The current player object
     */
    public static void fightBrute(Player player1){
        Scanner console = new Scanner(System.in);
        String answer = "";
        int playerTurnDamage = 0;
        int enemyTurnDamage = 0;
        System.out.println("\n" +
                "      /)   /)       \n" +
                "     ( ｡•ㅅ•｡ )　　  \n" +
                "　＿ノ ヽ　ノ ＼＿   \n" +
                "`/　`/ ⌒Ｙ⌒ Ｙ　ヽ  \n" +
                "( 　(三ヽ人　 /　　|  \n" +
                "|　ﾉ⌒＼ ￣￣ヽ　 ノ  \n" +
                "ヽ＿＿＿＞､＿＿_／    \n" +
                "　　 ｜( 王 ﾉ〈      \n" +
                "　　 /ﾐ`ー―彡ヽ      ");
        System.out.println("A BRUTE appears!");
        Brute newBRUTE = new Brute((int)(Math.random()*4+1),(int)(Math.random()*8+2),(int)(Math.random()*4+1));
        while (newBRUTE.getHealth()>0){
            answer = "";
            if(player1.getHealth()<=0){
                System.out.println("You died!");
                System.exit(0);
            }
            while (!answer.equalsIgnoreCase("/attack")) {
                System.out.println("Quick! Use /Attack to defeat this ENEMY!");
                answer = console.nextLine();
                if (!answer.equalsIgnoreCase("/attack")) {
                    System.out.println("Uh.. What? Try /attack again");
                }
            }
            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newBRUTE.getHealth());

            playerTurnDamage = (int)(((player1.getStrength()+player1.getAddedDamage())+(Math.random()*2))/(int)(newBRUTE.getDefense()-Math.random()*2));
            if (playerTurnDamage>9)
                playerTurnDamage=9;
            System.out.println("You did " + playerTurnDamage + " damage!");
            newBRUTE.setHealth(newBRUTE.getHealth()-playerTurnDamage);

            enemyTurnDamage = (int)((newBRUTE.getStrength()+(Math.random()*2))/(int)(player1.getDefense()-Math.random()*2));
            if (enemyTurnDamage>9)
                enemyTurnDamage=9;
            System.out.println("You took " + enemyTurnDamage + " damage!");
            player1.setHealth(player1.getHealth()-enemyTurnDamage);

            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newBRUTE.getHealth());

            System.out.println("\n" +
                    "      /)   /)       \n" +
                    "     ( ｡•ㅅ•｡ )　　  \n" +
                    "　＿ノ ヽ　ノ ＼＿   \n" +
                    "`/　`/ ⌒Ｙ⌒ Ｙ　ヽ  \n" +
                    "( 　(三ヽ人　 /　　|  \n" +
                    "|　ﾉ⌒＼ ￣￣ヽ　 ノ  \n" +
                    "ヽ＿＿＿＞､＿＿_／    \n" +
                    "　　 ｜( 王 ﾉ〈      \n" +
                    "　　 /ﾐ`ー―彡ヽ      ");
            System.out.println(newBRUTE.getDialog());


        }
        System.out.println("\n\n\n\n\n\n\n\n" +
                "You defeated the BRUTE!");
        player1.setHealth(11);
    }

    /**
     * Fight method for the skeleton
     * @param player1 The current player object
     * @param cabin The cabin state of Room
     */
    public static void fightSkeleton(Player player1, Room[][] cabin){
        Scanner console = new Scanner(System.in);
        String answer = "";
        int playerTurnDamage = 0;
        int enemyTurnDamage = 0;
        System.out.println("" +
                "                             _.--\"\"-._\n" +
                "  .                         .\"         \".\n" +
                " / \\    ,^.         /(     Y             |      )\\\n" +
                "/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )\n" +
                "|        :|    `>   '.     l_..-------.._l      .'\n" +
                "|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"\n" +
                " \\  .-' | |  `              l._       _.'\n" +
                "  \\/    | |                   l`^^'^^'j\n" +
                "        | |                _   \\_____/     _\n" +
                "        j |               l `--__)-'(__.--' |\n" +
                "        | |               | /`---``-----'\"1 |  ,-----.\n" +
                "        | |               )/  `--' '---'   \\'-'  ___  `-.\n" +
                "        | |              //  `-'  '`----'  /  ,-'   I`.  \\\n" +
                "      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\\n" +
                "     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\n" +
                "      `._;/7(-.......'  /        ) (     |  |            | |\n" +
                "      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\n" +
                "        | |                 .__ )-'\\  __  \\  \\  I   1   / /\n" +
                "        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /\n" +
                "                           \\__  `-'    __/  `-. `---'',-'\n" +
                "                              )-._.-- (        `-----'\n" +
                "                             )(  l\\ o ('..-.\n" +
                "                       _..--' _'-' '--'.-. |\n" +
                "                __,,-'' _,,-''            \\ \\\n" +
                "               f'. _,,-'                   \\ \\\n" +
                "              ()--  |                       \\ \\\n" +
                "                \\.  |                       /  \\\n" +
                "                  \\ \\                      |._  |\n" +
                "                   \\ \\                     |  ()|\n" +
                "                    \\ \\                     \\  /\n" +
                "                     ) `-.                   | |\n" +
                "                    // .__)                  | |\n" +
                "                 _.//7'                      | |\n" +
                "               '---'                         j_| `\n" +
                "                                            (| |\n" +
                "                                             |  \\\n" +
                "                                             |lllj\n" +
                "                                             |||||  ");
        System.out.println("A TRUE WARRIOR block your path!");
        Skeleton newSkeleton = new Skeleton((int)(Math.random()*16+5),(int)(Math.random()*4+2),(int)(Math.random()*4+1));
        while (newSkeleton.getHealth()>0){
            answer = "";
            if(player1.getHealth()<=0){
                System.out.println("You died!");
                System.exit(0);
            }
            while (!answer.equalsIgnoreCase("/attack")) {
                System.out.println("Quick! Use /Attack to defeat this ENEMY!");
                answer = console.nextLine();
                if (!answer.equalsIgnoreCase("/attack")) {
                    System.out.println("Uh.. What? Try /attack again");
                }
            }
            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newSkeleton.getHealth());

            playerTurnDamage = (int)(((player1.getStrength()+player1.getAddedDamage())+(Math.random()*2))/(int)(newSkeleton.getDefense()-Math.random()*2));
            if (playerTurnDamage>9)
                playerTurnDamage=9;
            System.out.println("You did " + playerTurnDamage + " damage!");
            newSkeleton.setHealth(newSkeleton.getHealth()-playerTurnDamage);

            enemyTurnDamage = (int)((newSkeleton.getStrength()+(Math.random()*2))/(int)(player1.getDefense()-Math.random()*2));
            if (enemyTurnDamage>9)
                enemyTurnDamage=9;
            System.out.println("You took " + enemyTurnDamage + " damage!");
            player1.setHealth(player1.getHealth()-enemyTurnDamage);

            System.out.println("Your HEALTH: " + player1.getHealth());
            System.out.println("Enemy HEALTH: " + newSkeleton.getHealth());

            System.out.println("" +
                    "                             _.--\"\"-._\n" +
                    "  .                         .\"         \".\n" +
                    " / \\    ,^.         /(     Y             |      )\\\n" +
                    "/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )\n" +
                    "|        :|    `>   '.     l_..-------.._l      .'\n" +
                    "|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"\n" +
                    " \\  .-' | |  `              l._       _.'\n" +
                    "  \\/    | |                   l`^^'^^'j\n" +
                    "        | |                _   \\_____/     _\n" +
                    "        j |               l `--__)-'(__.--' |\n" +
                    "        | |               | /`---``-----'\"1 |  ,-----.\n" +
                    "        | |               )/  `--' '---'   \\'-'  ___  `-.\n" +
                    "        | |              //  `-'  '`----'  /  ,-'   I`.  \\\n" +
                    "      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\\n" +
                    "     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\n" +
                    "      `._;/7(-.......'  /        ) (     |  |            | |\n" +
                    "      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\n" +
                    "        | |                 .__ )-'\\  __  \\  \\  I   1   / /\n" +
                    "        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /\n" +
                    "                           \\__  `-'    __/  `-. `---'',-'\n" +
                    "                              )-._.-- (        `-----'\n" +
                    "                             )(  l\\ o ('..-.\n" +
                    "                       _..--' _'-' '--'.-. |\n" +
                    "                __,,-'' _,,-''            \\ \\\n" +
                    "               f'. _,,-'                   \\ \\\n" +
                    "              ()--  |                       \\ \\\n" +
                    "                \\.  |                       /  \\\n" +
                    "                  \\ \\                      |._  |\n" +
                    "                   \\ \\                     |  ()|\n" +
                    "                    \\ \\                     \\  /\n" +
                    "                     ) `-.                   | |\n" +
                    "                    // .__)                  | |\n" +
                    "                 _.//7'                      | |\n" +
                    "               '---'                         j_| `\n" +
                    "                                            (| |\n" +
                    "                                             |  \\\n" +
                    "                                             |lllj\n" +
                    "                                             |||||  ");
            System.out.println(newSkeleton.getDialog());

        }
        System.out.println("\n\n\n\n\n\n\n\n" +
                "You defeated the SKELETON!");
        player1.setHealth(11);
        cabin[0][1].setActivatableDescription("NOTHING");
        cabin[0][1].setDescription("A pile of bones lay at your feet. You feel victorious.");
        player1.setDefeatedSkeleton(true);
        cabin[0][1].setRestrictionEast(false);
        System.out.println("You can now proceed with /move EAST");
    }
}