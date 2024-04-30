/*
 * Represents a room where the summoned demon is being held
 * The player must fight the demon and win to win the game
 * Entrance below, but the player cannot exit that way, since this is the last room in the game
 *
 */
public class DemonRoom extends Room{
    
    public DemonRoom(){
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
     * Modifies look method from parent class Room
     */
    public void look() {
    }

    /**
     * Utilizes west method from parent class Room
     */
    public void west() {
        super.west();
    }

    /**
     * Utilizes east method from Parent class Room
     */
    public void east() {
        super.east();
    }

    /**
     * Utilizes north method from parent class Room
     */
    public void north() {
        super.north();
    }

    /**
     * Utilizes south method from parent class Room
     */
    public void south() {
        super.south();
    }

    /**
     * Utilizes up method from parent class Room
     */
    public void up() {
        super.up();
    }

    /**
     * Modifies down method from parent class Room
     */
    public void down() {
        
    }



    static DemonRoom demonRoom = new DemonRoom();
}
