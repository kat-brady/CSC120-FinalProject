import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player's inventory.
 */
public class Inventory {
    /** The list of items in the inventory. */
    private List<Item> items;

    /**
     * Constructs a new Inventory object.
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed, false otherwise
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Checks if the inventory contains a specific item.
     *
     * @param item the item to check
     * @return true if the inventory contains the item, false otherwise
     */
    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    /**
     * Retrieves the list of items in the inventory.
     *
     * @return the list of items in the inventory
     */
    public List<Item> getItems() {
        return items;
    }
}
