package User_case.RoomUserCase;

import Entity.Item;
import Entity.Room;
import User_case.Items_Usercase.ItemInputBoundary;
import User_case.Items_Usercase.ItemOutputBoundary;

public class RoomPickUp {
    private Room room;

    public RoomPickUp(Room room) {

        this.room = room;
    }

    public Item pickUp(String itemName){
        for (Item item: this.room.getItems()){
            if (item.getName().equals(itemName) && new ItemInputBoundary(item, new ItemOutputBoundary()).pickUp() != null){
                this.room.getItems().remove(item);
                return item;
            }
        }
        return null;
    }
}
