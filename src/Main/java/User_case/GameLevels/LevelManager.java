package java.User_case.GameLevels;

import java.Entity.GameLevelList;
import java.Entity.Room;

public class LevelManager {
    private GameLevelList levels;

    public LevelManager(GameLevelList levels) {
        this.levels = levels;
    }

    public void addLevel(Room room){
        this.levels.getLevels().add(room);
    }

    public void addPlayer(Player player){
        this.levels.setPlayer(player);
    }
}
