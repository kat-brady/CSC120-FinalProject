import java.util.Scanner;

/**
 * A room in the game that contains a puzzle which the player needs to solve.
 */
public class PuzzleRoom extends Room {
    private Scanner scanner;
    private boolean solved;

    /**
     * Constructs a PuzzleRoom with the given description.
     *
     * @param description The description of the room.
     */
    public PuzzleRoom(String description) {
        super(description);
        scanner = new Scanner(System.in);
        solved = false;
    }

    /**
     * Interacts with the puzzle in the room, allowing the player to attempt to solve it.
     */
    public void interact() {
        System.out.println("You enter a room with a mysterious puzzle...");
        System.out.println("You need to solve the puzzle to proceed further.");

        // Present the riddle puzzle to the player
        System.out.println("In whispers hushed, I cast out dread, with prayers and faith, evil I shred. What am I?");
        System.out.print("Your answer: ");
        String playerAnswer = scanner.nextLine().trim().toLowerCase();

        // Check if the player's answer is correct
        if (playerAnswer.equals("exorcism")) {
            System.out.println("Congratulations! You've solved the puzzle.");
            solved = true;
        } else {
            System.out.println("Incorrect answer. Keep exploring the room.");
        }
    }

    /**
     * Checks if the puzzle in the room has been solved.
     *
     * @return true if the puzzle has been solved, false otherwise.
     */
    public boolean isSolved() {
        return solved;
    }
}