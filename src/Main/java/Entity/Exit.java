package Entity;

public class Exit extends Item{
    private Boolean locked = true;
    private Room whichRoom;

    // Constructor for Item.Exit that calls the Item.Item constructor
    public Exit(String name, String description, String floorDescription, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription, "Exit", element); // Pass values to the superclass constructor
        this.whichRoom = null;
    }

    public void setRoom(Room room) {
        this.whichRoom = room;
    }

    // it is possible that player interacts with no other items

    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean lock) {
        this.locked = lock;
    }
    public Room getwhichRoom(){
        return whichRoom;
    }

}
// input boundary methods  by creating private item item, private exit exit
// output boundary