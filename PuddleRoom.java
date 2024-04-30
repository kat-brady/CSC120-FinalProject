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
        accessCard = new Item("access card", "An access card of a cult member.");
        Main.itemLocation.put(accessCard, "puddleRoom");
        cultRobe = new Item("cult robe", "A robe worn by a cult member, found hanging on a stalactite.");
        Main.itemLocation.put(cultRobe, "puddleRoom");
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){ 
        System.out.println("You look around and find yourself surrounded by stalactites. You realize you are in a cave.");
    }

    /*
     * Adjusts west method from parent class Room
     */
    public void west() {
        System.out.println("You turn west and leave the room.");
        Main.location.replace("puddleRoom", false);
        Main.location.replace("bookRoom", true);
    }

    /*
     * Utilizes east method from parent class Room
     */
    public void east(){
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
        System.out.println("You turn south on notice a piece of robe hanging on one of the stalactites. It reminds you of cults...");
    }

    /*
     * Utilizes up method from parent class Room
     */
    public void up(){
        System.out.println("You look up and see stalactites. Nothing interesting");
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down(){
        super.down();
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
     * Creates an instance of PuddleRoom
     */
    static PuddleRoom puddleRoom = new PuddleRoom();
}