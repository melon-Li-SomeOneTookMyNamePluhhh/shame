package User_case.InventoryUseCase;

import Entity.Item;

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
}

