package src.Main.app;

import Entity.Fire;
import Entity.Grass;
import Entity.Water;
import Entity.GameLevelList;
import Entity.Player;
import Entity.Room;
import Entity.Equipment;
import Entity.Exit;
import Entity.Key;

import Frameworks_and_drivers.GUIUtility;

import interface_adaptor.GameGUI;
import interface_adaptor.GUIPresenter;
import User_case.GUI.UserActionInteractor;
import User_case.GameLevelsUserCase.LevelInteraction;
import User_case.RoomUserCase.RoomInteraction;

public class AppBuilder {

    private GameLevelList dungen;
    private Player player;
    private GameGUI gameGUI;
    private GUIPresenter presenter;
    private UserActionInteractor interactor;

    public AppBuilder() {
        // Initialize core components
        dungen = new GameLevelList();
    }

    /**
     * Adds the training room level to the application.
     *
     * @return this builder
     */
    public AppBuilder addTrainingRoom() {
        Key key = new Key("mail_box", "There is a key in the mail_box!", "a key lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "The exit is covered by a thick spider web", "There is a heavy gate in front of you.");
        Equipment sword = new Equipment("Dragonfang Sword",
                "A weapon bestowed upon warriors chosen by the Dragon Clan. It holds the power of the dragon!",
                "A sword is stuck on the wall", 4, null);

        Room room1 = new Room("This is the training room for beginners!");
        RoomInteraction roomInteractor = new RoomInteraction(room1);
        roomInteractor.addItem(key);
        roomInteractor.addItem(sword);
        roomInteractor.addItem(gate);

        LevelInteraction levelInteractor = new LevelInteraction(dungen);
        levelInteractor.addLevel(room1);

        return this;
    }

    /**
     * Adds the training forest level to the application.
     *
     * @return this builder
     */
    public AppBuilder addTrainingForest() {
        Key torch = new Key("torch", "This is a torch with the element of fire.",
                "A torch hangs on the wall, still burning.", 3, "fire");
        Exit spiderweb = new Exit("spiderweb", "",
                "The exit of the room is blocked by a spider web. Better get rid of it before passing.");
        Fire GhostRider = new Fire("Ghost Rider",
                "An ancient soul guardian. He ravages the mortal realm with blazing fire.");

        Room room2 = new Room("This is the second room.");
        room2.addItem(torch);
        room2.addExit(spiderweb);
        room2.addBattleTrigger(spiderweb, GhostRider);

        dungen.addLevel(room2);

        return this;
    }

    /**
     * Sets up the player and the GUI.
     *
     * @return this builder
     */
    public AppBuilder setupPlayerAndGUI() {
        Room startingRoom = dungen.getFirstLevel();

        // Initialize the player
        player = new Player(5, 15, 2, startingRoom);

        // Initialize the GUI components
        gameGUI = new GameGUI(player, null); // GUI with no interactor initially
        presenter = new GUIPresenter(gameGUI);
        interactor = new UserActionInteractor(presenter, player);

        // Connect the interactor to the GUI
        gameGUI.setInputBoundary(interactor);

        return this;
    }

    /**
     * Starts the game by displaying the initial messages.
     *
     * @return this builder
     */
    public AppBuilder startGame() {
        presenter.displayResult("Hey, Frodo, you are inside the adventure to chase your magic ring!");
        presenter.displayResult("Now, let's enter a training room to get used to this adventure!");
        return this;
    }

    public void run() {
        // Game logic starts from here; GUI handles further user inputs
        GUIUtility.displayOutput("The game is ready. Begin your adventure!");
    }
}
