
public class Dungeon extends Room {

    public Dungeon(){
        if(Main.location.containsKey("dungeon")){
            Main.location.replace("dungeon", true);
        } else{
            Main.location.put("dungeon", true);
        }
    }

    public void look(){
        System.out.println("You look around, but you can't go anywhere. You appear to be in some kind of dungeon. Maybe if you feel your surroundings, you can find a way out.");
    }

    public String west() {
        String description = super.west();
        description += " It feels like you're in some kind of dirt pit.";
        System.out.println(description);
        return west();
    }

    public String east() {
        String description = super.east();
        description += " Maybe you should look elsewhere";
        System.out.println(description);
        return east();
    }

    public String north() {
        String description = super.north();
        description +=" You see there are vines growing down from above. You wonder what may be up there...";
        System.out.println(description);
        return north();
    }

    public String south() {
        super.south();
        return south();
    }

    public String up(){
        System.out.println("You gaze upwards, feeling blindly in the darkness. Wait... is that a ladder?\n You climb the ladder, going upwards into a dimly lit room.");
        Main.location.replace("dungeon", false);
        return up();
    }

    public String down(){
        super.down();
        return down();
    }
    
    static Dungeon dungeon = new Dungeon();

}
