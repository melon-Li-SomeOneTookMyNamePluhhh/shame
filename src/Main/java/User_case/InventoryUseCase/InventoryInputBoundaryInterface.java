package User_case.InventoryUseCase;

import Entity.Item;
import java.util.List;

public interface InventoryInputBoundaryInterface {
    /**
     * Adds an item to the inventory.
     * @param item The item to add.
     */
    void addItem(Item item);

    /**
     * Removes an item from the inventory by name.
     * @param itemName The name of the item to remove.
     */
    void removeItem(String itemName);

    /**
     * Inspects the inventory and returns the list of items inside.
     * @return A list of items currently in the inventory.
     */
    List<Item> inspectBag();
}

