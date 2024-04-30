/**
 * Represents an item in the game world.
 */
public class Item {
    /** The name of the item. */
    public String name;

    /** The description of the item. */
    public String description;

    /**
     * Constructs a new Item object with the specified name and description.
     *
     * @param name the name of the item
     * @param description the description of the item
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }
    /**
     * Overrides the toString() method to return the name and description of the item.
     * 
     * @return the name and description of the item
     */
    @Override
    public String toString() {
        return name + ": " + description;
    }


    
}