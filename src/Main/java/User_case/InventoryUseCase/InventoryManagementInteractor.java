package User_case.InventoryUseCase;

import Entity.Inventory;
import Entity.Item;
import java.util.List;

/**
 * The InventoryManagementInteractor class extends InventoryInputBoundary and
 * provides concrete implementations of inventory operations with user feedback.
 */
public class InventoryManagementInteractor extends InventoryInputBoundary {
    private final InventoryOutputBoundaryInterface outputBoundary;

    public InventoryManagementInteractor(Inventory inventory, InventoryOutputBoundaryInterface outputBoundary) {
        super(inventory); // 调用父类构造函数来初始化库存
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void addItem(Item item) {
        if (inventory.getNumItemsInside() < inventory.getBagSize()) {
            inventory.addItemInternal(item);
            outputBoundary.presentAddItem("The item " + item.getName() + " has been added to your inventory.");
        } else {
            outputBoundary.presentAddItem("Cannot add item. Inventory is full.");
        }
    }

    @Override
    public Item removeItem(String itemName) {
        if (inventory.getNumItemsInside() == 0) {
            outputBoundary.presentRemoveItem("Cannot remove item. Inventory is empty.");
            return null;
        }

        List<Item> items = inventory.getItemsInside();
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                outputBoundary.presentRemoveItem("Item " + itemName + " has been removed from the inventory.");
                return item; // 找到物品后立即返回
            }
        }

        outputBoundary.presentRemoveItem("Item " + itemName + " not found in the inventory.");
        return null;
    }

    @Override
    public List<Item> inspectBag() {
        List<Item> items = inventory.getItemsInside();
        outputBoundary.presentInventoryContents(items);
        return items;
    }
}




