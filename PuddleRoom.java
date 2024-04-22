/**
 * Represents a room with a puddle and stalactites.
 */
public class PuddleRoom extends Room {
    /** The access card of a cult member in the puddle. */
    private Item accessCard;

    /** The robe of a cult member hanging on a stalactite. */
    private Item cultRobe;

    /**
     * Constructs a new PuddleRoom object.
     */
    public PuddleRoom() {
        initializeItems();
        System.out.println("You are in a room with a puddle and stalactites.");
    }

    /**
     * Initializes the items in the room.
     */
    private void initializeItems() {
        // Initialize the access card item
        accessCard = new Item("Access Card", "An access card of a cult member.");

        // Initialize the cult robe item
        cultRobe = new Item("Cult Robe", "A robe worn by a cult member, hanging on a stalactite.");

        // Add the items to the room's inventory
        addItem(accessCard);
        addItem(cultRobe);
    }

    /**
     * Retrieves the access card from the puddle.
     *
     * @return the access card item
     */
    public Item retrieveAccessCard() {
        // Remove the access card from the room's inventory
        return removeItem(accessCard) ? accessCard : null;
    }

    /**
     * Retrieves the cult robe from the stalactite.
     *
     * @return the cult robe item
     */
    public Item retrieveCultRobe() {
        // Remove the cult robe from the room's inventory
        return removeItem(cultRobe) ? cultRobe : null;
    }
}
