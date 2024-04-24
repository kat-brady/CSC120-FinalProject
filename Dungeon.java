/*
 * Represents the player's starting place, a dark dungeon containing a ladder
 * Open passage up
 */
public class Dungeon extends Room {

    /*
     * Constructs a Dungeon
     * Updates Hashtable to add dungeon as a location if the player has never been
     * Updates dungeon value to true to indicate it is the current room
     */
    public Dungeon(){
        
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look();
        System.out.println("You look around, but you can't go anywhere. You appear to be in some kind of dungeon. Maybe if you feel your surroundings, you can find a way out.");
    }

    /*
     * Adjusts west method from parent class Room
     */
    public void west() {
        super.west();
        System.out.println("It feels like you're in some kind of dirt pit.");
    }

    /*
     * Utilizes east method from parent class Room
     */
    public void east(){
        super.east();
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north() {
        super.north();
        System.out.println("You see there are vines growing down from above. You wonder what may be up there...");
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        super.south();
    }

    /*
     * Modifies up method to allow player to exit the dungeon room
     * Adjusts dungeon to false in Hashtable to indicate player has been to dungeon before, but is not currently there
     * Adds/adjusts bookroom to Hashtable as current location
     */
    public void up(){
        System.out.println("You gaze upwards, feeling blindly in the darkness. Wait... is that a ladder?\nYou climb the ladder, going upwards into a dimly lit room.");
        Main.location.replace("dungeon", false);
        if(Main.location.containsKey("bookRoom")){
            Main.location.replace("bookRoom", true);
        } else{
            Main.location.put("bookRoom", true);
        }
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down(){
        super.down();
    }
    
    /*
     * Creates an instance of the Dungeon class for the dungeon room
     */
    static Dungeon dungeon = new Dungeon();

}
