import DungenKeeper.DungenBuilder;
import DungenKeeper.Room;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import Player.Player;
import GUI. GUIUtility;

import java.util.HashSet;
import java.util.Set;

public class Main {

    // build your custom level here!
    public static void main(String[] args) {
        // Define valid actions
        Set<String> validActions = new HashSet<>();
        validActions.add("walk to");
        validActions.add("pick up");
        validActions.add("speech");
        validActions.add("exit");

        DungenBuilder dungen = new DungenBuilder();
        Key key = new Key("key", "this is a key", "a ket lies on the floor", 1,
                "regular");
        Exit gate = new Exit("gate", "", "there is a heavy gate in front of you",
                0);
        Room room1 = new Room("this is the first room");
        room1.addItem(key);
        room1.addItem(gate);
        dungen.addLevel(room1);
        Key torch = new Key("torch", "this is a torch, it has the element of fire",
                "a torch hangs on the wall, it is still burning", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "",
                "the exit of the room is blocked by a lot of spiderweb, better get rid of it " +
                        "before passing", 0);
        Room room2 = new Room("this is the second room");
        room2.addItem(torch);
        room2.addItem(spiderweb);
        dungen.addLevel(room2);
        Player player = new Player(10, 5, 1, dungen.getLevels());

        GUIUtility.displayOutput(room1.getDescription());
        room1.enter();
        room1.viewRoom();
        player.pickUp("key");
        player.walkTo("key");
        player.pickUp("kkkkkkkkkkkkkkkkkkkkk");
        player.pickUp("key");
        room1.viewRoom();
        player.walkTo("gate");
        player.walkTo("exit");
        player.pickUp("exit");
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