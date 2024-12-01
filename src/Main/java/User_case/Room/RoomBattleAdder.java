package java.User_case.Room;

import java.Entity.Room;

public class RoomBattleAdder {
    private Room room;

    public RoomBattleAdder(Room room) {
        this.room = room;
    }

    public void addBattle(Item item, Enemy enemy){
        this.room.getBattleTriggers().add(item);
        this.room.getBattleEnemys().add(enemy);
        return;
    }
}
