package User_case.RoomUserCase;

import Entity.Room;
import Entity.Enemy;
import Entity.Item;


public class RoomInteraction{
    private Room room;
    private RoomItemAdder roomItemAdder;
    private RoomItemRemover roomItemRemover;
    private RoomItemFinder roomItemFinder;
    private RoomBattleAdder roomBattleAdder;
    private RoomBattleRemover roomBattleRemover;
    private RoomBattleChecker roomBattleChecker;
    private RoomViewer roomViewer;

    public RoomInteraction(Room room) {
        this.room = room;
        roomItemAdder = new RoomItemAdder(room);
        roomItemRemover = new RoomItemRemover(room);
        roomItemFinder = new RoomItemFinder(room);
        roomBattleAdder = new RoomBattleAdder(room);
        roomItemRemover = new RoomItemRemover(room);
        roomBattleChecker = new RoomBattleChecker(room);
        roomViewer = new RoomViewer(room);

    }

    public void addItem(Item item){
        roomItemAdder.addItem(item);
    }

    public void addBattle(Item item, Enemy enemy){roomBattleAdder.addBattle(item, enemy);}

    public void removeItem(String itemName){roomItemRemover.removeItem(itemName);}

    public Item findItem(String itemName){return roomItemFinder.findItem(itemName);}

    public Enemy removeBattle(Item item){return roomBattleRemover.removeBattle(item);}

    public boolean checkBattle(Item item){return roomBattleChecker.checkBattle(item);}
    
    public void viewRoom(){roomViewer.viewRoom();}
    
    public void enterRoom(){roomViewer.enterRoom();}
    
}
