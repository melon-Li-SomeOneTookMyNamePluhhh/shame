package User_case.RoomUserCase;

import Entity.Room;
import Entity.Item;

public class RoomItemAdder {
    private Room room;
    public RoomItemAdder(Room room) {

        this.room = room;
    }

    public void addItem(Item item) {
        this.room.getItems().add(item);
    }

}
