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
        Key key = new Key("key", "this is a key", "a ket lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "", "there is a heavy gate infront of you");
        Equipment sword = new Equipment("sword", "this is a sword, it has the element of earth", "a sword is stuck on the wall", 3, "earth");
        Room room1 = new Room("this is the first room");
        room1.addItem(key);
        room1.addItem(sword);
        room1.addExit(gate);
        dungen.addLevel(room1);
        Key torch = new Key("torch", "this is a torch, it has the element of fire",
                "a torch hangs on the wall, it is still burning", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "", "the exit of the room is blocked by a lot of spiderweb, better get rid of it " +
                        "before passing");
      
        Room room2 = new Room("this is the second room");
        room2.addItem(torch);
        room2.addItem(spiderweb);
        dungen.addLevel(room2);

        dungen.addPlayer(10, 5, 1);
        room1.viewRoom(); // expected to see key, sword and exit
        dungen.getPlayer().pickUp("key"); // expected to see unable to pickup key
        dungen.getPlayer().walkTo("key"); // expected to see walk to key
        dungen.getPlayer().pickUp("kkkk"); // expected to see unable to pickup kkkk
        dungen.getPlayer().pickUp("key"); // expected to see pickup key
        room1.viewRoom(); // expected to see sword and gate
        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().pickUp("gate");
        dungen.getPlayer().putInBag(); //expect to put key in bag
        dungen.getPlayer().pickUp("gate"); // expect to not able to pick up
        dungen.getPlayer().inspectBag(); // expected to see key i.e name of item instead of item discription
        dungen.getPlayer().getFromBag("key"); // expect to have key equipped and removed from bag
        dungen.getPlayer().inspectBag();// expect to see no item in bag!
        dungen.getPlayer().interact("key"); // expect to see player bite the key and hurt
        dungen.getPlayer().interact("gate"); // expect to see player trying to open exit but fails
        dungen.getPlayer().walkTo("sword"); // expect to see player walk to sword
        dungen.getPlayer().putInBag(); // expect to see player put key in bag
        dungen.getPlayer().pickUp("sword"); // expect to see player pick up sword
        dungen.getPlayer().walkTo("sword"); // expect to see cannot walk to sword
        dungen.getPlayer().putInBag(); // expect to see player put sword in bag
        dungen.getPlayer().inspectBag(); // expect to see sword and key
        dungen.getPlayer().walkTo("gate");
        dungen.getPlayer().interact("sword", "gate"); // expect to see nothing in your hand
        dungen.getPlayer().getFromBag("sword"); // expected to see player get sword from bag
        dungen.getPlayer().inspectBag(); // expected to see key in bag
        dungen.getPlayer().interact("sword", "gate"); //exected to see try pick the gate and fails
        dungen.getPlayer().interact("key", "exit"); // expect to see player holding sword instead of key
        dungen.getPlayer().putInBag(); // expect to have sword put in bag
        dungen.getPlayer().getFromBag("key"); //expect to have key equipped
        dungen.getPlayer().getFromBag("sword"); //expect to not get sword due to already holding
        dungen.getPlayer().interact("key", "gate"); // expect to open exit
        dungen.getPlayer().interact("gate"); //expect to see player leave from exit, have room set to room2
        // success if see room 2 description and torch + spider web
    }
}