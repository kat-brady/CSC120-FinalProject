import java.util.*;
/*
 * Main loop to connect all Room classes and run through the game
 */
public class Main {

    public static Hashtable<String, Boolean> location;
    public static ArrayList<String> inventory;

    /*
     * Main body runs the loop
     */
    public static void main(String[] args) {

        location = new Hashtable<String, Boolean>();
        inventory = new ArrayList<String>();

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
            if (userResponse.contains("LOOK")){
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.look();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.look();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.look();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.look();
                }
            }else if (userResponse.contains("WEST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.west();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.west();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.west();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.west();
                }
            }else if (userResponse.contains("EAST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.east();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.east();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.east();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.east();
                }
            }else if (userResponse.contains("NORTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.north();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.north();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.north();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.north();
                }
            }else if (userResponse.contains("SOUTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.south();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.south();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.south();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.south();
                }
            }else if (userResponse.contains("DOWN")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.down();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.down();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.down();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.down();
                }
            }else if (userResponse.contains("UP")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.up();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.up();
                } else if(location.get("puddleRoom")==true){
                    //PuddleRoom.puddleRoom.up();
                } else if(location.get("fightRoom")==true){
                    //FightRoom.fightRoom.up();
                }
            }else if (userResponse.contains("SWIPE")||userResponse.contains("SCAN")){
                if(!location.containsKey("bookRoom")||location.get("bookRoom")==false){
                    System.out.println("There is nothing to " + userResponse.toLowerCase() + " in this room.");    
                }else{
                    BookRoom.bookRoom.swipeCard();
                }
            }else if (userResponse.contains("EXIT") || userResponse.contains("QUIT")) {
                stillPlaying = false;
            }else if(userResponse.contains("HELP")||userResponse.contains("INFO")) {
                System.out.println("INSERT VALUABLE HELP HERE");
            }
            else{
                System.out.println("You don't think that '" + userResponse.toLowerCase() + "' is going to help you escape, so you do nothing.");
            }
        } while (stillPlaying);

        userInput.close();

        if (userResponse.equals("EXIT")|| userResponse.equals("QUIT")) {
            System.out.println("You have left the game. Shame. Looks like your character will be trapped in that cave forever...");
        } else { 
            System.out.println("To be edited...");
        }

    }

}