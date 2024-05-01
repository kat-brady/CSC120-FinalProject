import java.util.*;
/*
 * Main loop to connect all Room classes and run through the game
 */
public class Main {

    public static Hashtable<String, Boolean> location;
    public static Hashtable<Item, String> itemLocation;
    public static ArrayList<Item> inventory;
    public static String attackMethod;


    /*
     * Main body runs the loop
     */
    public static void main(String[] args) {

        location = new Hashtable<String, Boolean>();
        inventory = new ArrayList<Item>();
        itemLocation = new Hashtable<Item, String>();

        boolean stillPlaying = true;

        Scanner userInput = new Scanner(System.in);

        String userResponse = "";

        //brief intro
        location.put("dungeon", true);
        System.out.println("You slowly open your eyes, but everything remains black. Your head is pounding. Where are you?");
        System.out.println("You smell dirt, and come to realize the reason you can't see anything is because there is no light.");
        System.out.println("The last thing you seem to remember is walking your dog... how did you end up here? Are you dead?");
        System.out.println("You're so confused. Maybe you should try to find a way out.");

        /*
         * Loop through while the user is still playing
         */
        do {
            userResponse = userInput.nextLine().toUpperCase(); //responses aren't case sensitive
            if(Player.player.health<=0){
                stillPlaying = false;
            }else if (userResponse.contains("LOOK")){
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.look();
                }else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.look();
                }else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.look();
                }else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.look();
                }else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.look();
                }else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.look();
                }else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.look();
                }else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.look();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.look();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.look();
                }
            }else if(userResponse.contains("PICK UP")||userResponse.contains("GRAB")||userResponse.contains("TAKE")){
                if(userResponse.contains("NOTE")){
                    if(location.containsKey("bookRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(BookRoom.note);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(BookRoom.note);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(BookRoom.note) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(BookRoom.note);
                    }else{
                        System.out.println("There is no note here.");
                    }
                }else if(userResponse.contains("SPEAR")){
                    if(location.containsKey("fightRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(FightRoom.spear);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(FightRoom.spear);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(FightRoom.spear) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(FightRoom.spear);
                    }else{
                        System.out.println("There is no spear here.");
                    }
                }else if(userResponse.contains("CARD")) {
                    if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(PuddleRoom.accessCard);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(PuddleRoom.accessCard) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(PuddleRoom.accessCard);
                    }else{
                        System.out.println("There is no access card here.");
                    }
                }else if(userResponse.contains("ROBE")) {
                    if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(PuddleRoom.cultRobe);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(PuddleRoom.cultRobe) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(PuddleRoom.cultRobe);
                    }else{
                        System.out.println("There is no robe here.");
                    }
                }else if(userResponse.contains("SALT")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(SuppliesRoom.salt);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(SuppliesRoom.salt) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(SuppliesRoom.salt);
                    }else{
                        System.out.println("There is no salt shaker here.");
                    }
                }else if(userResponse.contains("MATCHES")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(SuppliesRoom.matches);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(SuppliesRoom.matches) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(SuppliesRoom.matches);
                    }else{
                        System.out.println("There are no matches here.");
                    }
                }else if(userResponse.contains("BOTTLE")) {
                    if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("bookRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(SuppliesRoom.bottle);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(SuppliesRoom.bottle) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(SuppliesRoom.bottle);
                    }else{
                        System.out.println("There is no bottle here.");
                    }
                }else if(userResponse.contains("CANDLE")){
                    if(location.containsKey("bookRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("bookRoom")){
                        BookRoom.bookRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("suppliesRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("suppliesRoom")){
                        SuppliesRoom.suppliesRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("puddleRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("puddleRoom")){
                        PuddleRoom.puddleRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("fightRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("fightRoom")){
                        FightRoom.fightRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("dungeon")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("dungeon")){
                        Dungeon.dungeon.pickUp(BookRoom.candle);
                    }else if(location.containsKey("rocksRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("rocksRoom")){
                        RocksRoom.rocksRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("puzzleRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("puzzleRoom")){
                        PuzzleRoom.puzzleRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("surveillanceRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("surveillanceRoom")){
                        SurveillanceRoom.surveillanceRoom.pickUp(BookRoom.candle);
                    }else if(location.containsKey("cultRoom")==true && itemLocation.containsKey(BookRoom.candle) && itemLocation.containsValue("cultRoom")){
                        CultRoom.cultRoom.pickUp(BookRoom.candle);
                    }else{
                        System.out.println("There is no candle here.");
                    }
                }else if(userResponse.contains("BOOK")){
                    if(location.containsKey("bookRoom")==true){
                        BookRoom.bookRoom.interact();
                    }else{
                        System.out.println("There is no book here.");
                    }
                }else{
                    System.out.println("You can't pick that up!");
                    }
            }else if(userResponse.contains("DROP")||userResponse.contains("PUT DOWN")||userResponse.contains("LEAVE")){
                if(location.get("dungeon")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        Dungeon.dungeon.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        Dungeon.dungeon.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                       Dungeon.dungeon.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        Dungeon.dungeon.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        Dungeon.dungeon.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        Dungeon.dungeon.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        Dungeon.dungeon.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                       Dungeon.dungeon.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("bookRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        BookRoom.bookRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        BookRoom.bookRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        BookRoom.bookRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        BookRoom.bookRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        BookRoom.bookRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        BookRoom.bookRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        BookRoom.bookRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        BookRoom.bookRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("puddleRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        PuddleRoom.puddleRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        PuddleRoom.puddleRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        PuddleRoom.puddleRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        PuddleRoom.puddleRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        PuddleRoom.puddleRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        PuddleRoom.puddleRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        PuddleRoom.puddleRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        PuddleRoom.puddleRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("fightRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        FightRoom.fightRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        FightRoom.fightRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        FightRoom.fightRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        FightRoom.fightRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        FightRoom.fightRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        FightRoom.fightRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        FightRoom.fightRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        FightRoom.fightRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("rocksRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        RocksRoom.rocksRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        RocksRoom.rocksRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        RocksRoom.rocksRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        RocksRoom.rocksRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        RocksRoom.rocksRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        RocksRoom.rocksRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        RocksRoom.rocksRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        RocksRoom.rocksRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("puzzleRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        PuzzleRoom.puzzleRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        PuzzleRoom.puzzleRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        PuzzleRoom.puzzleRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        PuzzleRoom.puzzleRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        PuzzleRoom.puzzleRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        PuzzleRoom.puzzleRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        PuzzleRoom.puzzleRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        PuzzleRoom.puzzleRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("suppliesRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        SuppliesRoom.suppliesRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        SuppliesRoom.suppliesRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        SuppliesRoom.suppliesRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        SuppliesRoom.suppliesRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        SuppliesRoom.suppliesRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        SuppliesRoom.suppliesRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        SuppliesRoom.suppliesRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        SuppliesRoom.suppliesRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                } else if(location.get("surveillanceRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        SurveillanceRoom.surveillanceRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        SurveillanceRoom.surveillanceRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        SurveillanceRoom.surveillanceRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        SurveillanceRoom.surveillanceRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        SurveillanceRoom.surveillanceRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        SurveillanceRoom.surveillanceRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        SurveillanceRoom.surveillanceRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        SurveillanceRoom.surveillanceRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                }else if(location.get("cultRoom")==true){
                    if(userResponse.contains("NOTE")&& Player.player.hasItemInInventory(BookRoom.note)){
                        CultRoom.cultRoom.drop(BookRoom.note);
                    }else if(userResponse.contains("SPEAR")&& Player.player.hasItemInInventory(FightRoom.spear)){
                        CultRoom.cultRoom.drop(FightRoom.spear);
                    }else if(userResponse.contains("CARD")&& Player.player.hasItemInInventory(PuddleRoom.accessCard)) {
                        CultRoom.cultRoom.drop(PuddleRoom.accessCard);
                    }else if(userResponse.contains("ROBE")&& Player.player.hasItemInInventory(PuddleRoom.cultRobe)) {
                        CultRoom.cultRoom.drop(PuddleRoom.cultRobe);
                    }else if(userResponse.contains("SALT") && Player.player.hasItemInInventory(SuppliesRoom.salt)) {
                        CultRoom.cultRoom.drop(SuppliesRoom.salt);
                    }else if(userResponse.contains("MATCHES") && Player.player.hasItemInInventory(SuppliesRoom.matches)) {
                        CultRoom.cultRoom.drop(SuppliesRoom.matches);
                    }else if(userResponse.contains("BOTTLE") && Player.player.hasItemInInventory(SuppliesRoom.bottle)) {
                        CultRoom.cultRoom.drop(SuppliesRoom.bottle);
                    }else if(userResponse.contains("CANDLE") && Player.player.hasItemInInventory(BookRoom.candle)){
                        CultRoom.cultRoom.drop(BookRoom.candle);
                    }else{
                        System.out.println("You are not able to drop that.");
                        }
                }else if(location.get("demonRoom")==true){
                    System.out.println("You're in the middle of battling a demon here... now is not the time to drop something!");
                }
            }else if (userResponse.contains("WEST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.west();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.west();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.west();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.west();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.west();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.west();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.west();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.west();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.west();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.west();
                }
            }else if (userResponse.contains("EAST")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.east();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.east();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.east();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.east();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.east();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.east();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.east();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.east();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.east();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.east();
                }
            }else if (userResponse.contains("NORTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.north();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.north();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.north();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.north();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.north();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.north();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.north();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.north();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.north();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.north();
                }
            }else if (userResponse.contains("SOUTH")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.south();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.south();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.south();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.south();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.south();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.south();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.south();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.south();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.south();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.south();
                }
            }else if (userResponse.contains("DOWN")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.down();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.down();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.down();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.down();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.down();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.down();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.down();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.down();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.down();
                } else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.down();
                } 
            }else if (userResponse.contains("UP")) {
                if(location.get("dungeon")==true){
                    Dungeon.dungeon.up();
                } else if(location.get("bookRoom")==true){
                    BookRoom.bookRoom.up();
                } else if(location.get("puddleRoom")==true){
                    PuddleRoom.puddleRoom.up();
                } else if(location.get("fightRoom")==true){
                    FightRoom.fightRoom.up();
                } else if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.up();
                } else if(location.get("puzzleRoom")==true){
                    PuzzleRoom.puzzleRoom.up();
                } else if(location.get("suppliesRoom")==true){
                    SuppliesRoom.suppliesRoom.up();
                } else if(location.get("surveillanceRoom")==true){
                    SurveillanceRoom.surveillanceRoom.up();
                }else if(location.get("cultRoom")==true){
                    CultRoom.cultRoom.up();
                }else if(location.get("demonRoom")==true){
                    DemonRoom.demonRoom.up();
                }
            }else if (userResponse.contains("SWIPE")||userResponse.contains("SCAN")){
                if(!location.containsKey("bookRoom")||location.get("bookRoom")==false){
                    System.out.println("There is nothing to " + userResponse.toLowerCase() + " in this room.");    
                }else{
                    BookRoom.bookRoom.swipeCard();
                }
            }else if(userResponse.contains("KICK")||userResponse.contains("PUNCH")||userResponse.contains("FIGHT")||userResponse.contains("TRIP")||userResponse.contains("SLAP")||userResponse.contains("HEAL")){
                attackMethod = userResponse.toLowerCase();
                if(location.containsKey("fightRoom")){
                    if(location.get("fightRoom")==true){
                        if(!attackMethod.equals("heal")){
                        FightRoom.fightRoom.attack();
                        }else{
                            System.out.println("There is nothing for you to heal yourself with.");
                        }
                    }else{
                        System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                    }
                }else if(location.containsKey("demonRoom")){
                    if(location.get("demonRoom")==true){
                        if(attackMethod.equals("kick")||attackMethod.equals("punch")||attackMethod.equals("trip")||attackMethod.equals("slap")){
                            System.out.println("You wouldn't want to fight Javaelith with your bare hands! You should use your supplies.");
                        }else{
                            DemonRoom.demonRoom.attack();
                        }
                    }else{
                        System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                    }
                }else{
                    System.out.println("There is nothing for you to " + userResponse.toLowerCase() + " here.");
                }
            }else if(userResponse.contains("WATCH")){
                if(location.containsKey("surveillanceRoom")){
                    if(location.get("surveillanceRoom")==true){
                        SurveillanceRoom.surveillanceRoom.watch();
                    }else{
                        System.out.println("There is nothing to watch here.");
                    }
                }else{
                    System.out.println("There is nothing to watch here.");
                }
            }else if(userResponse.contains("CLIMB")){
                if(location.get("rocksRoom")==true){
                    RocksRoom.rocksRoom.climbRocks();
                } else{
                    System.out.println("There is nothing to climb here.");
                }
            }else if (userResponse.contains("FILL")){
                if (location.get("puddleRoom")){
                    PuddleRoom.puddleRoom.fillBottle(null);
                } else{
                    System.out.println("You can't fill the bottle here!");
                }
            }else if (userResponse.contains("EXIT") || userResponse.contains("QUIT")) {
                stillPlaying = false;
            }else if(userResponse.contains("HELP")||userResponse.contains("INFO")) {
                System.out.println("You are trapped in a mysterious underground world. Everything feels unsettling and you seem to have lost your memory. How did you get down here? Where are you? How do you get out? All you know is that something is seriously wrong. If you want to escape with your life, you'll need to use your wits to explore and find a way out.");
            }else if(userResponse.contains("INVENTORY")){ 
                for(Item item: inventory){
                    System.out.println(item);
                }if(inventory.isEmpty()){
                    System.out.println("Your inventory is empty.");
                }
            }else{
                System.out.println("You don't think that '" + userResponse.toLowerCase() + "' is going to help you escape, so you do nothing.");
            }
        }while (stillPlaying);

        userInput.close();

        if (userResponse.equals("EXIT")|| userResponse.equals("QUIT")) {
            System.out.println("You have left the game. Shame. Looks like your character will be trapped in that cave forever...");
        } else if(Player.player.die()){
            System.out.println("Everything fades to black...you have died! Maybe, in another life, you'd have been able to escape.");
        }else if(DemonRoom.demonRoom.isDefeated){
            System.out.println("At Javaelith's disappearance, you notice a ladder leading upwards in the corner. You climb it eagerly.\nYou're out of the cave, standing atop a mountain. Ah, fresh air! How you missed this feeling.\nYou're fully convinced that you're traumatized by this experience, but at least you can go home now.");
            System.out.println("You have won! Congratulations, player!");
        }else { 
            System.out.println("An unexpected condition has ended your game...");
        }
    }
}
