package User_case.GameLevelsUserCase;

import Entity.GameLevelList;
import Entity.Player;

public class LevelCompleteManager {
    private GameLevelList level;

    public LevelCompleteManager(GameLevelList level) {
        this.level = level;
    }

    public void nextLevel(Player player) {
        int whichLevel = this.level.getCurrentLevel() + 1;
        if (whichLevel >= level.getLevels().size()) {
            System.out.println("No more levels!");
            return;
        }
        this.level.setCurrentLevel(whichLevel);
        player.setCurrRoom(this.level.getLevels().get(whichLevel));
    }


}
