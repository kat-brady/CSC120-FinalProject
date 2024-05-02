
/**
 * Represents the player character in the game.
 */
public class Player {
    /** The health of the player. */
    public int health;

    /**
     * Constructs a new Player object with the specified initial health.
     *
     * @param initialHealth the initial health of the player
     */
    public Player(int initialHealth) {
        this.health = initialHealth;
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
    public boolean die() {
        // Reset the game state, display game over message, etc.
       return true;
        // Additional logic such as resetting the game state or allowing the player to restart
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item the item to add
     */
    public static void addItemToInventory(Item item) {
        Main.inventory.add(item);
        Main.itemLocation.remove(item);
        System.out.println("You have picked up " + item.getName() + ".");
    }

    /**
     * Removes an item from the player's inventory.
     *
     * @param item the item to remove
     */
    public static void removeItemFromInventory(Item item) {
        Main.inventory.remove(item);
        if(Main.location.get("dungeon")==true){
            Main.itemLocation.put(item, "dungeon");
        } else if(Main.location.get("bookRoom")==true){
            Main.itemLocation.put(item, "bookRoom");
        } else if(Main.location.get("puddleRoom")==true){
            Main.itemLocation.put(item, "puddleRoom");
        } else if(Main.location.get("fightRoom")==true){
            Main.itemLocation.put(item, "fightRoom");
        } else if(Main.location.get("rocksRoom")==true){
            Main.itemLocation.put(item, "rocksRoom");
        } else if(Main.location.get("puzzleRoom")==true){
            Main.itemLocation.put(item, "puzzleRoom");
        } else if(Main.location.get("suppliesRoom")==true){
            Main.itemLocation.put(item, "suppliesRoom");
        } else if(Main.location.get("surveillanceRoom")==true){
            Main.itemLocation.put(item, "surveillanceRoom");
        } else if(Main.location.get("cultRoom")==true){
            Main.itemLocation.put(item, "cultRoom");
        } else if(Main.location.get("demonRoom")==true){
            Main.itemLocation.put(item, "demonRoom");
        }
        System.out.println("You have dropped " + item + ".");
    }

    /**
     * Checks if the player's inventory contains a specific item.
     *
     * @param item the item to check
     * @return true if the player's inventory contains the item, false otherwise
     */
    public boolean hasItemInInventory(Item item) {
        return Main.inventory.contains(item);
    }

    static Player player = new Player(300);
}