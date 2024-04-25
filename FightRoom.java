import java.util.*;
/*
 * Represents a room where a lone cult member will fight the player
 * Open passage to the north and east
 * booksRoom to east, rocksRoom to north
 */
public class FightRoom extends Room{

    boolean isDefeated = false; //while the cult member has not been defeated, the boolean is false to limit movement
    int cultMemberHealth = 100;
    List<Integer> possibleDamageToFoe = Arrays.asList(1, 10, 10, 10, 10, 11, 12, 15, 5, 5, 18, 19, 20, 23, 26);
    List<Integer> possibleDamageToPlayer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 12, 14, 15);
    Random random = new Random();
    int foeDamage = possibleDamageToFoe.get(random.nextInt(possibleDamageToFoe.size()));
    int playerDamage = possibleDamageToPlayer.get(random.nextInt(possibleDamageToPlayer.size()));

    public FightRoom(){
    }


    /*
     * Method to fight the cult member
     */
    public void attack(){
        String attackMethod = Main.attackMethod;
        while(!isDefeated){
            if(foeDamage==0){
                System.out.println("You attempt to " + attackMethod + " your opponent, but you miss! Their health remains at " + cultMemberHealth + ".");
            }else if(attackMethod.equals("kick")){
                cultMemberHealth-=foeDamage;
                System.out.println("You deliver a swift kick to the cult member's shin! They take " + foeDamage + " damage, putting their health at " + cultMemberHealth + ".");
            }else if(attackMethod.equals("punch")||attackMethod.equals("slap")){
                cultMemberHealth-=foeDamage;
                System.out.println("You " + attackMethod + " the figure's concealed face! Their robe moves ever so slightly to reveal a sliver of sickly pale skin, but they quickly cover it again. They take " + foeDamage + " damage, putting their health at " + cultMemberHealth + ".");
            }else if (attackMethod.equals("fight")){
                cultMemberHealth-= foeDamage;
                System.out.println("You square up with your adversary, dealing a few blows worth " + foeDamage + " damage. Their health is now " + cultMemberHealth);
            }else if(attackMethod.equals("trip")){
                cultMemberHealth-=foeDamage;
                System.out.println("You sweep your opponent's legs, causing them to fall straight down. They take " + foeDamage + " damage. Their robe moves slightly, causing you see the bottom of their legs. Are those... hooves?? They quickly get back up");
            }if(cultMemberHealth==0){
                isDefeated = true;
         }
     }
    }


    /*
     * Adjusts look method from parent class Room
     */
    public void look(){
        super.look();
        System.out.println("You start to look around, but find yourself interrupted by an angry voice.\n'Hey, you! How did you get out?!' the voice yells. You look in the direction of the voice and see a mysterious figure, wearing a velvety, dark red robe.\nThe robe conceals their face and extends to the floor, so that you cannot see any of their skin. There's no telling if your adversary is human or not.\nThey move closer to you. It's clear that you're going to have to fight if you don't want to end up back in the dungeon.");
    }

    /*
     * Adjusts west method from parent class Room
     * Cannot go west if !isDefeated
     */
    public void west() {
        if(!isDefeated){
            System.out.println("You can't try going west- you're in the middle of a fight!");
        }else{
            super.south();
        }
    }

    /*
     * Adjusts east method from parent class Room
     * Cannot go east if !isDefeated
     * East leads to BookRoom
     */
    public void east(){
        if(!isDefeated){
            System.out.println("You should focus on your opponent, not try escaping!");
        }else{
            Main.location.replace("fightRoom", false);
            Main.location.replace("bookRoom",true);
            System.out.println("You pass through the door to the east, which remains unlocked.");
        }
    }

    /*
     * Adjusts north method from parent class Room
     * Cannot go north if !isDefeated
     * If isDefeated, go to rocksRoom
     */
    public void north() {
        if(!isDefeated){
            System.out.println("You can't escape, you need to fight for your own safety!");
        }else{
            if (Main.location.contains("rocksRoom")){
                Main.location.replace("rocksRoom", true);
                Main.location.replace("fightRoom", false);
            }else{
                Main.location.put("rocksRoom", true);
                Main.location.replace("fightRoom", false);
            }
            System.out.println("You pass through the entry to the north.");
        }
    }

    /*
     * Utilizes south method from parent class Room
     * Cannot go south if !isDefeated
     */
    public void south(){
        if(!isDefeated){
            System.out.println("Focus on your adversary first!");
        }else{
            super.south();
        }
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
    }

    static FightRoom fightRoom = new FightRoom();
}
