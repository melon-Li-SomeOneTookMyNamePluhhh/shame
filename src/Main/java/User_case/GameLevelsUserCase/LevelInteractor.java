package User_case.GameLevelsUserCase;

import Entity.GameLevelList;
import Entity.Player;
import Entity.Room;
import Entity.Enemy;

public class LevelInteractor{
    private GameLevelList levels;
    private LevelAdder levelAdder;
    private LevelCompleteManager levelCompleteManager;
    private LevelBattleLauncher levelBattleLauncher;

    public LevelInteractor(GameLevelList levels) {

        this.levels = levels;
        this.levelAdder = new LevelAdder(levels);
        this.levelCompleteManager = new LevelCompleteManager(levels);
        this.levelBattleLauncher = new LevelBattleLauncher(levels);
    }

    public void addLevel(Room room){this.levelAdder.addLevel(room);}

    public void addPlayer(Player player){
        this.levels.setPlayer(player);
    }

    public void launchBattle(Enemy enemy){this.levelBattleLauncher.launchBattle(enemy);}

    public void levelComplete(Player player){this.levelCompleteManager.nextLevel(player);}
}
