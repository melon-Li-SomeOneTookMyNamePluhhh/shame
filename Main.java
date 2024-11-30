import DungenKeeper.DungenBuilder;
import DungenKeeper.Room;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import GUI.GUIUtility;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Define valid actions
        Set<String> validActions = new HashSet<>();
        validActions.add("walk to");
        validActions.add("pick up");
        validActions.add("speech");
        validActions.add("exit");

        DungenBuilder dungen = new DungenBuilder();
        Key key = new Key("key", "this is a key", "a key lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "", "there is a heavy gate in front of you");
        Equipment sword = new Equipment("sword", "this is a sword, it has the element of earth",
                "a sword is stuck on the wall", 3, "earth");
        Room room1 = new Room("this is the first room");
        room1.addItem(key);
        room1.addItem(sword);
        room1.addExit(gate);
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

        // Room 1 interactions using GUI
        GUIUtility.displayOutput(room1.getDescription());
        room1.viewRoom();

        dungen.getPlayer().pickUp("key");
        dungen.getPlayer().walkTo("key");
        dungen.getPlayer().pickUp("kkkk");
        dungen.getPlayer().pickUp("key");
        room1.viewRoom();

        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().pickUp("gate");
        dungen.getPlayer().putInBag();
        dungen.getPlayer().pickUp("gate");
        dungen.getPlayer().inspectBag();
        dungen.getPlayer().getFromBag("key");
        dungen.getPlayer().inspectBag();
        dungen.getPlayer().interact("key");
        dungen.getPlayer().interact("gate");

        dungen.getPlayer().walkTo("sword");
        dungen.getPlayer().putInBag();
        dungen.getPlayer().pickUp("sword");
        dungen.getPlayer().walkTo("sword");
        dungen.getPlayer().putInBag();
        dungen.getPlayer().inspectBag();
        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().interact("sword", "gate");
        dungen.getPlayer().getFromBag("sword");
        dungen.getPlayer().inspectBag();
        dungen.getPlayer().interact("sword", "gate");
        dungen.getPlayer().interact("key", "exit");
        dungen.getPlayer().putInBag();
        dungen.getPlayer().getFromBag("key");
        dungen.getPlayer().getFromBag("sword");
        dungen.getPlayer().interact("key", "gate");
        dungen.getPlayer().interact("gate");

        // Check if transitioned to Room 2
        GUIUtility.displayOutput(room2.getDescription());
        room2.viewRoom();
    }
}
