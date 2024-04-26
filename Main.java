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
        inventory.add(PuddleRoom.accessCard);

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
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.look();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.look();
               }else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.look();
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
                }else{
                    System.out.println("You can't pick that up!");
                }
            }else if (userResponse.contains("WEST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.west();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.west();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.west();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.west();
                }
            }else if (userResponse.contains("EAST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.east();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.east();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.east();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.east();
                }
            }else if (userResponse.contains("NORTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.north();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.north();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.north();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.north();
                }
            }else if (userResponse.contains("SOUTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.south();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.south();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.south();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.south();
                }
            }else if (userResponse.contains("DOWN")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.down();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.down();
                //} else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.down();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.down();
                }
            }else if (userResponse.contains("UP")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.up();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.up();
               // } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.up();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.up();
                }
            }else if (userResponse.contains("SWIPE")||userResponse.contains("SCAN")){
                if(!location.containsKey("bookRoom")||location.get("bookRoom")==false){
                    System.out.println("There is nothing to " + userResponse.toLowerCase() + " in this room.");    
                }else{
                    BookRoom.bookRoom.swipeCard();
                }
            }else if(userResponse.contains("KICK")||userResponse.contains("PUNCH")||userResponse.contains("FIGHT")||userResponse.contains("TRIP")||userResponse.contains("SLAP")){
                if(location.get("fightRoom")==true){
                    attackMethod = userResponse.toLowerCase();
                    FightRoom.fightRoom.attack();
                    }else{
                    System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                }
            }else if (userResponse.contains("EXIT") || userResponse.contains("QUIT")) {
                stillPlaying = false;
            }else if(userResponse.contains("HELP")||userResponse.contains("INFO")) {
                System.out.println("You are trapped in a mysterious underground world. Everything feels unsettling and you seem to have lost your memory. How did you get down here? Where are you? How do you get out? All you know is that something is seriously wrong. If you want to escape with your life, you'll need to use your wits to explore and find a way out.");
            }else if(userResponse.contains("INVENTORY")){ //this needs to be fixed!!!!!
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
        } else { 
            System.out.println("To be edited...");
        }

    }

}