import DungenKeeper.DungenBuilder;
import DungenKeeper.Room;
import Enemy.Enemy;
import Enemy.Grass;
import Enemy.Water;
import Enemy.Fire;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import Frameworks_and_drivers.GUIUtility;
import Player.Player;
import interface_adaptor.GameGUI;
import interface_adaptor.GUIPresenter;
import User_case.GUI.UserActionInteractor;


public class Main {

    public static void main(String[] args) {


        // initialize the enemy
        Fire GhostRider = new Fire("Ghost Rider","This is the ancient Soul Guardian. He ravages the mortal realm with blazing fire, paving the way for the spirits of the underworld. His deeds are utterly heinous and unforgivable.");
        Water FrostWyrm = new Water("Frost Wyrm", "Possessing immense power to manipulate aquatic objects, he has long plagued these seas, harming countless innocent fishermen and warriors seeking the magical ring.");
        Grass Clover = new Grass("Clover","Clover is a sly manipulator who thrives on deception, using charm and lies to exploit others for personal gain. Marked by a twisted four-leaf clover, they leave betrayal and chaos wherever they go.");

        // Initialize the GUI architecture components
       //Initialize the rooms
        // training room
        DungenBuilder dungen = new DungenBuilder();
        Key key = new Key("mail_box", "There is a key in the mail_box!", "a key lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "The exist, but it is covered by the thick spider web", "there is a heavy gate in front of you");
        Equipment sword = new Equipment("Dragonfang Sword", "a weapon bestowed only upon warriors chosen by the Dragon Clan. Forged from the indestructible fangs of dragons, it holds the power of the dragon!",
                "a sword is stuck on the wall", 4, null);
        Room room1 = new Room("This is the training room for beginner!");
        room1.addItem(key);
        room1.addItem(sword);
        room1.addExit(gate);
        dungen.addLevel(room1);

        // training forest
        Key torch = new Key("torch", "this is a torch, it has the element of fire",
                "a torch hangs on the wall, it is still burning", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "",
                "the exit of the room is blocked by a lot of spiderweb, better get rid of it before passing");
        Enemy spider = new Grass("spider", "this is a spider");
        Room room2 = new Room("this is the second room");
        room2.addItem(torch);
        room2.addExit(spiderweb);
        room2.addBattleTrigger(spiderweb, spider);
        dungen.addLevel(room2);

        // final horizon valley

        // player setting
        Player player = new Player(5, 15,2,room1);
        // GUI setup
        // Instantiate the GUI first
        GameGUI gameGUI = new GameGUI(player, null); // We'll set the interactor later
        // Create the presenter with reference to the GUI
        GUIPresenter presenter = new GUIPresenter(gameGUI);
        // Create the interactor with the presenter and player
        UserActionInteractor interactor = new UserActionInteractor(presenter,player);
        // Now set the interactor in the GUI (since it needed the GUI initialized)
        gameGUI.setInputBoundary(interactor);



        // GAME START!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        presenter.displayResult("Hey, Frodo, you are inside the adventure to chase your magic ring!" );
        presenter.displayResult( "Now, let's enter in a training room to let you get used to this new adventure!" );
        // Training room
        GUIUtility.displayOutput("There is a traning gift for you, the Dragonfang Sword");
        GUIUtility.displayOutput("Now try to inspect the bag and get the description of the Dragonfang Sword");
        //get input from user and case inspect
        GUIUtility.displayOutput("And then try to use get from bag to hold this equipment!");
        //get input from user and case get from bag
        GUIUtility.displayOutput("It seems a stuff in your hand. It may not good for your movement. Now try to type put in bag " +
                "to put the item in your hand back to your bag!");
        //get input from user and case put in bag
        GUIUtility.displayOutput("These are the items in the traning room:");
        GUIUtility.displayOutput(room1.getDescription());
        String input = GUIUtility.getInput("Try to type pick up to get the key! :");
        interactor.processInput(input.toLowerCase().trim());
        GUIUtility.displayOutput("There is a heavy door in front of you. You can choose the following actions:"+'\n'+"1. clean the spider web"+'\n'+"2.use the key to ");


        // Training valley
        GUIUtility.displayOutput("Now, you are already get familiar with the actions that you can make. Let’s go to the training valley to practice your battle skills!");
        GUIUtility.displayOutput("OPPS!!! The Ghost Rider suddenly attack you in the dark!!!!");
        GUIUtility.displayOutput(GhostRider.getDescription());
        //call battle with ghost rider

        //




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
        dungen.getPlayer().walkTo("torch");
        dungen.getPlayer().putInBag();
        dungen.getPlayer().pickUp("torch");
        dungen.getPlayer().walkTo("spiderweb");
        dungen.getFights().askForEquipment();

    }
}