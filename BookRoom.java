/*
 * Represents a room containing a mysterious book and candles
 * Open passage to the east, locked passage to the west
 */
public class BookRoom extends Room{
    /*The player cannot yet attempt to scan the card, tryScan is used to check if player noticed the scanner yet*/
    boolean tryScan = false; 
    public static Item note;
    public static Item candle;
    boolean leftRoom = false;

    /*
     * Constructs a BookRoom
     */
    public BookRoom(){
        //Initialize note
        note = new Item("note", "A note found hidden in the margins of the book. It seems much newer and is written in English. It reads: 'With beasts so large as Javaelith, normal techniques won't work. Carry with you water, pure and divine; salt for safety; and use your wits. It is a dangerous foe, one you would be wise to avoid.'");
        Main.itemLocation.put(note, "bookRoom");
        // Initialize the candle item
        candle = new Item("candle", "A partially melted candle.");
        Main.itemLocation.put(candle, "bookRoom");
    }

    /*
     * Method to swipe access card and unlock access to next room
     * Checks if player has accessCard to see if they can swipe, updating location to fightRoom
     */
    public void swipeCard(){
        if(tryScan){
            if (Main.inventory.contains(PuddleRoom.accessCard)){
                Main.location.replace("bookRoom", false);
                leftRoom = true;
                Main.location.put("fightRoom", true);
                System.out.println("You reach into your pocket to retrieve the access card. Cautiously, you hold it to the fixture.\nYou hear a beep and the sound of the door unlocking. You carefully open the door and pass through, your heart pounding.");
            } else{
                System.out.println("You have nothing to trigger the door to open!");
            }
        } else{
        System.out.println("Maybe you should look around the room more.");
        }
    }

    /*
     * Method to allow player to interact with the book and learn about it
     * Changes text if player has already been to the room before
     */
    public void interact(){
        if(!leftRoom){
            System.out.println("You attempt to pick up the book, but it is so heavy! It gets dust and dirt all over your arms. Probably best to just leave it here.\nYou decide to just look at it instead. It is massive, and the pages appear ancient. You're not sure how long ago it was written.\nIn fact, it looks handwritten... Speaking of writing, you don't quite recognize the language. Could it be latin?\nYou flip through a few pages. There are a few drawings in the text, mostly of weird shapes. A pentagram, maybe?");
            if(Main.itemLocation.containsKey(note)){
                System.out.println("You flip one more page and notice a note resting inside the book. It is in English, and appears to have been written pretty recently.\nIt reads: 'With beasts so large as Javaelith, normal techniques won't work. Carry with you water, pure and divine; salt for safety; and use your wits. He is a dangerous foe, one you would be wise to avoid.'\nHuh... you're not sure what that means. Maybe you should hold onto this note.");
            }
        }else{
            System.out.println("There used to be a book here, right? Where did it go...? Maybe you aren't alone down here after all...");
        }
        
    }

    /*
     * Utilizes pickUp method from Room class
     */
    public void pickUp(Item item) {
        super.pickUp(item);
    }

    /*
     * Utilizes drop method from Room class
     */
    public void drop(Item item) {
        super.drop(item);
    }

    /*
     * Adjusts look method from parent class Room
     * Changes text depending on if it is player's first time in the room
     */
    public void look(){
        if(!leftRoom){
            System.out.println("You take in your surroundings, your eyes adjusting to the light. You're not sure where the light is coming from, but it doesn't seem natural.\nThere is an old, thick book lying open on a rotting wooden table across the room.\nThe floor below contains a propped open trapdoor, which leads to the dungeon you just left. Could someone have left it open by mistake?\nThe room smells vaguely of sulfur, and it gives you the creeps. You feel a growing sense of dread just standing there.");
        }else{
            System.out.println("You take in your surroundings. The old, gnarled table remains in the corner, but appears empty. It looks like someone has been in here recently...");
        }if(!Player.player.hasItemInInventory(candle)){
            System.out.println("Near the table, a partially burned candle rests on the floor. Maybe it could be useful.");
        }
        
    }

    /*
     * Modifies west method
     * Checks if player has been to fightRoom to see if they can pass, updating value
     * If not, calls swipeCard
     */
    public void west() {
        System.out.println("You approach the strange door to your west.");
        if(Main.location.containsKey("fightRoom")){
            Main.location.replace("bookRoom", false);
            Main.location.replace("fightRoom", true);
            System.out.println("The door is unlocked, so you pass through.");
        } else{
            System.out.println("You try the handle. Locked. Drat!\nYour eyes turn to the mysterious fixture beside the door. Could it be a scanner?");
            tryScan = true;
        }
    }
    

    /*
     * Modifies east method
     * Updates current location to puddleRoom
     */
    public void east(){
        System.out.println("To the east, there is a narrow crack in the cavern wall. It is clear that, unlike the room you are in, this crack wasn't made by human hands.\nMaybe the crack is just wide enough for you to slip through...\nHesitantly, you turn sideways and shuffle into the passageway. Here's hoping you don't regret it.");
        Main.location.replace("bookRoom", false);
        leftRoom = true;
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
        if(!leftRoom){
            System.out.println("Along the wall rests the large table made of gnarled, decaying wood. On top of the table, there is a large, open book.\nIn the dim light, you see a few bugs crawl across the table. You feel a sense of unease looking at it.");
        }else{
            System.out.println("Along the wall rests an empty, rotting table. Most of it is covered in dust, except for a book-shaped spot... maybe a book used to be here.");
        }if(!Player.player.hasItemInInventory(candle)){
            System.out.println("There is a partially melted candle beneath the table as well.");
        }
       
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
