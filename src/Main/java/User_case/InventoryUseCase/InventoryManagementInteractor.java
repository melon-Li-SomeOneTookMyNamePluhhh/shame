package User_case.InventoryUseCase;

import Entity.Inventory;
import Entity.Item;

public class InventoryManagementInteractor implements InventoryInputBoundary {
    private final Inventory inventory;
    private final InventoryOutputBoundary outputBoundary;

    public InventoryManagementInteractor(Inventory inventory, InventoryOutputBoundary outputBoundary) {
        this.inventory = inventory;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void addItem(Item item) {
        if (inventory.getNumItemsInside() < inventory.getBagSize()) {
            inventory.addItemInternal(item);
            outputBoundary.presentAddItem(item.getName() + " has been added to your inventory.");
        } else {
            outputBoundary.presentAddItem("Your bag is full, you can't add " + item.getName() + ".");
        }
    }

    @Override
    public void removeItem(String itemName) {
        if (inventory.getNumItemsInside() == 0) {
            outputBoundary.presentRemoveItem("You have nothing in your bag!");
            return;
        }

        for (Item item : inventory.getItemsInside()) {
            if (item.getName().equals(itemName)) {
                inventory.removeItemInternal(item);
                outputBoundary.presentRemoveItem(item.getName() + " has been removed from your inventory.");
                return;
            }
        }

        outputBoundary.presentRemoveItem(itemName + " was not found in your inventory.");
    }
}

