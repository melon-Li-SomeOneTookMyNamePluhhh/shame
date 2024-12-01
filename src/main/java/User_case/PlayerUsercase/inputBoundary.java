package User_case.PlayerUsercase;

import Entity.Player;
import Entity.Item;
import Entity.Room;
import Entity.Inventory;

import java.util.List;

/**
 * The inputBoundary class implements player actions and interactions in the game.
 * It processes user commands and delegates display messages to the outputBoundary.
 */
public class inputBoundary implements inputBoundaryInterface {
    private Player player;
    private outputBoundaryInterface outputBoundary;

    /**
     * Constructs an inputBoundary with the specified player and outputBoundary interface.
     * @param player The Player object representing the user in the game.
     * @param outputBoundary The interface responsible for displaying messages to the user.
     */
    public inputBoundary(Player player, outputBoundaryInterface outputBoundary) {
        this.player = player;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Moves the player to the specified item's location within the current room.
     * @param itemName The name of the item the player wishes to walk to.
     */
    @Override
    public void walkTo(String itemName) {
        if (player.getCurrRoom().hasItem(itemName) == null) {
            outputBoundary.displayMessage("You can't walk to that destination as it doesn't exist.");
            return;
        }
        outputBoundary.displayMessage("You walked to " + itemName);
        player.setLocation(player.getCurrRoom().hasItem(itemName));
        if (checkBattle(player.getCurrRoom().hasItem(itemName))) {
            player.getCurrRoom().launchBattle(player.getCurrRoom().hasItem(itemName));
        }
    }

    /**
     * Picks up the specified item if the player's hands are free and the item is nearby.
     * @param itemName The name of the item the player wishes to pick up.
     */
    @Override
    public void pickUp(String itemName) {
        if (player.getHolding() != null) {
            outputBoundary.displayMessage("You can't pick up an item when you are holding something.");
            return;
        }
        if (player.getLocation() == null) {
            outputBoundary.displayMessage("There is nothing around you to pick up!");
            return;
        }
        if (player.getLocation().getName().equals(itemName)) {
            player.setHolding(player.getCurrRoom().pickUp(itemName));
            player.setLocation(null);
        } else {
            outputBoundary.displayMessage("You did not find " + itemName + " around you.");
        }
    }

    /**
     * Interacts with an item either in the player's hand or nearby.
     * @param whatItem The name of the item to interact with.
     */
    @Override
    public void interact(String whatItem) {
        if (player.getHolding() == null && player.getLocation() == null) {
            outputBoundary.displayMessage("You have nothing in your hand or standing beside anything to interact with.");
            return;
        }

        if (player.getHolding() != null && player.getHolding().getName().equals(whatItem)) {
            outputBoundary.displayMessage("Looking at the " + whatItem + ", you decide to take a bite.");
            if (player.getHolding().getDamage() >= 0) {
                outputBoundary.displayMessage("This is a bad decision.");
                outputBoundary.displayMessage("You lost " + player.getHolding().getDamage() + " health.");
                player.setHealth(player.getHealth() - player.getHolding().getDamage());
            } else if (player.getHolding().getDamage() < 0) {
                outputBoundary.displayMessage("You healed " + -1 * player.getHolding().getDamage() + " health.");
                player.setHealth(player.getHealth() - player.getHolding().getDamage());
            }
            return;
        }

        if (player.getLocation() != null && player.getLocation().getName().equals(whatItem)) {
            player.getLocation().interact();
            return;
        }

        outputBoundary.displayMessage("You are not holding " + whatItem + " or standing next to it.");
    }

    /**
     * Inspects the player's bag and lists the contents.
     */
    @Override
    public void inspectBag() {
        List<Item> items = player.getInventory().getItemsInside();
        if (items.isEmpty()) {
            outputBoundary.displayMessage("Your bag is empty.");
        } else {
            outputBoundary.displayBagContents(items);
        }
    }

    /**
     * Retrieves an item from the player's bag and places it in their hand.
     * @param itemName The name of the item to retrieve from the bag.
     */
    @Override
    public void getFromBag(String itemName) {
        if (player.getHolding() != null) {
            outputBoundary.displayMessage("You are already holding something. Put it in your bag or drop it first.");
            return;
        }
        Item retrievedItem = player.getInventory().removeItem(itemName);
        if (retrievedItem != null) {
            outputBoundary.displayMessage("You took " + itemName + " out of your bag.");
            player.setHolding(retrievedItem);
        } else {
            outputBoundary.displayMessage("The item " + itemName + " is not in your bag.");
        }
    }

    /**
     * Drops the item currently held by the player at their current location.
     */
    @Override
    public void drop() {
        if (player.getHolding() == null) {
            outputBoundary.displayMessage("You have nothing to drop.");
        } else {
            player.setLocation(player.getHolding());
            player.setHolding(null);
        }
    }

    /**
     * Puts the currently held item into the player's bag.
     */
    public void putInBag() {
        if (player.getHolding() == null) {
            outputBoundary.displayMessage("You have nothing to put in the inventory.");
        } else {
            if (player.getInventory().getNumItemsInside() < player.getInventory().getBagSize()) {
                player.getInventory().addItem(player.getHolding());
                outputBoundary.displayMessage("You put " + player.getHolding().getName() + " in your bag.");
                player.setHolding(null);
            } else {
                outputBoundary.displayMessage("Your inventory is full.");
            }
        }
    }

    /**
     * Interacts with an item in the player's hand and an item at the current location.
     * @param holdingWhat The name of the item the player is holding.
     * @param itemAtLocation The name of the item at the player's location.
     */
    @Override
    public void interact(String holdingWhat, String itemAtLocation) {
        if (player.getHolding() == null) {
            outputBoundary.displayMessage("You have nothing in your hand to interact with.");
            return;
        }

        if (!player.getHolding().getName().equals(holdingWhat)) {
            outputBoundary.displayMessage("You are holding " + player.getHolding().getName() + " instead of " + holdingWhat + ".");
            return;
        }

        if (player.getLocation() == null) {
            outputBoundary.displayMessage("You have nothing to interact with.");
            return;
        }

        if (!player.getLocation().getName().equals(itemAtLocation)) {
            outputBoundary.displayMessage("You are not next to " + itemAtLocation + ".");
            return;
        }

        if (holdingWhat.equals("key") && itemAtLocation.equals("exit")) {
            outputBoundary.displayMessage("Congratulations! You successfully unlocked the exit.");
            return;
        }

        outputBoundary.displayMessage("You tried to interact " + holdingWhat + " with " + itemAtLocation + ".");
        player.getHolding().interact(player.getLocation());
        player.getLocation().interact(player.getHolding());
    }


    /**
     * Checks if a battle should be triggered for the specified item in the player's current room.
     *
     * @param item The {@code Item} to check for a potential battle.
     * @return {@code true} if a battle is triggered for the specified item, {@code false} otherwise.
     */
    public boolean checkBattle(Item item){
        return player.getCurrRoom().checkBattle(item);
    }
}

