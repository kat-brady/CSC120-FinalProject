
public class Room {

    
    public Room(){
       
    }
    public void look(){
        System.out.println("You are in a room. Nothing interesting to report.");
    }

    public String west(){
        System.out.println("You turn west, but you are unable to move forward. There is a wall here.");
        return west();
    }

    public String east(){
        System.out.println("You turn east, but you are unable to move forward. There is a wall here.");
        return east();
    }

    public String north(){
        System.out.println("You turn north, but you are unable to move forward. There is a wall here.");
        return north();
    }

    public String south(){
        System.out.println("You turn south, but you are unable to move forward. There is a wall here.");
        return south();
    }

    public String up(){
        System.out.println("You look up, but you appear to be in an enclosed cavern. You don't see anywhere to go.");
        return up();
    }

    public String down(){
        System.out.println("You look down, but there is a solid floor below you. There is no way to go down.");
        return down(); 
    }
}
