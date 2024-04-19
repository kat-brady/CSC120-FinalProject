import java.util.*;

public class Main {

    public static Hashtable<String, Boolean> location;
    public static ArrayList<String> inventory;

    public static void main(String[] args) {

        location = new Hashtable<String, Boolean>();

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // This could be replaced with a more interesting opening
        System.out.println("You slowly open your eyes, but everything remains black. Your head is pounding. Where are you?");
        System.out.println("You smell dirt, and come to realize the reason you can't see anything is because there is no light.");
        System.out.println("The last thing you seem to remember is walking your dog... how did you end up here? Are you dead?");
        System.out.println("You're so confused. Maybe you should try to find a way out.");
        location.put("dungeon", true);

        // Instructions are sometimes helpful
        System.out.println("INSERT INSTRUCTIONS");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            userResponse = userInput.nextLine().toUpperCase();
            if (userResponse.contains("LOOK")){
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.look();
                } else if(location.get("bookroom")==true){
                    BookRoom.bookRoom.look();
                }
            }
            if (userResponse.contains("WEST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.west();
                } else if(location.get("bookroom")==true){
                    BookRoom.bookRoom.west();
                }
            }

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("WIN") || userResponse.equals("LOSE")) {
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won!");
        } else { // userResponse.equals("LOSE")
            System.out.println("Better luck next time.");
        }

    }

}