package User_case.InventoryUseCase;

import Entity.Item;
import java.util.List;

public interface InventoryOutputBoundaryInterface {
    /**
     * Presents the result of adding an item.
     * @param message The message to be presented to the user.
     */
    void presentAddItem(String message);

    /**
     * Presents the result of removing an item.
     * @param message The message to be presented to the user.
     */
    void presentRemoveItem(String message);

    /**
     * Displays the contents of the inventory.
     * @param items A list of items to be displayed.
     */
    void presentInventoryContents(List<Item> items);
}

