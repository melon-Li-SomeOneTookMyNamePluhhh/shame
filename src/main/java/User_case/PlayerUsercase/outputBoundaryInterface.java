package User_case.PlayerUsercase;

import java.util.List;
import Entity.Item;

/**
 * The outputBoundaryInterface defines methods for displaying messages and
 * player-related information, such as bag contents, in the game.
 */
public interface outputBoundaryInterface {

    /**
     * Displays a general message to the player.
     * @param message The message to be displayed.
     */
    void displayMessage(String message);

    /**
     * Displays the contents of the player's bag, listing each item by name and description.
     * @param items The list of items in the player's bag.
     */
    void displayBagContents(List<Item> items);
}
