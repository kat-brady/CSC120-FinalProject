import java.util.Scanner;

/**
 * A room in the game that contains a puzzle which the player needs to solve.
 */
public class PuzzleRoom extends Room {
    private Scanner scanner;
    private boolean solved;

    /**
     * Constructs a PuzzleRoom with the given description.
     */
    public PuzzleRoom() {
        scanner = new Scanner(System.in);
        solved = false;
    }

    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look(); 
        System.out.println("You look around the room with the air charged with mystery, and the dim torchlight casts eerie shadows on the ancient stone walls");
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
        System.out.println("You turn east and see a large, ornate pedestal.");
        System.out.println("A voice echoes through the chamber, enigmatic and cryptic.");
        interact();
    }

    /*
     * Adjusts north method from parent class Room
     */
    public void north() {
        super.north();
    }

    /*
     * Utilizes south method from parent class Room
     */
    public void south(){
        super.south();
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
        System.out.println("You go down and leave the room");
        Main.location.replace("puzzleroom", false);
        Main.location.replace("rocksroom", true);
    }

    
    /**
     * Interacts with the puzzle in the room, allowing the player to attempt to solve it.
     */
    public void interact() {

        // Present the riddle puzzle to the player
        System.out.println("In whispers hushed, I cast out dread, with prayers and faith, evil I shred. What am I?");
        while(!solved){
            System.out.print("Your answer: ");
            String playerAnswer = scanner.nextLine().trim().toLowerCase();

            // Check if the player's answer is correct
            if (playerAnswer.equals("exorcism")) {
                System.out.println("Congratulations! You've solved the puzzle. You may now proceed.");
                solved = true;
                Main.location.replace("puzzleroom", false);
                Main.location.replace("suppliesroom", true);
            } else {
                System.out.println("Incorrect answer. Try again.");
        }
    }
    }
    /*
     * Creates an instance of the PuzzleRoom class
     */
    static PuzzleRoom puzzleroom = new PuzzleRoom();

}