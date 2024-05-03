
/**
 * Represents a generic room in the game world.
 */
public class Room {

    /**
     * Constructs a new Room object.
     */
    public Room() {
    }

    /**
     * Displays a description of the room
     */
    public void look() {
        System.out.println("You are in a room.");
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

    /**
     * Indicates that there is a wall preventing movement in the west direction.
     */
    public void west() {
        System.out.println("You turn west, but you are unable to move forward. There is a wall here.");
    }

    /**
     * Indicates that there is a wall preventing movement in the east direction.
     */
    public void east() {
        System.out.println("You turn east, but you are unable to move forward. There is a wall here.");
    }

    /**
     * Indicates that there is a wall preventing movement in the north direction.
     */
    public void north() {
        System.out.println("You turn north, but you are unable to move forward. There is a wall here.");
    }

    /**
     * Indicates that there is a wall preventing movement in the south direction.
     */
    public void south() {
        System.out.println("You turn south, but you are unable to move forward. There is a wall here.");
    }

    /**
     * Indicates that there is no way to move up from the current room.
     */
    public void up() {
        System.out.println("You look up, but you appear to be in an enclosed cavern. You don't see anywhere to go.");
    }

    /**
     * Indicates that there is no way to move down from the current room.\
     */
    public void down() {
        System.out.println( "You look down, but there is a solid floor below you. There is no way to go down.");
    }
}