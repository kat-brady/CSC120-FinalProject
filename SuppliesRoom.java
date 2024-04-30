/**
 * Represents a room with a supplies.
 */
public class SuppliesRoom extends Room{
    /** The salt shaker found in supplies room */
    public static Item salt;
    /** The little box of matches found in supplies room */
    public static Item matches;
    /** The water bottle found in supplies room */
    public static Item bottle;

    /**
     * Constructs a new PuddleRoom object.
     */
    public SuppliesRoom() {
        salt = new Item("salt", "A salt shaker found in supplies room.");
        Main.itemLocation.put(salt, "suppliesRoom");
        matches = new Item("matches", "A little box of matches found in supplies room.");
        Main.itemLocation.put(matches, "suppliesRoom");
        bottle = new Item("bottle", "A water bottle found in supplies room.");
        Main.itemLocation.put(matches, "suppliesRoom");
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
     */
    public void look(){
        System.out.println("You are standing in a dimly lit storage room. Shelves line the walls, filled with assorted jars, bottles, and containers. Reminds you of kitchenette.");
    }

    /*
     * Adjusts west method from parent class Room
     */
    public void west(){

    }

    /*
     * Utilizes east method from parent class Room
     */
    public void east(){
        System.out.println("On the shelves to the east, you spot a small salt shaker and a water bottle nestled between rows of jars. Everything looks dusty.");
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        System.out.println("Looking south, you notice a large stone fireplace. Your eyes land on a weathered box of matches.");
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north(){
        System.out.println("You go north and leave the storage room, ready for what comes next.");
        if (Main.location.contains("surveillanceRoom")){
            Main.location.replace("surveillanceRoom", true);
            Main.location.replace("suppliesRoom", false);
        }else{
            Main.location.put("surveillanceRoom", true);
            Main.location.replace("suppliesRoom", false);
        }
    }

    /*
     * Utilizes up method from parent class Room
     */
    public void up(){
       super.up();
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down(){
        super.down();
    }

    /*
     * Creates an instance of the SuppliesRoom class
     */
    static SuppliesRoom suppliesRoom = new SuppliesRoom();

}
