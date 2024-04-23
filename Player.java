import java.util.List;

/**
 * Represents the player character in the game.
 */
public class Player {
    /** The health of the player. */
    private int health;

    /** The inventory of the player. */
    private Inventory inventory;

    /**
     * Constructs a new Player object with the specified initial health.
     *
     * @param initialHealth the initial health of the player
     */
    public Player(int initialHealth) {
        this.health = initialHealth;
        this.inventory = new Inventory();
    }

    /**
     * Decreases the player's health by the specified amount.
     *
     * @param amount the amount by which to decrease the player's health
     */
    public void decreaseHealth(int amount) {
        health -= amount;
        if (health <= 0) {
            die();
        }
    }

    /**
     * Returns the current health of the player.
     *
     * @return the current health of the player
     */
    public int getHealth() {
        return health;
    }

    /**
     * Handles the player's death.
     */
    private void die() {
        // Reset the game state, display game over message, etc.
        System.out.println("You have died. Game over.");
        // Additional logic such as resetting the game state or allowing the player to restart
    }

    /**
     * Retrieves the inventory of the player.
     *
     * @return the inventory of the player
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item the item to add
     */
    public void addItemToInventory(Item item) {
        inventory.addItem(item);
    }

    /**
     * Removes an item from the player's inventory.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed, false otherwise
     */
    public boolean removeItemFromInventory(Item item) {
        return inventory.removeItem(item);
    }

    /**
     * Checks if the player's inventory contains a specific item.
     *
     * @param item the item to check
     * @return true if the player's inventory contains the item, false otherwise
     */
    public boolean hasItemInInventory(Item item) {
        return inventory.hasItem(item);
    }

    /**
     * Retrieves the list of items in the player's inventory.
     *
     * @return the list of items in the player's inventory
     */
    public List<Item> getPlayerInventoryItems() {
        return inventory.getItems();
    }
}