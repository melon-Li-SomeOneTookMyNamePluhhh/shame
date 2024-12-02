package Battle;

import Player.Player;
import Item.Item;
import Item.Equipment;
import Enemy.Enemy;
import GUI.GUIUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {
    private Player player;
    private Enemy enemy;
    private boolean specialUsed;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.specialUsed = false;
    }

    /**
     * Asks the user to choose an item from the player's inventory
     * and adds its damage to the player's total damage.
     */
    public void askForEquipment() {
        List<Item> itemsInBag = player.getInventory().getItemsInside();
        if (itemsInBag.isEmpty()) {
            GUIUtility.displayOutput("Your bag is empty! No equipment to choose.");
            return;
        }

        // Create a list of item names for the GUI
        List<String> itemNames = new ArrayList<>();
        for (Item item : itemsInBag) {
            itemNames.add(item.getName());
        }
        String[] options = itemNames.toArray(new String[0]);

        // Ask the user to choose an item
        String chosenItemName = (String) GUIUtility.getInput("Choose an item from your bag:", options);
        if (chosenItemName == null) {
            GUIUtility.displayOutput("No item selected.");
            return;
        }

        // Find the selected item and add its damage to the player's damage
        for (Item item : itemsInBag) {
            if (item.getName().equalsIgnoreCase(chosenItemName)) {
                player.setDamage(player.getDamage() + item.getDamage());
                GUIUtility.displayOutput("You chose: " + chosenItemName + ". Your new damage is: " + player.getDamage());
                return;
            }
        }

        GUIUtility.displayOutput("Invalid selection. No damage added.");
    }

    /**
     * Compares the element of the player's item with the enemy's element
     * and adjusts the player's damage accordingly.
     * @param item  The player's chosen item.
     * @param enemy The enemy being fought.
     */
    public void compareElement(Equipment item, Enemy enemy) {
        String playerElement = item.getElement().toLowerCase();
        String enemyElement = enemy.getType().toLowerCase();

        // Calculate damage multiplier based on element comparison
        double multiplier = 1.0;
        if (playerElement.equals("fire") && enemyElement.equals("grass") ||
                playerElement.equals("grass") && enemyElement.equals("water") ||
                playerElement.equals("water") && enemyElement.equals("fire")) {
            multiplier = 1.2; // Player has an advantage
        } else if (playerElement.equals("fire") && enemyElement.equals("water") ||
                playerElement.equals("grass") && enemyElement.equals("fire") ||
                playerElement.equals("water") && enemyElement.equals("grass")) {
            multiplier = 0.8; // Player is at a disadvantage
        }

        // Update player's damage and ensure it's rounded up to the nearest integer
        int newDamage = (int) Math.ceil(player.getDamage() * multiplier);
        player.setDamage(newDamage);

        // Display the result to the user
        GUIUtility.displayOutput("Element comparison: " +
                "\nPlayer's element: " + playerElement +
                "\nEnemy's element: " + enemyElement +
                "\nYour damage is now: " + newDamage);
    }


    /**
     * Executes a single round of battle between the player and the enemy.
     * Each round updates health and checks for the end of the battle.
     */
    public void battleRound() {
        // Loop while both player and enemy are alive
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            // Enemy attacks player
            int enemyDamage = enemy.performAction();
            player.setHealth(player.getHealth() - enemyDamage);

            // Player attacks enemy
            enemy.setHealth(enemy.getHealth() - player.getDamage());

            // Display updated health
            GUIUtility.displayOutput("Your remaining health: " + player.getHealth());
            GUIUtility.displayOutput(enemy.getName() + "'s remaining health: " + enemy.getHealth());

            // Check if anyone is defeated
            if (player.getHealth() <= 0) {
                GUIUtility.displayOutput("You have been defeated!");
                return;
            } else if (enemy.getHealth() <= 0) {
                GUIUtility.displayOutput("You have defeated the enemy!");
                return;
            }
        }
    }
}