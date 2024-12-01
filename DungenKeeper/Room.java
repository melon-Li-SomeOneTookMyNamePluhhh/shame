package DungenKeeper;
import Enemy.Enemy;
import Item.Item;
import Item.Exit;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Item> items; // items inside the room
    private List<Item> battleTriggers; // items inside the room that triggers battle
    private List<Enemy> battleEnemys;
    private String description; // the rooms description, only print once when player enters the room
    private DungenBuilder dungen;


    public Room(String description) {
        this.items = new ArrayList();
        this.battleTriggers = new ArrayList();
        this.battleEnemys = new ArrayList();
        this.description = description;
    }

    // trigger when player enters the room
    public void enter(){
        System.out.println(this.description);
        viewRoom();
    }

    public void leave(){

        this.dungen.nextLevel();
    }

    public void addItem(Item item){

        this.items.add(item);
    }

    public void addExit(Exit item){
        this.items.add(item);
        item.setRoom(this);
        // I would love to get rid of this method
    }

    public String getDescription() {
        StringBuilder desc = new StringBuilder(description + "\nItems in the room:\n");
        for (Item item : items) {
            desc.append("- ").append(item.getName()).append(": ").append(item.getDescription()).append("\n");
        }
        return desc.toString();
    }

    public void addBattleTrigger(Item item, Enemy enemy){
        this.battleTriggers.add(item);
        this.battleEnemys.add(enemy);
    }

    public void launchBattle(Item item){
        this.battleTriggers.remove(item);
        this.dungen.fight(this.battleEnemys.remove(0));
    }

    public void setDungen(DungenBuilder dungen){
        this.dungen = dungen;
    }

    // return item if the room has this item
    public Item hasItem(String itemName){
        for (Item item: items){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    public void viewRoom(){
        for (Item item: items){
            System.out.println(item.getFloorDescription());
        }
    }

    public Item pickUp(String itemName){
        for (Item item: items){
            if (item.getName().equals(itemName) && item.pickup() != null){
                this.items.remove(item);
                return item;
            }
        }
        return null;
    }

    public boolean checkBattle(Item item){
        if (this.battleTriggers.contains(item)){
            return true;
        }
        return false;

    }


}
