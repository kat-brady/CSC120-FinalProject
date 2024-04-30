/**
 * Represents a room with climbable rocks in the game world.
 */
public class RocksRoom extends Room {
    private boolean climbedRocks;
    public Item skull;
    private boolean turnednorth;


    /**
     * Constructs a new RocksRoom object.
     */
    public RocksRoom() {
        climbedRocks = false;
        turnednorth = false;
    }

    /**
     * Handles the player's attempt to climb the rocks.
     */
    public void climbRocks() {
        if (!turnednorth) {
            System.out.println("There are no rocks to climb here.");
            return;
        }

        while (!climbedRocks) {
            System.out.println("You attempt to climb the rocks...");
            boolean success = false;

            // Keep attempting to climb until successful
            while (!success) {
                // Simulate climbing action
                if (Math.random() < 0.5) { // 50% chance of success
                    System.out.println("You successfully climb the rocks and reach the ledge!");
                    climbedRocks = true;
                    success = true;
                    if (Main.location.contains("puzzleRoom")){
                        Main.location.replace("puzzleRoom", true);
                        Main.location.replace("rocksRoom", false);
                    }else{
                        Main.location.put("puzzleRoom", true);
                        Main.location.replace("rocksRoom", false);
                    }
                } else {
                    System.out.println("You struggle to find a secure grip on the rocks and slip back down.");
                    System.out.println("You decide to try again...");
                }
            }
        }

    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        System.out.println("You look around and find yourself in a big dark room");
    }

    /*
     * Adjusts west method from parent class Room
     */
    public void west() {
        super.west();
    }

    /*
     * Utilizes east method from parent class Room
     */
    public void east(){
        super.east();
        System.out.println("You turn east and see a creepy skull on the floor. Hopefully, you won't need it.");
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north() {
        super.north();
        turnednorth = true;
        System.out.println("You turn north and see large rocks stretched upwards. Maybe they lead somewhere...");
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        super.south();
        System.out.println("You turn south and see a big entrance. You enter the room with the defeated cult member.");
        Main.location.replace("rocksRoom",false);
        Main.location.replace("fightRoom", true);
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
     * Creates an instance of the RocksRoom class for the rocks room
     */
    static RocksRoom rocksRoom = new RocksRoom();

}
