import java.util.ArrayList;
import java.util.List;

/**
 * Represents a generic room in the game world.
 */
public class Room {
    /** The list of items in the room. */
    private List<Item> items;

    /**
     * Constructs a new Room object.
     */
    public Room() {
        items = new ArrayList<>();
    }

    /**
     * Displays a description of the room and lists any items present.
     */
    public void look() {
        System.out.println("You are in a room.");

        if (items.isEmpty()) {
            System.out.println("There are no items in this room.");
        } else {
            System.out.println("You see the following items in this room:");
            for (Item item : items) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    /**
     * Adds an item to the room.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the room.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed, false otherwise
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Indicates that there is a wall preventing movement in the west direction.
     *
     * @return a message indicating the inability to move west
     */
    public String west() {
        return "You turn west, but you are unable to move forward. There is a wall here.";
    }

    /**
     * Indicates that there is a wall preventing movement in the east direction.
     *
     * @return a message indicating the inability to move east
     */
    public String east() {
        return "You turn east, but you are unable to move forward. There is a wall here.";
    }

    /**
     * Indicates that there is a wall preventing movement in the north direction.
     *
     * @return a message indicating the inability to move north
     */
    public String north() {
        return "You turn north, but you are unable to move forward. There is a wall here.";
    }

    /**
     * Indicates that there is a wall preventing movement in the south direction.
     *
     * @return a message indicating the inability to move south
     */
    public String south() {
        return "You turn south, but you are unable to move forward. There is a wall here.";
    }

    /**
     * Indicates that there is no way to move up from the current room.
     *
     * @return a message indicating the inability to move up
     */
    public String up() {
        return "You look up, but you appear to be in an enclosed cavern. You don't see anywhere to go.";
    }

    /**
     * Indicates that there is no way to move down from the current room.
     *
     * @return a message indicating the inability to move down
     */
    public String down() {
        return "You look down, but there is a solid floor below you. There is no way to go down.";
    }
}
