package java.User_case.Room;

import java.Entity.Room;


//
public class RoomBattleChecker {
    private Room room;

    public RoomBattleChecker(Room room) {
        this.room = room;
    }

    public boolean checkBattle(Item item){
        if (this.room.getBattleTriggers().contains(item)){
            return true;
        }
        return false;

    }

}
