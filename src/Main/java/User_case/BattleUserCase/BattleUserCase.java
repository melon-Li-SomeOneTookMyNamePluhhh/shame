package User_case.BattleUserCase;

import Entity.Battle;
import Entity.Enemy;
import Entity.Player;
import Entity.Item;
import Frameworks_and_drivers.GUIUtility;
import User_case.EnemyUseCase.EnemyInputBoundary;

import java.util.List;

public class BattleUserCase implements BattleInputBoundaryInterface{
    private Battle battle;
    private final BattleOutputBoundary outputBoundary;

    public BattleUserCase(Battle battle, BattleOutputBoundary outputBoundary) {
        this.battle = battle;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void askForEquipment(Player player) {
        List<Item> itemsInBag = player.getInventory().getItemsInside();
        if (itemsInBag.isEmpty()) {
            outputBoundary.displayMessage("Your bag is empty! No equipment to choose.");
            return;
        }

        String[] options = itemsInBag.stream().map(Item::getName).toArray(String[]::new);
        String chosenItemName = (String) GUIUtility.getInput("Choose an item from your bag:", options);

        if (chosenItemName == null) {
            outputBoundary.displayMessage("No item selected.");
            return;
        }

        itemsInBag.stream()
                .filter(item -> item.getName().equalsIgnoreCase(chosenItemName))
                .findFirst()
                .ifPresentOrElse(item -> {
                    player.setDamage(player.getDamage() + item.getDamage());
                    outputBoundary.displayMessage("Equipped: " + item.getName() + ". New damage: " + player.getDamage());
                }, () -> outputBoundary.displayMessage("Invalid selection."));
    }

    @Override
    public void compareElement(Player player, Item equipment, Enemy enemy) {
        if (equipment == null || enemy == null) {
            outputBoundary.displayMessage("Element comparison failed.");
            return;
        }

        String playerElement = Item.getElement().toLowerCase();
        String enemyElement = enemy.getType().toLowerCase();
        double multiplier = switch (playerElement) {
            case "fire" -> enemyElement.equals("grass") ? 1.2 : enemyElement.equals("water") ? 0.8 : 1.0;
            case "grass" -> enemyElement.equals("water") ? 1.2 : enemyElement.equals("fire") ? 0.8 : 1.0;
            case "water" -> enemyElement.equals("fire") ? 1.2 : enemyElement.equals("grass") ? 0.8 : 1.0;
            default -> 1.0;
        };
        int newDamage = (int) Math.ceil(player.getDamage() * multiplier);
        player.setDamage(newDamage);

        outputBoundary.displayMessage("Element comparison complete. New damage: " + newDamage);
    }

    @Override
    public void battleRound(Player player, Enemy enemy, EnemyInputBoundary boundary) {
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int enemyDamage = boundary.performAction();
            player.setHealth(player.getHealth() - enemyDamage);
            enemy.setHealth(enemy.getHealth() - player.getDamage());

            outputBoundary.displayMessage("Player health: " + player.getHealth());
            outputBoundary.displayMessage("Enemy health: " + enemy.getHealth());

            if (player.getHealth() <= 0) {
                outputBoundary.displayMessage("You were defeated!");
                return;
            } else if (enemy.getHealth() <= 0) {
                outputBoundary.displayMessage("Enemy defeated!");
                return;
            }
        }
    }
    }
