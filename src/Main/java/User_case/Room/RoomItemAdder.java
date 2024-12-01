package java.User_case.Room;

import java.Entity.Room;

public class RoomItemAdder {
    private Room room;
    public RoomItemAdder(Room room) {

        this.room = room;
    }

    public void addItem(Item item) {
        this.room.getItems().add(item);
    }

}
