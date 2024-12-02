package User_case.InventoryUseCase;

import Entity.Inventory;
import Entity.Item;
import java.util.List;

/**
 * The InventoryInputBoundary class implements inventory actions.
 * It manages the operations to add and remove items.
 */
public class InventoryInputBoundary implements InventoryInputBoundaryInterface {
    protected Inventory inventory;

    /**
     * Constructs an InventoryInputBoundary with the specified inventory.
     * @param inventory The Inventory object representing the player's inventory.
     */
    public InventoryInputBoundary(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addItem(Item item) {
        if (inventory.getNumItemsInside() < inventory.getBagSize()) {
            inventory.addItemInternal(item);
        } else {
            System.out.println("Cannot add item. Inventory is full.");
        }
    }

    @Override
    public void removeItem(String itemName) {
        if (inventory.getNumItemsInside() == 0) {
            System.out.println("Cannot remove item. Inventory is empty.");
            return;
        }

        Item removedItem = inventory.removeItemInternal(itemName);
        if (removedItem == null) {
            System.out.println("Item " + itemName + " not found in the inventory.");
        } else {
            System.out.println("Item " + itemName + " has been removed from the inventory.");
        }
    }

    @Override
    public List<Item> inspectBag() {
        return inventory.getItemsInside();
    }
}


