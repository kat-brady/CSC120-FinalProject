/**
 * Represents a room with a puddle and stalactites.
 */
public class PuddleRoom extends Room {
    /** The access card of a cult member in the puddle. */
    public static Item accessCard;

    /** The robe of a cult member hanging on a stalactite. */
    public static Item cultRobe;

    /**
     * Constructs a new PuddleRoom object.
     */
    public PuddleRoom() {
        accessCard = new Item("Access Card", "An access card of a cult member.");
        Main.itemLocation.put(accessCard, "puddleRoom");
        cultRobe = new Item("Cult Robe", "A robe worn by a cult member, found hanging on a stalactite.");
        Main.itemLocation.put(cultRobe, "puddleRoom");
    }

    /*
     * Method to allow player to pick up/take items
     *@param item the item to be interacted with
     */
    public void pickUp(Item item) {
        Player.addItemToInventory(item);
    }

    /*
     * Method to allow player to drop items
     * @param item the item to be dropped
     */
    public void drop(Item item) {
        Player.removeItemFromInventory(item);
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look(); 
        System.out.println("You look around and find yourself surrounded by stalactites. You realize you are in a cave.");
    }

    /*
     * Adjusts west method from parent class Room
     */
    public void west() {
        super.west();
        System.out.println("You turn west and leave the room.");
        Main.location.replace("puddleRoom", false);
        Main.location.replace("bookRoom", true);
    }

    /*
     * Utilizes east method from parent class Room
     */
    public void east(){
        super.east();
        System.out.println("You turn east and see a puddle with an access card inside. Hmm... there is somethinig special about the water.");
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north() {
        super.north();
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        super.south();
        System.out.println("You turn south on notice a piece of robe hanging on one of the stalactites. It reminds you of cults...");
    }

    /*
     * Utilizes up method from parent class Room
     */
    public void up(){
        super.up();
        System.out.println("You look up and see stalactites. Nothing interesting");
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down(){
        super.down();
    }
    /*
     * Creates an instance of PuddleRoom
     */
    static PuddleRoom puddleRoom = new PuddleRoom();
}