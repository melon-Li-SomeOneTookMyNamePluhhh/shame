package java.User_case.Room;

import java.Entity.Room;

public class RoomItemRemover {
    private Room room;

    public RoomItemRemover(Room room) {
        this.room = room;
    }

    public Item removeItem(Item item){
        for (Item item: this.room.getItems()){
            if (item.getName().equals(itemName) && item.pickup() != null){
                this.room.getItems().remove(item);
                return item;
            }
        }
        return null;
    }
}
