package DungenKeeper;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<item> items;
    private List<item> battleTriggers;
    private String description;

    public Room(String description) {
        this.items = new ArrayList();
        this.battleTriggers = new ArrayList();
        this.description = description;
    }

    public void Enter(){
        System.out.println(this.description);
        ViewRoom();
    }

    public void AddItem(Item item){
        this.items.add(item);
    }

    public void AddBattleTrigger(Item item){
        this.battleTriggers.add(item);
    }
    public void ViewRoom(){
        for (Item item: items){
            item.print();
        }
    }

    public boolean CheckBattle(Item item){
        if (this.battleTriggers.contains(item)){
            return true;
        }
    }
}
