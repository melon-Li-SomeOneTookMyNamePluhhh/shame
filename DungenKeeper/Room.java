package DungenKeeper;
import Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Item> items; // items inside the room
    private List<Item> battleTriggers; // items inside the room that triggers battle
    private String description; // the rooms description, only print once when player enters the room


    public Room(String description) {
        this.items = new ArrayList();
        this.battleTriggers = new ArrayList();
        this.description = description;
    }

    // trigger when player enters the room
    public void enter(){
        System.out.println(this.description);
        viewRoom();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void addBattleTrigger(Item item){
        this.battleTriggers.add(item);
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
