/*
 * Represents a room where the player will encounter footage taken of them
 * Open passage to the south and to the east
 * SuppliesRoom to the south, CultRoom to the east
 */
public class SurveillanceRoom extends Room{
    int watches = 3; //sets the number of scenes the player will be able to watch

    public SurveillanceRoom(){
    }

    /*
     * Modifies look method from parent class Room
     */
    public void look() {
        if(watches>=1){
            System.out.println("You look around in astonishment. You're pretty sure you must be underground somewhere, but it looks like you're in some kind of high tech office!\nAll around you are massive screens, some displaying live feed, while others appear to be showing recordings. Nobody is in here right now.\nMaybe you should try to watch some of them for information.");
        }else{
            System.out.println("You look around and see that all of the many screens surrounding you are completely blank. The power is off... maybe you should move on.");
        }
        
    }

    /*
     * Method that allows the player to "watch" the surveillance camera and gain intel
     * Shows different scenes depending on what the player has seen before
     */
    public void watch(){
        if(watches==3){
            System.out.println("You turn your attention toward the main screen in the room. It is a desktop monitor, coated with a thin layer of dust.\nIt appears to be showing a live feed of the side of a mountain. Or, at least, you think it's a live feed. The date in the corner reads 'October 6th, 2013', but you could've sworn it was August just yesterday... Odd. You don't see anything in frame that isn't natural... wait!\nYou watch closely as a hooded figure, dressed just like the one you beat up earlier, appears! Did they just come from inside the mountain???\nThere must be some kind of opening out of frame somewhere. Your eyes follow the figure as they move out of frame. This mountain must have some connection to where you are now, you think. But what?");
            watches-=1;
        }else if(watches==2){
            System.out.println("You focus on a small screen to your right. It appears to be some kind of recording.\nYou see an old, gray-haired man speaking directly to the camera. The sound is turned off, so you can't hear what he is saying.\nSuddenly, the camera shift to a very dark room. You can barely make out what is in the shot, but it appears to be some kind of metallic cage or box.\nFor a brief moment, the flash of the recording camera is turned on, allowing you to catch a glimpse of a massive, hideous beast within the cage.\nBefore you can wrap your head around what you are seeing, the flash is shut off again. The recording comes to an end there, leaving you scared and confused.");
            watches-=1;
        }else if(watches==1){
            System.out.println("Your eyes are drawn to a third screen just above the main one. In the recording, you see a small figure walking through the forest. 'Hey, that person has the same haircut as me!' you think to yourself.\nYou watch them walk for a bit, until suddenly a net falls from a tree, landing directly on them! They struggle to try to escape.\nIn their attempt to escape, you see flames come from their hand... but how? 'They must have matches', you think. 'Magic isn't real'.\nEven fire can't free them from the net, and they slump down, defeated. You watch as a hooded figure approaches them, appearing to poke their arm with something. The camera zooms in.\nOnly then does your blood run cold. The person in the video... it's you.\nHow long ago did they abduct you? What was that fire trick you did with your hand? Your head is spinning.");
            watches-=1;
        }else{
            System.out.println("You would love to watch more, but you suddenly hear the screens shut down. The power in the room has gone out. But how?\nIs it possible that someone knows you're here and cut the power? You feel a deep sense of dread.");
        }
    }

    /**
     * Utilizes west method from parent class Room
     */
    public void west() {
        super.west();
    }

    /**
     * Modifies east method from parent class Room to allow travel into CultRoom
     */
    public void east() {
        System.out.println("To the east, there is a door. Unlike the one from earlier, it doesn't appear to have a scanner on it.\nYou try the handle, and the door creaks open. You pass through into a mysterious, dark room.");
        Main.location.replace("surveillanceRoom", false);
        if(Main.location.containsKey("cultRoom")){
            Main.location.replace("cultRoom", true);
        } else{
            Main.location.put("cultRoom", true);
        }
    }

    /**
     * Utilizes north method from parent class Room
     */
    public void north() {
        super.north();
    }

    /**
     * Modifies south method from parent class Room to allow player to move into SuppliesRoom
     */
    public void south() {
        System.out.println("To the south, there is an opening leading into another furnished room. You pass through easily.");
        Main.location.replace("surveillanceRoom", false);
        if(Main.location.containsKey("suppliesRoom")){
            Main.location.replace("suppliesRoom", true);
        } else{
            Main.location.put("suppliesRoom", true);
        }
    }

    /**
     * Utilizes up method from parent class Room
     */
    public void up() {
        super.up();
    }

    /**
     * Utilizes down method from parent class Room
     */
    public void down() {
        super.down();
    }

    static SurveillanceRoom surveillanceRoom = new SurveillanceRoom();
}

