package User_case.RoomUserCase;

import Entity.Room;
import Entity.Item;

public class RoomItemRemover {
    private Room room;

    public RoomItemRemover(Room room) {
        this.room = room;
    }

    public Item removeItem(String itemName){
        for (Item item: this.room.getItems()){
            if (item.getName().equals(itemName)){
                this.room.getItems().remove(item);
                return item;
            }
        }
        return null;
    }
}
