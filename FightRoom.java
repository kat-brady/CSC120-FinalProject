/*
 * Represents a room where a lone cult member will fight the player
 * Open passage to the north and east
 */
public class FightRoom extends Room{

    boolean isDefeated = false; //while the cult member has not been defeated, the boolean is false to limit movement

    public FightRoom(){
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look();
        System.out.println("You start to look around, but find yourself interrupted by an angry voice.\n'Hey, you! How did you get out?!' the voice yells. You look in the direction of the voice and see a mysterious figure, wearing a velvety, dark red robe.\nThe robe conceals their face and extends to the floor, so that you cannot see any of their skin. There's no telling if your adversary is human or not.\nThey move closer to you. It's clear that you're going to have to fight if you don't want to end up back in the dungeon.");
    }

    /*
     * Adjusts west method from parent class Room
     * Cannot go west if !isDefeated
     */
    public void west() {
        if(!isDefeated){
            System.out.println("You can't try going west- you're in the middle of a fight!");
        }else{
        //look at map
        }
    }

    /*
     * Adjusts east method from parent class Room
     * Cannot go east if !isDefeated
     * East leads to BookRoom
     */
    public void east(){
        if(!isDefeated){
            System.out.println("You should focus on your opponent, not try escaping!");
        }else{
            Main.location.replace("fightRoom", false);
            Main.location.replace("bookRoom",true);
        }
    }

    /*
     * Adjusts north method from parent class Room
     * Cannot go north if !isDefeated
     */
    public void north() {
        if(!isDefeated){
            System.out.println("You can't escape, you need to fight for your own safety!");
        }else{
            //look at map
        }
    }

    /*
     * Utilizes south method from parent class Room
     * Cannot go south if !isDefeated
     */
    public void south(){
        if(!isDefeated){
            System.out.println("Focus on your adversary first!");
        }else{
            //look at map
        }
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

    static FightRoom fightRoom = new FightRoom();
}
