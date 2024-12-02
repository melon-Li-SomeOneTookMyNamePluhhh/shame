package User_case.InventoryUseCase;

import Entity.Item;
import java.util.List;

/**
 * The InventoryOutputBoundary class implements the presentation logic for inventory actions,
 * sending the output to the appropriate medium, such as a console.
 */
public class InventoryOutputBoundary implements InventoryOutputBoundaryInterface {

    @Override
    public void presentAddItem(String message) {
        System.out.println(message);
    }

    @Override
    public void presentRemoveItem(String message) {
        System.out.println(message);
    }

    @Override
    public void presentInventoryContents(List<Item> items) {
        if (items.isEmpty()) {
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("Your inventory is empty.");
        } else {
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("Items in your inventory:");
            for (Item item : items) {
                guiUtility.displayOutput("- " + item.getName());
            }
        }
    }
}
