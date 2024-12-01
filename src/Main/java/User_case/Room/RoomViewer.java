package java.User_case.Room;

import java.Entity.Room;

public class RoomViewer {
    private Room room;

    public RoomViewer(Room room) {
        this.room = room;
    }

    public void viewRoom(){
        for (Item item: room.getItems()){
            System.out.println(item.getFloorDescription());
        }
    }

    public void enterRoom(){
        System.out.println(this.room.getDescription());
        viewRoom();
    }
}
