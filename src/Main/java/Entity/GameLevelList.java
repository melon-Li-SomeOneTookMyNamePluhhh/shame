package Entity;

import Entity.Room;
import Entity.Player;


import java.util.ArrayList;
import java.util.List;

public class GameLevelList {
    private List<Room> levels;
    private int currentLevel;
    private Player player;
    private Battle battle;

    public GameLevelList() {
        this.levels = new ArrayList<>();
        this.currentLevel = 0;
        this.player = null;
    }

    public List<Room> getLevels(){return this.levels;}

    public int getCurrentLevel(){return this.currentLevel;}

    public Player getPlayer(){return this.player;}

    public Battle getfights(){return this.battle;}

    public void setLevels(List<Room> levels){this.levels = levels;}

    public void setCurrentLevel(int currentLevel){this.currentLevel = currentLevel;}

    public void setPlayer(Player player){this.player = player;}

    public void setBattle(Battle battle){this.battle = battle;}
}
