package User_case.GameLevelsUserCase;

import Entity.GameLevelList;
import Entity.Player;
import Entity.Room;

public class LevelAdder {
    private GameLevelList levels;

    public LevelAdder(GameLevelList levels) {
        this.levels = levels;
    }

    public void addLevel(Room room){
        this.levels.getLevels().add(room);
    }

    public void addPlayer(Player player){
        this.levels.setPlayer(player);
    }
}
