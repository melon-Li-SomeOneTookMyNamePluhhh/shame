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
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in your inventory:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
