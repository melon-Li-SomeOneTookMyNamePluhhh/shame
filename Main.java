import DungenKeeper.DungenBuilder;
import DungenKeeper.Room;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import Player.Player;

public class Main {

    // build your custom level here!
    public static void main(String[] args) {
        DungenBuilder dungen = new DungenBuilder();
        Key key = new Key("key", "this is a key", "a ket lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "", "there is a heavy gate infront of you");
        Room room1 = new Room("this is the first room");
        room1.addItem(key);
        room1.addItem(gate);
        dungen.addLevel(room1);
        Key torch = new Key("torch", "this is a torch, it has the element of fire",
                "a torch hangs on the wall, it is still burning", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "",
                "the exit of the room is blocked by a lot of spiderweb, better get rid of it before passing");
        Room room2 = new Room("this is the second room");
        room2.addItem(torch);
        room2.addItem(spiderweb);
        dungen.addLevel(room2);
        dungen.addPlayer(10, 5, 1);
        room1.enter();
        room1.viewRoom();
        dungen.getPlayer().pickUp("key");
        dungen.getPlayer().walkTo("key");
        dungen.getPlayer().pickUp("kkkkkkkkkkkkkkkkkkkkk");
        dungen.getPlayer().pickUp("key");
        room1.viewRoom();
        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().pickUp("gate");
//        player.putInBag();
//        player.pickUp("exit"); // expect to not able to pick up
//        player.inspectBag(); // expected to see key i.e name of item instead of item discription
//        player.getFromBag("key"); // expect to have key equipped and removed from bag
//        player.interact("key"); // expect to see key getting pocked into thin air
//        player.interact("exit"); // expect to see player trying to open exit but fails
//        player.interact("ket", "exit"); // expect to see exit open
//        player.interact("exit"); //expect to see player leave from exit, have room set to room2

    }
}