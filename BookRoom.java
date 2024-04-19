public class BookRoom extends Room{

    public BookRoom(){
        if(Main.location.containsKey("bookRoom")){
            Main.location.replace("bookRoom", true);
        } else{
            Main.location.put("bookRoom", true);
        }
    }


    static BookRoom bookRoom = new BookRoom();
}
