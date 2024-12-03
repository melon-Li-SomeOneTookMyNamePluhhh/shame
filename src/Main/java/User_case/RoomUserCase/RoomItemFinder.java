package User_case.RoomUserCase;

import Entity.Room;
import Entity.Item;

// find an item in the room based on string
public class RoomItemFinder {
    private Room room;

    public RoomItemFinder(Room room) {
        this.room = room;
    }

    public Item findItem(String itemName){
        for (Item item: this.room.getItems()){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }
}
