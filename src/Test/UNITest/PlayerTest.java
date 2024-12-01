package UNITest;

import Entity.Player;
import Entity.Item;
import Entity.Room;
import Entity.Inventory;
import User_case.PlayerUsercase.inputBoundary;
import User_case.PlayerUsercase.outputBoundaryInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for the inputBoundary class.
 * Ensures full test coverage of all methods and edge cases.
 */
class PlayerTest{

    private Player player;
    private Room room;
    private Inventory inventory;
    private TestOutputBoundary testOutputBoundary;
    private inputBoundary inputBoundary;

    /**
     * Sets up the environment and initializes the dependencies before each test.
     */
    @BeforeEach
    void setUp() {
        room = new Room(); // Room object for testing
        inventory = new Inventory(10); // Player's bag with size 10
        player = new Player(10, 100, 10, room); // Create player with default health and damage
        testOutputBoundary = new TestOutputBoundary(); // Custom TestOutputBoundary to capture messages
        inputBoundary = new inputBoundary(player, testOutputBoundary);
    }

    // --- Tests for walkTo() ---
    @Test
    void testWalkToValidItem() {
        // Arrange: Add an item to the room
        Item sword = new Item("Sword", "A sharp blade");
        room.addItem(sword);

        // Act: Player walks to the item
        inputBoundary.walkTo("Sword");

        // Assert: Verify player's location is updated correctly
        assertNotNull(player.getLocation(), "Player's location should not be null after walking to a valid item.");
        assertEquals("Sword", player.getLocation().getName(), "Player should be at the Sword's location.");
        assertTrue(testOutputBoundary.getMessages().contains("You walked to Sword"));
    }

    private void assertNotNull(Item location, String s) {
        if(location.getName() == null){
            throw new AssertionError(message);
        }
    }

    @Test
    void testWalkToInvalidItem() {
        // Act: Player attempts to walk to a non-existent item
        inputBoundary.walkTo("NonExistentItem");

        // Assert: Verify player's location remains null
        assertNull(player.getLocation(), "Player's location should remain null when walking to an invalid item.");
        assertTrue(testOutputBoundary.getMessages().contains("You can't walk to that destination as it doesn't exist."));
    }

    private void assertNull(Item location, String s) {
        if(location.getName() != null){
            throw new AssertionError(message);
        }
    }

    // --- Tests for pickUp() ---
    @Test
    void testPickUpSuccess() {
        // Arrange: Add an item near the player and in the room
        Item sword = new Item("Sword", "A sharp blade");
        player.setLocation(sword);
        room.addItem(sword);

        // Act: Player picks up the item
        inputBoundary.pickUp("Sword");

        // Assert: Verify player is holding the item and location is cleared
        assertEquals(sword, player.getHolding(), "Player should be holding the Sword.");
        assertNull(player.getLocation(), "Player's location should be null after picking up the item.");
    }

    @Test
    void testPickUpWhileHolding() {
        // Arrange: Player is already holding an item
        Item shield = new Item("Shield", "A protective shield");
        player.setHolding(shield);

        // Act: Player attempts to pick up another item
        inputBoundary.pickUp("Sword");

        // Assert: Verify player still holds the original item
        assertEquals(shield, player.getHolding(), "Player should still be holding the Shield.");
        assertTrue(testOutputBoundary.getMessages().contains("You can't pick up an item when you are holding something."));
    }

    @Test
    void testPickUpNoNearbyItem() {
        // Arrange: Player is not near any item
        player.setLocation(null);

        // Act: Player attempts to pick up an item
        inputBoundary.pickUp("Sword");

        // Assert: Verify player is still not holding any item
        assertNull(player.getHolding(), "Player should not be holding any item.");
        assertTrue(testOutputBoundary.getMessages().contains("There is nothing around you to pick up!"));
    }

    @Test
    void testPickUpMismatchedItem() {
        // Arrange: Add an item near the player
        Item sword = new Item("Sword", "A sharp blade");
        player.setLocation(sword);

        // Act: Player attempts to pick up a different item
        inputBoundary.pickUp("Potion");

        // Assert: Verify player is still not holding any item
        assertNull(player.getHolding(), "Player should not be holding any item when mismatched item is specified.");
        assertTrue(testOutputBoundary.getMessages().contains("You did not find Potion around you."));
    }

    // --- Tests for drop() ---
    @Test
    void testDropItem() {
        // Arrange: Player is holding an item
        Item sword = new Item("Sword", "A sharp blade");
        player.setHolding(sword);

        // Act: Player drops the item
        inputBoundary.drop();

        // Assert: Verify player's location is updated and holding is cleared
        assertEquals(sword, player.getLocation(), "Player's location should be updated to the dropped item.");
        assertNull(player.getHolding(), "Player should not be holding any item after dropping it.");
    }

    @Test
    void testDropNoItem() {
        // Arrange: Player is not holding any item
        player.setHolding(null);

        // Act: Player attempts to drop an item
        inputBoundary.drop();

        // Assert: Verify no changes to player's state
        assertNull(player.getLocation(), "Player's location should remain null when no item is dropped.");
        assertTrue(testOutputBoundary.getMessages().contains("You have nothing to drop."));
    }

    // --- Tests for interact(String whatItem) ---
    @Test
    void testInteractWithHandheldHealingItem() {
        Item apple = new Item("Apple", "A healing fruit");
        apple.setDamage(-10); // Healing effect
        player.setHolding(apple);

        inputBoundary.interact("Apple");

        assertEquals(110, player.getHealth());
        assertTrue(testOutputBoundary.getMessages().contains("Looking at the Apple, you decide to take a bite."));
        assertTrue(testOutputBoundary.getMessages().contains("You healed 10 health."));
    }

    @Test
    void testInteractWithHandheldDamagingItem() {
        Item poison = new Item("Poison", "A deadly substance");
        poison.setDamage(20); // Damaging effect
        player.setHolding(poison);

        inputBoundary.interact("Poison");

        assertEquals(80, player.getHealth());
        assertTrue(testOutputBoundary.getMessages().contains("Looking at the Poison, you decide to take a bite."));
        assertTrue(testOutputBoundary.getMessages().contains("This is a bad decision."));
        assertTrue(testOutputBoundary.getMessages().contains("You lost 20 health."));
    }

    @Test
    void testInteractWithNothing() {
        player.setHolding(null);
        player.setLocation(null);

        inputBoundary.interact("NonExistentItem");

        assertTrue(testOutputBoundary.getMessages().contains("You have nothing in your hand or standing beside anything to interact with."));
    }

    // --- Tests for interact(String holdingWhat, String itemAtLocation) ---
    @Test
    void testInteractWithMatchingItems() {
        Item key = new Item("key", "A key to unlock the door");
        Item exit = new Item("exit", "The exit door");

        player.setHolding(key);
        player.setLocation(exit);

        inputBoundary.interact("key", "exit");

        assertTrue(testOutputBoundary.getMessages().contains("Congratulations! You successfully unlocked the exit."));
    }

    @Test
    void testInteractWithMismatchedHeldItem() {
        Item sword = new Item("Sword", "A sharp blade");
        Item exit = new Item("exit", "The exit door");

        player.setHolding(sword);
        player.setLocation(exit);

        inputBoundary.interact("key", "exit");

        assertTrue(testOutputBoundary.getMessages().contains("You are holding Sword instead of key."));
    }

    @Test
    void testInteractWithNoItemAtLocation() {
        Item key = new Item("key", "A key to unlock the door");
        player.setHolding(key);
        player.setLocation(null);

        inputBoundary.interact("key", "exit");

        assertTrue(testOutputBoundary.getMessages().contains("You have nothing to interact with."));
    }

    @Test
    void testInteractWithMismatchedNearbyItem() {
        Item key = new Item("key", "A key to unlock the door");
        Item chest = new Item("chest", "A locked chest");

        player.setHolding(key);
        player.setLocation(chest);

        inputBoundary.interact("key", "exit");

        assertTrue(testOutputBoundary.getMessages().contains("You are not next to exit."));
    }

    @Test
    void testInteractWithNoHeldItem() {
        Item exit = new Item("exit", "The exit door");
        player.setHolding(null);
        player.setLocation(exit);

        inputBoundary.interact("key", "exit");

        assertTrue(testOutputBoundary.getMessages().contains("You have nothing in your hand to interact with."));
    }

    // --- Tests for inspectBag() ---
    @Test
    void testInspectBagEmpty() {
        inputBoundary.inspectBag();

        assertTrue(testOutputBoundary.getMessages().contains("Your bag is empty."));
    }

    @Test
    void testInspectBagWithItems() {
        Item sword = new Item("Sword", "A sharp blade");
        Item potion = new Item("Potion", "Restores health");
        inventory.addItem(sword);
        inventory.addItem(potion);

        inputBoundary.inspectBag();

        assertTrue(testOutputBoundary.getMessages().contains("Items in your bag:"));
        assertTrue(testOutputBoundary.getMessages().contains("- Sword: A sharp blade"));
        assertTrue(testOutputBoundary.getMessages().contains("- Potion: Restores health"));
    }

    // --- Helper Class ---
    static class TestOutputBoundary implements outputBoundaryInterface {
        private final List<String> messages = new ArrayList<>();

        @Override
        public void displayMessage(String message) {
            messages.add(message);
        }

        @Override
        public void displayBagContents(List<Item> items) {
            messages.add("Items in your bag:");
            for (Item item : items) {
                messages.add("- " + item.getName() + ": " + item.getDescription());
            }
        }

        public List<String> getMessages() {
            return messages;
        }
    }
}

