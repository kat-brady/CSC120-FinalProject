import java.util.*;
/*
 * Represents a room where cult members will fight the player
 * Open passage to the north and east
 * surveillanceRoom to west, demonRoom up
 */
public class CultRoom extends Room{
    boolean isDefeated = false; //while the cult membes have not been defeated, the boolean is false to limit movement
    int cultMembersHealth = 100; //initializes cult members' health
    List<Integer> possibleHolyEffect = Arrays.asList(10, 20, 25, 30, 30, 30, 30, 40, 40, 40, 45, 50, 55, 60);//possible holy water effect
    List<Integer> possibleDamageToFoe = Arrays.asList(0, 0, 20, 20, 20, 20, 15, 5, 5, 5, 10, 30, 23, 26); //possible damage you could deal
    List<Integer> possibleDamageToPlayer = Arrays.asList(0, 0, 5, 5, 2, 4, 5, 6, 8, 9, 10); //possible damage they could deal
    int holyWaterLeft = 3;//the amount of times you can use holy water
    Random random = new Random();

    /*
     * Constructs FightRoom
     */
    public CultRoom(){
    }

    /*
     * Method to fight the cult members
     * considers isDefeated and Player.player.health to assess viability of fight
     * Randomly selects value from list for damage dealt
     * when cultMemberHealth<=0, isDefeated
     */
    public void attack(){
        String attackMethod = Main.attackMethod;
        if(!isDefeated && Player.player.health>0){
            int foeDamage = possibleDamageToFoe.get(random.nextInt(possibleDamageToFoe.size()));
            int playerDamage = possibleDamageToPlayer.get(random.nextInt(possibleDamageToPlayer.size()));
            int holyEffect = possibleHolyEffect.get(random.nextInt(possibleHolyEffect.size()));
            if(foeDamage==0){
                System.out.println("You attempt to " + attackMethod + " your opponent, but you miss! Their health remains at " + cultMembersHealth + ".");
            }else if(attackMethod.equals("kick")){
                cultMembersHealth-=foeDamage;
                System.out.println("You deliver a swift kick to the cult member's shin! They take " + foeDamage + " damage, putting their health at " + cultMembersHealth + ".");
            }else if(attackMethod.equals("punch")||attackMethod.equals("slap")){
                cultMembersHealth-=foeDamage;
                System.out.println("You " + attackMethod + " the figure's concealed face! Their robe moves ever so slightly to reveal a sliver of sickly pale skin, but they quickly cover it again. They take " + foeDamage + " damage, putting their health at " + cultMembersHealth + ".");
            }else if (attackMethod.equals("fight")){
                cultMembersHealth-= foeDamage;
                System.out.println("You square up with your adversary, dealing a few blows worth " + foeDamage + " damage. Their health is now " + cultMembersHealth);
            }else if(attackMethod.equals("trip")){
                cultMembersHealth-=foeDamage;
                System.out.println("You sweep your opponent's legs, causing them to fall straight down. They take " + foeDamage + " damage. Their robe moves slightly, causing you see the bottom of their legs. Are those... hooves?? They quickly get back up, now having a health of " + cultMembersHealth + ".");
            }else if(attackMethod.equals("fire")){
                cultMembersHealth-=foeDamage;
                System.out.println("You cast a searing fireball directly at the group of cult members, causing them to stagger back as flames engulf them, dealing them " + foeDamage + " damage, putting their health at " + cultMembersHealth + ". As they deal with consequences, cult members unleash a noxious gas that seeps into the room, choking the air and making it difficult to breathe for you.");
            }else if (attackMethod.contains("holy water") && attackMethod.contains("heal") && holyWaterLeft>0 && Player.player.hasItemInInventory(SuppliesRoom.bottle) && PuddleRoom.puddleRoom.filledBottle){
                if(holyWaterLeft>=1){
                Player.player.health+=holyEffect;
                holyWaterLeft-=1;
                System.out.println("You take a swig of the holy water. You feel your body recovering as you gain back " + holyEffect + " health. Your health is now " + Player.player.health + ". It seems like there are about " + holyWaterLeft + " splash(es) of water left in the bottle.");
                }else{
                    System.out.println("No holy water left anymore!");
                }
            }if(cultMembersHealth<=0){
                isDefeated = true;
                System.out.println("They're weak now! One more blow should finish them off.");
            }if(playerDamage==0){
                System.out.println("The opponent attempts to attack you, but you dodge! Your health remains at " + Player.player.getHealth() + ".");
            }else{
                Player.player.decreaseHealth(playerDamage);
                System.out.println("The mysterious figure delivers a sharp blow, dealing " + playerDamage + " damage! Your health is now " + Player.player.getHealth() + ".");
                if(Player.player.health<=0){
                    System.out.println("Uh oh... you get the sense your consciousness is fading.");
                    Player.player.die();
                }    
            }
        }else{
            System.out.println("The mysterious figure falls to the ground, knocked out. You have won! You notice a long spear fall out of their cloak.");
        }
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
     * Adjusts look method from parent class Room
     */
    public void look(){
        if (!isDefeated) {
            System.out.println("You start to look around, but find yourself interrupted by an angry voice.\n'Hey, you! How did you get out?!' the voice yells. You look in the direction of the voice and see a mysterious figure, wearing a velvety, dark red robe.\nThe robe conceals their face and extends to the floor, so that you cannot see any of their skin. There's no telling if your adversary is human or not.\nThey move closer to you. It's clear that you're going to have to fight if you don't want to end up back in the dungeon.");
        }else{
            System.out.println("You look around. The room is mostly barren. To the east, a door remains open. It looks like there may be a passage to the north.\nOn the ground, the mysterious figure lies unconscious. You'd better not spend too much time here. Wouldn't want to wake them.");
        }
        
    }

    /*
     * Adjusts west method from parent class Room
     * Cannot go west if !isDefeated
     */
    public void west() {
        if(!isDefeated){
            System.out.println("You can't try going west- you're in the middle of a fight!");
        }else{
            System.out.println("You do west and leave the room.");
            Main.location.replace("cultRoom", false);
            Main.location.replace("surveillanceRoom", true);
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
            super.east();
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
            super.north();
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
        if(!isDefeated){
            System.out.println("Keep your eyes on the opponent!");
        }else{
            System.out.println("You look upwards and see a ladder. After you climbed it, you entered new location...");
            if (Main.location.containsKey("demonRoom")){
                Main.location.replace("demonRoom", true);
                Main.location.replace("cultRoom", false);
            }else{
                Main.location.put("demonRoom", true);
                Main.location.replace("cultRoom", false);
            }
        }
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down(){
        if(!isDefeated){
            System.out.println("You'd love to look down, but you really need to focus on the enemy.");
        }else{
            super.down();
        }
    }

    /*
     * Initializes an instance of the class
     */
    static CultRoom cultRoom = new CultRoom();
}
