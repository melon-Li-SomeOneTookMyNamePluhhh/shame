package java.User_case.Room;

import java.Entity.Room;

public class RoomBattleRemover {
    private Room room;
    
    public RoomBattleRemover(Room room) {
        this.room = room;
    }
    
    public void removeBattle(Item item) {
        room.getBattleTriggers().remove(item);
    }
}
