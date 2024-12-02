package UseCases;

import DungenKeeper.Room;
import Entity.ActionRepository;
import Entity.Player;
import Item.Equipment;
import Item.Exit;
import Item.Key;
import User_case.GUI.UserActionInteractor;
import interface_adaptor.GameGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Test.UNITest.TestGameGUIOutputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class UserActionInteractorTest {

    private TestGameGUIOutputBoundary testOutputBoundary;
    private UserActionInteractor interactor;
    private Player player;

    @BeforeEach
    void setUp() {
        // Initialize test components
        Key key = new Key("mail_box", "There is a key in the mail_box!", "a key lies on the floor", 1, "regular");
        Exit gate = new Exit("gate", "The exist, but it is covered by the thick spider web", "there is a heavy gate in front of you");
        Equipment sword = new Equipment("Dragonfang Sword", "a weapon bestowed only upon warriors chosen by the Dragon Clan. Forged from the indestructible fangs of dragons, it holds the power of the dragon!",
                "a sword is stuck on the wall", 4, null);
        Room room1 = new Room("This is the training room for beginner!");
        room1.addItem(key);
        room1.addItem(sword);
        room1.addExit(gate);
        Player player = new Player(5, 15,2,room1);
        testOutputBoundary = new TestGameGUIOutputBoundary();
        interactor = new UserActionInteractor(testOutputBoundary, player);
    }

    @Test
    void testValidActionWalkTo() {
        // Given: A valid action "walk to"
        String action = "walk to";

        // When: The interactor processes the action
        interactor.processInput(action);

        // Then: Check that the output matches the expected result
        assertEquals("You walk towards your destination.", testOutputBoundary.getLastMessage());
    }

    @Test
    void testInvalidAction() {
        // Given: An invalid action "fly"
        String action = "fly";

        // When: The interactor processes the action
        interactor.processInput(action);

        // Then: Check that the output matches the expected invalid result
        assertEquals("Invalid action: fly", testOutputBoundary.getLastMessage());
    }

    @Test
    void testHealActionUpdatesPlayerHealth() {
        // Given: A heal action
        String action = "heal";

        // When: The interactor processes the heal action
        interactor.processInput(action);

        // Then: Verify player's health is updated and output is correct
        assertEquals(105, player.getHealth());
        assertEquals("You healed yourself! Current health: 105", testOutputBoundary.getLastMessage());
    }
}
