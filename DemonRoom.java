import java.util.*;
/*
 * Represents a room where the summoned demon is being held
 * The player must fight the demon and win to win the game
 * Entrance below, but the player cannot exit that way, since this is the last room in the game
 * booleans sawIntro and isDefeated check if player already read the intro text and if they have defeated Javaelith, respectively
 * Javaelith's health is set to 200 initially
 * Multiple lists of integers are initialized to store the possible values(damage or healing) that will be randomly selected from during each move of the fight
 * int saltLeft and int holyWaterLeft store how much salt/water remains
 * Random random is created to use randomization
 */
public class DemonRoom extends Room{
    boolean sawIntro = false;
    boolean isDefeated = false;
    int javaelithHealth = 200;
    List<Integer> possibleSaltDamage = Arrays.asList(20, 20, 20, 20, 20, 25, 26, 27, 30, 35, 35, 35, 36, 37, 40, 50);
    List<Integer> possibleHolyEffect = Arrays.asList(10, 20, 25, 30, 30, 30, 30, 40, 40, 40, 45, 50, 55, 60);
    List<Integer> possibleSpearDamage = Arrays.asList(0, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
    List<Integer> possibleCandleDamage = Arrays.asList(10, 12, 13, 20, 30, 40, 50);
    List<Integer> possibleFireDamage = Arrays.asList(10, 13, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);
    List<Integer> possibleDamageToPlayer = Arrays.asList(0, 10, 11, 12, 13, 14, 15, 16, 20, 21, 22, 23, 24);
    int saltLeft = 2;
    int holyWaterLeft = 3;
    Random random = new Random();
    public DemonRoom(){
    }

    /*
     * Method to fight Javaelith
     * considers isDefeated and Player.player.health to assess viability of fight
     * Randomly selects value from one of the list for damage dealt or for health recovered
     * when javaelithHealth<=0, isDefeated
     */
    public void attack(){
        String attackMethod = Main.attackMethod;
        if(!isDefeated && Player.player.health>0){
            int fireDamage = possibleFireDamage.get(random.nextInt(possibleFireDamage.size()));
            int holyEffect = possibleHolyEffect.get(random.nextInt(possibleHolyEffect.size()));
            int spearDamage = possibleSpearDamage.get(random.nextInt(possibleSpearDamage.size()));
            int saltDamage = possibleSaltDamage.get(random.nextInt(possibleSaltDamage.size()));
            int playerDamage = possibleDamageToPlayer.get(random.nextInt(possibleDamageToPlayer.size()));
            int candleDamage = possibleCandleDamage.get(random.nextInt(possibleCandleDamage.size()));
            if(attackMethod.contains("spear")){
                if(spearDamage==0){
                    System.out.println("You throw your spear towards Javaelith, but you miss! Its health remains at " + javaelithHealth + " and you scramble to retrieve your spear.");
                }
                else{
                    javaelithHealth-=spearDamage;
                    System.out.println("You throw your spear towards Javaelith, stabbing one of its many eyes. It shrieks in pain, taking " + spearDamage + " damage, leaving it with "+ javaelithHealth + " health. It pulls out the spear, chucking it aside. You run and grab it again.");
                }
            }else if(attackMethod.contains("salt")){
                if(saltLeft>0 && Player.player.hasItemInInventory(SuppliesRoom.salt)){
                    javaelithHealth-=saltDamage;
                    System.out.println("You pull out the salt shaker and pour a bit of salt into your hand. There is about " + saltLeft + " handful(s) of salt left in the shaker now. You take your handful of salt and throw it into Javaelith's eyes. It roars angrily, appearing to be burning! It takes " + saltDamage + " damage, now having " + javaelithHealth + " health.");
                }else if(Player.player.hasItemInInventory(SuppliesRoom.salt) && saltLeft==0){
                    javaelithHealth-=5;
                    System.out.println("You retrieve the salt shaker to attack Javaelith, but it is empty! You throw the empty salt shaker at Javaelith instead, dealing a mere 5 damage. Javaelith seems to laugh at your pitiful attack! It now has " + javaelithHealth + " health, and your salt shaker shatters.");
                    Player.removeItemFromInventory(SuppliesRoom.salt);
                }else if(!Player.player.hasItemInInventory(SuppliesRoom.salt)){
                    System.out.println("You're out of salt, and the empty shaker is shattered, lying in pieces on the floor. You can't attack Javaelith with salt anymore. Its health remains at " + javaelithHealth + ".");
                }
            }else if(attackMethod.contains("fire")){
                javaelithHealth-=fireDamage;
                System.out.println("You cast a fireball towards Javaelith! The flames engulf the beast, dealing " + fireDamage + " damage. It growls and stomps its feet at you. It now has " + javaelithHealth + " health.");
            }else if (attackMethod.contains("holy water") && attackMethod.contains("heal") && holyWaterLeft>0 && Player.player.hasItemInInventory(SuppliesRoom.bottle) && PuddleRoom.puddleRoom.filledBottle){
                Player.player.health+=holyEffect;
                holyWaterLeft-=1;
                System.out.println("You take a swig of the holy water. You feel your body recovering as you gain back " + holyEffect + " health. Your health is now " + Player.player.health + ". It seems like there are about " + holyWaterLeft + " splash(es) of water left in the bottle.");
            }else if(attackMethod.contains("holy water") && !attackMethod.contains("heal") && holyWaterLeft>0 && Player.player.hasItemInInventory(SuppliesRoom.bottle) && PuddleRoom.puddleRoom.filledBottle){
                javaelithHealth-=holyEffect;
                holyWaterLeft-=1;
                System.out.println("You splash some holy water on Javaelith! The water seems to burn it. It screeches and writhes in pain, taking " + holyEffect + " damage. Its health is now " + javaelithHealth + " and there appear to be " + holyWaterLeft + " splash(es) of water left in the bottle.");
            }else if(attackMethod.contains("holy water")&& !attackMethod.contains("heal") && Player.player.hasItemInInventory(SuppliesRoom.bottle) && (holyWaterLeft==0 || !PuddleRoom.puddleRoom.filledBottle)){
                javaelithHealth-=5;
                Player.removeItemFromInventory(SuppliesRoom.bottle);
                System.out.println("You attempt to throw holy water on Javaelith, but your bottle is empty! Instead, you throw the bottle at it. It swallows the bottle whole, taking 5 damage due to the discomfort. Its health is now " + javaelithHealth + " and you no longer have a bottle.");
            }else if(attackMethod.contains("candle") && attackMethod.contains("light") && Player.player.hasItemInInventory(BookRoom.candle) && Player.player.hasItemInInventory(SuppliesRoom.matches)){
                javaelithHealth-=candleDamage;
                Player.removeItemFromInventory(SuppliesRoom.matches);
                Player.removeItemFromInventory(BookRoom.candle);
                System.out.println("You use the matches you found earlier to light the candle you have been carrying around. As it is lit, you hear a strange, shrill whistling noise.\nIt appears as if the candle sucked some of Javaelith's essence out of it! It takes " + candleDamage + " damge, leaving its health at " + javaelithHealth + ". You no longer have the candle or matches.");
            }else{
                System.out.println("You cannot attack Javaelith like that! It won't work!");
            }if(javaelithHealth<=0){
                isDefeated = true;
                System.out.println("It's weak now! One more blow should finish it off.");
            }if(playerDamage==0){
                System.out.println("Javaelith attempts to attack you, but you dodge! Your health remains at " + Player.player.getHealth() + ".");
            }else{
                Player.player.decreaseHealth(playerDamage);
                System.out.println("Javaelith roars, releasing a magical orb from its jaws. The orb burns you, dealing " + playerDamage + " damage! Your health is now " + Player.player.getHealth() + ".");
                if(Player.player.health<=0){
                    System.out.println("Uh oh... you get the sense your consciousness is fading.");
                    Player.player.die();
                }    
            }
        }else{
            System.out.println("At your final blow, Javaelith disappears in a puff of smoke, leaving behind the smell of burnt flesh and sulfur. You did it! You have banished Javaelith back to its realm!");
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
     * Modifies look method from parent class Room
     * boolean sawIntro allows the player to see a different text depending on if they already read the intro text
     */
    public void look() {
        if(!sawIntro){
            sawIntro=true;
            System.out.println("You look around, wide-eyed and fearful. Before you stands the creature to whom your captors have seemingly dedicated their entire lives.\nJavaelith is larger than any creature you have ever seen before, appearing to be larger than your house. It is a deep, crimson color with too many glowing yellow eyes to count. It appears to be staring deep into your soul. Its many limbs end in sharp, pointy claws.\nIt opens its massive jaw, revealing dozens of sharpened teeth. It lets out a deep, angry roar. You have no choice but to battle, or you know you'll be Javaelith's next victim.");
        }else{
            System.out.println("The only thing for you to look at here is Javaelith. Speaking of, you need to focus.");
        }
    }

    /*
     * Modifies method from parent class Room
     */
    public void west() {
        System.out.println("There is no point in trying to go west. Javaelith will just follow you there.");
    }

    /*
     * Modifies east method from Parent class Room
     */
    public void east() {
        System.out.println("There is no point in trying to go east. Javaelith will just follow you there.");
    }

    /*
     * Modifies north method from parent class Room
     */
    public void north() {
        System.out.println("There is no point in trying to go north. Javaelith will just follow you there.");
    }

    /*
     * Modifies south method from parent class Room
     */
    public void south() {
        System.out.println("There is no point in trying to go south. Javaelith will just follow you there.");
    }

    /*
     * Modifies up method from parent class Room
     */
    public void up() {
        System.out.println("There is no point in trying to go up. Javaelith will just follow you there.");
    }

    /*
     * Modifies down method from parent class Room
     */
    public void down() {
        System.out.println("Although you entered from below, there is now a locked trapdoor preventing your escape. If you want out of this, you'll have to defeat Javaelith.");
    }



    static DemonRoom demonRoom = new DemonRoom();
}
