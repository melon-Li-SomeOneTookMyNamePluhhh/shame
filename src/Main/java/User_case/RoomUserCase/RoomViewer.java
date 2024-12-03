package User_case.RoomUserCase;

import Entity.Room;
import Entity.Item;

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
