import java.util.*;
/*
 * Main loop to connect all Room classes and run through the game
 */
public class Main {

    public static Hashtable<String, Boolean> location;
    public static Hashtable<Item, String> itemLocation;
    public static ArrayList<Item> inventory;
    public static String attackMethod;


    /*
     * Main body runs the loop
     */
    public static void main(String[] args) {

        location = new Hashtable<String, Boolean>();
        inventory = new ArrayList<Item>();
        itemLocation = new Hashtable<Item, String>();

        boolean stillPlaying = true;

        Scanner userInput = new Scanner(System.in);

        String userResponse = "";

        //brief intro
        location.put("dungeon", true);
        System.out.println("You slowly open your eyes, but everything remains black. Your head is pounding. Where are you?");
        System.out.println("You smell dirt, and come to realize the reason you can't see anything is because there is no light.");
        System.out.println("The last thing you seem to remember is walking your dog... how did you end up here? Are you dead?");
        System.out.println("You're so confused. Maybe you should try to find a way out.");

        /*
         * Loop through while the user is still playing
         */
        do {
            userResponse = userInput.nextLine().toUpperCase(); //responses aren't case sensitive
            if(Player.player.health<=0){
                stillPlaying = false;
            }else if (userResponse.contains("LOOK")){
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.look();
                }else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.look();
                }else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.look();
                }else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.look();
                }else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.look();
                }else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.look();
                }else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.look();
                }else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.look();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.look();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.look();
                }
            }else if(userResponse.contains("PICK UP")||userResponse.contains("GRAB")||userResponse.contains("TAKE")){
                if(userResponse.contains("NOTE")){
                    if(location.containsKey("bookRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(BookRoom.note);
                    } else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("SPEAR")){
                    if(location.containsKey("fightRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(FightRoom.spear);
                    }else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("CARD")) {
                    if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(PuddleRoom.accessCard);
                    }
                    else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("ROBE")) {
                    if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(PuddleRoom.cultRobe);
                    }
                    else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("SALT")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.salt);
                    }
                    else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("MATCHES")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.matches);
                    }
                    else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("BOTTLE")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.bottle);
                    }
                    else{
                        System.out.println("There is no " + userResponse.toLowerCase() + " here.");
                    }
                }else if(userResponse.contains("CANDLE")){
                    if(location.containsKey("bookRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(BookRoom.candle);
                    } else{
                        System.out.println("There is no candle here.");
                    }
                }else if(userResponse.contains("BOOK")){
                    if(location.containsKey("bookRoom")==true){
                        BookRoom.bookRoom.interact();
                    }else{
                        System.out.println("There is no book here.");
                    }
                }else{
                    System.out.println("You can't pick that up!");
                    }
            }else if(userResponse.contains("DROP")||userResponse.contains("PUT DOWN")||userResponse.contains("LEAVE")){
                //write drop code
            }else if (userResponse.contains("WEST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.west();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.west();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.west();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.west();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.west();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.west();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.west();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.west();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.west();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.west();
                }
            }else if (userResponse.contains("EAST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.east();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.east();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.east();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.east();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.east();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.east();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.east();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.east();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.east();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.east();
                }
            }else if (userResponse.contains("NORTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.north();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.north();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.north();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.north();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.north();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.north();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.north();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.north();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.north();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.north();
                }
            }else if (userResponse.contains("SOUTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.south();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.south();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.south();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.south();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.south();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.south();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.south();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.south();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.south();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.south();
                }
            }else if (userResponse.contains("DOWN")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.down();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.down();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.down();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.down();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.down();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.down();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.down();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.down();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.down();
                } else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.down();
                } 
            }else if (userResponse.contains("UP")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.up();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.up();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.up();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.up();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.up();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.up();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.up();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.up();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.up();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.up();
                }
            }else if (userResponse.contains("SWIPE")||userResponse.contains("SCAN")){
                if(!location.containsKey("bookRoom")||location.get("bookRoom")==false){
                    System.out.println("There is nothing to " + userResponse.toLowerCase() + " in this room.");    
                }else{
                    BookRoom.bookRoom.swipeCard();
                }
            }else if(userResponse.contains("KICK")||userResponse.contains("PUNCH")||userResponse.contains("FIGHT")||userResponse.contains("TRIP")||userResponse.contains("SLAP")||userResponse.contains("HEAL")){
                attackMethod = userResponse.toLowerCase();
                if(location.containsKey("fightRoom")){
                    if(location.get("fightRoom")==true){
                        if(!attackMethod.equals("heal")){
                        FightRoom.fightRoom.attack();
                        }else{
                            System.out.println("There is nothing for you to heal yourself with.");
                        }
                    }else{
                        System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                    }
                }else if(location.containsKey("demonRoom")){
                    if(location.get("demonRoom")==true){
                        if(attackMethod.equals("kick")||attackMethod.equals("punch")||attackMethod.equals("trip")||attackMethod.equals("slap")){
                            System.out.println("You wouldn't want to fight Javaelith with your bare hands! You should use your supplies.");
                        }else{
                            DemonRoom.demonRoom.attack();
                        }
                    }else{
                        System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                    }
                }else{
                    System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                }
            }else if(userResponse.contains("WATCH")){
                if(location.containsKey("surveillanceRoom")){
                    if(location.get("surveillanceRoom")==true){
                        SurveillanceRoom.surveillanceRoom.watch();
                    }else{
                        System.out.println("There is nothing to watch here.");
                    }
                }else{
                    System.out.println("There is nothing to watch here.");
                }
            }else if(userResponse.contains("CLIMB")){
                if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.climbRocks();
                } else{
                    System.out.println("There is nothing to climb here.");
                }
            }else if (userResponse.contains("FILL")){
                if (location.get("puddleRoom")){
                    PuddleRoom.puddleRoom.fillBottle(null);
                } else{
                    System.out.println("You can't fill the bottle here!");
                }
            }else if (userResponse.contains("EXIT") || userResponse.contains("QUIT")) {
                stillPlaying = false;
            }else if(userResponse.contains("HELP")||userResponse.contains("INFO")) {
                System.out.println("You are trapped in a mysterious underground world. Everything feels unsettling and you seem to have lost your memory. How did you get down here? Where are you? How do you get out? All you know is that something is seriously wrong. If you want to escape with your life, you'll need to use your wits to explore and find a way out.");
            }else if(userResponse.contains("INVENTORY")){ 
                for(Item item: inventory){
                    System.out.println(item);
                }
            }else{
                System.out.println("You don't think that '" + userResponse.toLowerCase() + "' is going to help you escape, so you do nothing.");
            }
        }while (stillPlaying);

        userInput.close();

        if (userResponse.equals("EXIT")|| userResponse.equals("QUIT")) {
            System.out.println("You have left the game. Shame. Looks like your character will be trapped in that cave forever...");
        } else if(Player.player.die()){
            System.out.println("Everything fades to black...you have died! Maybe, in another life, you'd have been able to escape.");
        }else if(DemonRoom.demonRoom.isDefeated){
            System.out.println("At Javaelith's disappearance, you notice a ladder leading upwards in the corner. You climb it eagerly.\nYou're out of the cave, standing atop a mountain. Ah, fresh air! How you missed this feeling.\nYou're fully convinced that you're traumatized by this experience, but at least you can go home now.");
            System.out.println("You have won! Congratulations, player!");
        }else { 
            System.out.println("An unexpected condition has ended your game...");
        }
    }
}
