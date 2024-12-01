package DungenKeeper;

import Battle.Battle;
import Enemy.Enemy;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class DungenBuilder {

    private List<Room> levels;
    private int currentLevel;
    private Player player;
    private Battle fights;

    public DungenBuilder() {
        this.levels = new ArrayList<>();
        this.currentLevel = 0;
        this.player = null;
    }

    public void addLevel(Room room) {
        levels.add(room);
        room.setDungen(this);
    }

    public void addPlayer(int bagsize, int health, int damage) {
        this.player = new Player(bagsize, health, damage, this.getLevels());
        getLevels().enter();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Room getLevels() {
        return levels.get(currentLevel);
    }

    public void nextLevel() {
        this.currentLevel += 1;
        if (this.currentLevel >= levels.size()) {
            System.out.println("No more levels!");
            return;
        }
        player.setCurrRoom(getLevels());
        getLevels().enter();
    }

    public void fight(Enemy enemy) {
        System.out.println("you are ambushed by " + enemy.getName());
        Battle battle = new Battle(this.player, enemy);
        this.fights = battle;
    }

    public Battle getFights(){
        return this.fights;
    }

}
