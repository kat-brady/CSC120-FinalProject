/*
 * Represents a room containing a mysterious book and candles
 * Open passage to the east, locked passage to the west
 */
public class BookRoom extends Room{

    /*
     * Constructs a BookRoom
     */
    public BookRoom(){
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look();
        System.out.println("You take in your surroundings, your eyes adjusting to the light. There is an old, thick book lying open on a rotting wooden table across the room.\nThe floor below contains a propped open trapdoor, which leads to the dungeon you just left. Could someone have left it open by mistake?\nNear the table, partially burned candles rest on the floor. The room smells vaguely of sulfur, and it gives you the creeps. You feel a growing sense of dread just standing there.");
    }

    /*
     * Modifies west method
     * Checks if player has been to fightRoom to see if they can pass, updating value
     * If not, checks if player has accessCard to see if they can pass, updating location to fightRoom
     */
    public void west() {
        System.out.println("You approach the strange door to your west.");
        if(Main.location.containsKey("fightRoom")){
            Main.location.replace("bookRoom", false);
            Main.location.replace("fightRoom", true);
            System.out.println("The door is unlocked, so you pass through.");
        } else{
            System.out.println("You try the handle. Locked. Drat!\nYour eyes turn to the mysterious fixture beside the door. Could it be a scanner?");
            if (Main.inventory.contains("accessCard")){
                //if (Main.userResponse.contains("SWIPE")||("SCAN")){
                    //Main.location.replace("bookRoom", false);
                    //Main.location.put("fightRoom", true);
                    //System.out.println("You reach into your pocket to retrieve the access card. Cautiously, you hold it to the fixture.\nYou hear a beep and the sound of the door unlocking. You carefully open the door and pass through, your heart pounding.");
                }
            } //else{
                //System.out.println("Maybe you should look around the room more.");
            }
        //}
    //}

    /*
     * Modifies east method
     * Updates current location to puddleRoom
     */
    public void east(){
        System.out.println("To the east, there is a narrow crack in the cavern wall. It is clear that, unlike the room you are in, this crack wasn't made by human hands.\nMaybe the crack is just wide enough for you to slip through...\nHesitantly, you turn sideways and shuffle into the passageway. Here's hoping you don't regret it.");
        Main.location.replace("bookRoom", false);
        if(Main.location.containsKey("puddleRoom")){
            Main.location.replace("puddleRoom", true);
        } else{
            Main.location.put("puddleRoom", true);
        }
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north() {
        super.north();
        System.out.println("Along the wall rests the large table made of gnarled, decaying wood. You reach out to touch it.\nOww! A splinter!");
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        super.south();
    }

    /*
     * Utilizes up method from parent class Room
     */
    public void up(){
        super.up();
    }

    /*
     * Adjusts down method to allow player to return to dungeon
     */
    public void down(){
        System.out.println("Below, you see the open trapdoor revealing a ladder. You lower yourself down and descend into the dungeon below.");
        Main.location.replace("bookRoom",false);
        Main.location.replace("dungeon", true);
    }



    /*
     * Creates an instance of BookRoom
     */
    static BookRoom bookRoom = new BookRoom();
}
