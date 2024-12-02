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
import Entity.NPC;
import Entity.TicTacToe.

import Frameworks_and_drivers.GUIUtility;

import Frameworks_and_drivers.Tictactoe.TicTacToeCLIView;
import Frameworks_and_drivers.Tictactoe.TicTacToeView;
import Item.NPC;
import User_case.TicTacToe.BotMoveUseCase;
import User_case.TicTacToe.PlayerMoveInputBoundary;
import User_case.TicTacToe.PlayerMoveUseCase;
import interface_adaptor.GameGUI;
import interface_adaptor.GUIPresenter;
import User_case.GUI.UserActionInteractor;
import User_case.GameLevelsUserCase.LevelInteraction;
import User_case.RoomUserCase.RoomInteraction;
import interface_adaptor.Tictactoe.TicTacToeController;
import interface_adaptor.Tictactoe.TicTacToePresenter;

import java.util.Scanner;

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
        Exit gate = new Exit("gate", "The exit is covered by a thick spider web", "There is a heavy gate in " +
                "front of you.");
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
        Fire GhostRider = new Fire("Ghost Rider",
                "An ancient soul guardian. He ravages the mortal realm with blazing fire.");
        Equipment FlameDragonBow = new Equipment("Flame Dragon Bow","A legendary weapon bestowed by the Flame Dragon " +
                "itself, each bow is engulfed in roaring flames. When fired, it burns as fiercely as the dragon's " +
                "breath.",3,"fire");
        NPC Jack = new NPC();
        Grass Clover = new Grass ("Clover","is a sly manipulator who thrives on deception, using charm " +
                "and lies to exploit others for personal gain. Marked by a twisted four-leaf clover, they leave " +
                "betrayal and chaos wherever they go.");
        Exit spiderweb = new Exit("spiderweb", "",
                "The exit of the room is blocked by a spider web. Better get rid of it before passing.");


        Room room2 = new Room("This is the training forest for beginners!.");
        room2.addItem(torch);
        room2.addExit(spiderweb);
        room2.addBattleTrigger(spiderweb, GhostRider);

        dungen.addLevel(room2);

        return this;
    }

    /**
     * Adds the training forest level to the application.
     *
     * @return this builder
     */
    public AppBuilder lastHorizonValley() {
        ticTacToeRule();
        startTicTacToeGame();
        Equipment ElfStaff = new Equipment("Elf Staff","A treasured artifact of the Elf Tribe, it wields the power to " +
                "command all flora in the world and unleashes immense vitality.",5,"grass");
        NPC Hobbit = new NPC();
        Water FrostWyrm = new Water ("Frost Wyrm", "Possesses immense power to control aquatic " +
                "creatures, and has long terrorized these waters, harming many innocent fishermen as well as brave" +
                " warriors seeking the magic ring.");
        Item magic_ring = new magic_ring ("Magic Ring", "");

        Room room3 = new Room("Now let’s go to the final adventure to the last horizon valley to chase your " +
                "magic ring!");
        room3.addItem(magic_ring);
        room3.addBattleTrigger(magic_ring, FrostWyrm);

        dungen.addLevel(room3);

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

    private void ticTacToeRule(){
        GUIUtility.displayOutput("Players take turns placing their symbol (X or O) in an empty cell, aiming to align " +
                "three of their symbols in a row, column, or diagonal to win. The game starts with X and alternates " +
                "turns."+'\n'+" Moves must be within the grid and cannot overwrite existing symbols. The game ends " +
                "when a player achieves three in a row or the grid is full. "+'\n'+"If no one wins, the result is a " +
                "draw. Simple yet strategic, it’s a race to outsmart your opponent!");
    }

    public void run() {
        // Game logic starts from here; GUI handles further user inputs
        GUIUtility.displayOutput("The game is ready. Begin your adventure!");
    }

    private void startTicTacToeGame() {
        // Initialize the Tic Tac Toe game components
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeView view = new TicTacToeCLIView();
        TicTacToePresenter presenter = new TicTacToePresenter(view);
        PlayerMoveUseCase useCase = new PlayerMoveUseCase(board, presenter);
        BotMoveUseCase botUseCase = new BotMoveUseCase(board, presenter);
        TicTacToeController controller = new TicTacToeController(useCase, botUseCase);
        Scanner scanner = new Scanner(System.in);

        // Start the Tic Tac Toe game
        System.out.println("To exit the game at any time, type '9'. To start, type any other number.");
        int userCommand = scanner.nextInt();

        while (userCommand != 9) {
            view.displayBoard(board.getBoard());
            System.out.println("Player " + board.getCurrentPlayer() + ", enter your move by typing the row then a space then column number. Your options are 0, 1, or 2.");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            controller.makeMove(row, col);
            if (board.checkWin() != '-' || board.isFull()) {
                break;
            }
            userCommand = row;
        }

        view.displayBoard(board.getBoard());
        char winner = board.checkWin();
        if (winner != '-') {
            view.displayWinner(winner);
        } else {
            view.displayWinner('D'); // Draw
        }
    }
}
