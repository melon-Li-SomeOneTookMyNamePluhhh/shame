package User_case.InventoryUseCase;

import Entity.Item;

public interface InventoryInputBoundary {
    void addItem(Item item);
    void removeItem(String itemName);
}
