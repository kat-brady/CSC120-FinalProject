import java.util.*;

/*
 * Represents a room where the player faces the whole cult in a fight
 * Open passages to the north and east, surveillance room to the west, demon room upwards
 */
public class CultRoom extends Room {
    boolean isDefeated = false; // while the cult members have not been defeated, the boolean is false to limit movement
    int cultMembersHealth = 100; // initializes cult members' health
    List<Integer> possibleDamageToCult = Arrays.asList(10, 20, 25, 30, 30, 30, 30, 40, 40, 40, 45, 50, 55, 60); // possible damage the player could deal to the cult
    List<Integer> possibleDamageToPlayer = Arrays.asList(0, 0, 5, 5, 2, 4, 5, 6, 8, 9, 10); // possible damage the cult could deal to the player
    int holyWaterLeft = 3; // the amount of times the player can use holy water
    Random random = new Random();

    /*
     * Constructs CultRoom
     */
    public CultRoom() {
    }

    /*
     * Method to fight the cult members
     * considers isDefeated and Player.player.health to assess viability of fight
     * Randomly selects value from list for damage dealt
     * when cultMemberHealth<=0, isDefeated
     */
    public void attack() {
        String attackMethod = Main.attackMethod;
        if (!isDefeated && Player.player.health > 0) {
            int cultDamage = possibleDamageToCult.get(random.nextInt(possibleDamageToCult.size()));
            int playerDamage = possibleDamageToPlayer.get(random.nextInt(possibleDamageToPlayer.size()));
            if (cultDamage == 0) {
                System.out.println("Your attempt to " + attackMethod + " the cult members misses! Their combined health remains at " + cultMembersHealth + ".");
            } else if (attackMethod.contains("fire")) {
                cultMembersHealth -= cultDamage;
                System.out.println("You cast a searing fireball directly at the cult members, causing them to stagger back as flames engulf them, dealing " + cultDamage + " damage, putting their combined health at " + cultMembersHealth + ". As they deal with the consequences, cult members unleash a noxious gas that seeps into the room, choking the air and making it difficult to breathe for you.");
            } else {
                cultMembersHealth -= cultDamage;
                System.out.println("You attack the cult members, dealing " + cultDamage + " damage. Their combined health is now " + cultMembersHealth + ".");
            }
            if (cultMembersHealth <= 0) {
                isDefeated = true;
                System.out.println("The cult members are weakened! One more blow should finish them off.");
            }
            if (playerDamage == 0) {
                System.out.println("The cult attempts to attack you, but you manage to dodge! Your health remains at " + Player.player.getHealth() + ".");
            } else {
                Player.player.decreaseHealth(playerDamage);
                System.out.println("The cult strikes back, dealing " + playerDamage + " damage! Your health is now " + Player.player.getHealth() + ".");
                if (Player.player.health <= 0) {
                    System.out.println("You sense your consciousness fading...");
                    Player.player.die();
                }
            }
        } else {
            System.out.println("You have defeated the cult and may now proceed.");
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
    public void look() {
        if (!isDefeated) {
            System.out.println("As you look around, you find yourself surrounded by hooded figures, chanting in unison. They notice you and halt their ritual, turning their attention towards you with malice in their eyes. You are confronted by the entire cult, ready to defend their dark practices.");
        } else {
            System.out.println("You survey the room. The cult members lie defeated on the floor, their robes stained with blood. In the corner, you see a ladder leading upwards... something within you beckons you to climb it.");
        }
    }

    /*
     * Adjusts west method from parent class Room
     * Cannot go west if !isDefeated
     */
    public void west() {
        if (!isDefeated) {
            System.out.println("You cannot go west while in the midst of battle!");
        } else {
            System.out.println("You head west, leaving the room.");
            Main.location.replace("cultRoom", false);
            Main.location.replace("surveillanceRoom", true);
        }
    }

    /*
     * Adjusts east method from parent class Room
     * Cannot go east if !isDefeated
     */
    public void east() {
        if (!isDefeated) {
            System.out.println("You cannot leave while the cult threatens you!");
        } else {
            super.east();
        }
    }

    /*
     * Adjusts north method from parent class Room
     * Cannot go north if !isDefeated
     */
    public void north() {
        if (!isDefeated) {
            System.out.println("You cannot escape while the cult surrounds you!");
        } else {
            super.north();
        }
    }

    /*
     * Utilizes south method from parent class Room
     * Cannot go south if !isDefeated
     */
    public void south() {
        if (!isDefeated) {
            System.out.println("Focus on defeating the cult before considering retreat!");
        } else {
            super.south();
        }
    }

    /*
     * Utilizes up method from parent class Room
     */
    public void up() {
        if (!isDefeated) {
            System.out.println("You need to focus on the cult before considering moving upwards.");
        } else {
            System.out.println("You look upwards and see a ladder. After climbing it, you enter a new location...");
            if (Main.location.containsKey("demonRoom")) {
                Main.location.replace("demonRoom", true);
                Main.location.replace("cultRoom", false);
            } else {
                Main.location.put("demonRoom", true);
                Main.location.replace("cultRoom", false);
            }
        }
    }

    /*
     * Utilizes down method from parent class Room
     */
    public void down() {
        if (!isDefeated) {
            System.out.println("You're too occupied with the cult to think about going down.");
        } else {
            super.down();
        }
    }

    /*
     * Initializes an instance of the class
     */
    static CultRoom cultRoom = new CultRoom();
}
