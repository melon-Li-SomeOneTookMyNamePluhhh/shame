package Entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Item> items; // items inside the room
    private List<Item> battleTriggers; // items inside the room that triggers battle
    private List<Enemy> battleEnemys;
    private String description; // the rooms description, only print once when player enters the room
    private GameLevelList dungen;

    public Room(String description) {
        this.items = new ArrayList();
        this.battleTriggers = new ArrayList();
        this.battleEnemys = new ArrayList();
        this.description = description;
    }

    public List<Item> getItems(){return this.items;}

    public List<Item> getBattleTriggers(){return this.battleTriggers;}

    public List<Enemy> getBattleEnemys(){return this.battleEnemys;}

    public String getDescription(){return this.description;}

    public GameLevelList getGameLevel(){return this.dungen;}


    public void setItems(List<Item> items){this.items = items;}

    public void setBattleTriggers(List<Item> items){this.battleTriggers = battleTriggers;}

    public void setBattleEnemys(List<Enemy> enemys){this.battleEnemys = battleEnemys;}

    public void setDescription(String description){this.description = description;}

    public void setGameLevel(GameLevelList dungen){this.dungen = this.dungen;}

}
