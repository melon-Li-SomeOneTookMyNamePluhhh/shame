package User_case.RoomUserCase;

import Entity.Room;
import Entity.Item;
import Entity.Enemy;

public class RoomBattleRemover {
    private Room room;
    
    public RoomBattleRemover(Room room) {
        this.room = room;
    }
    
    public Enemy removeBattle(Item item) {

        room.getBattleTriggers().remove(item);
        return room.getBattleEnemys().remove(0);
    }
}
