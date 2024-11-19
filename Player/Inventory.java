package Player;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int bagSize;
    private List<String> itemsInside;

    public Inventory(int bagSize) {
        this.bagSize = bagSize;
        this.itemsInside = new ArrayList<>();
    }

    public int getBagSize() {
        return bagSize;
    }

    public int getNumItemsInside() {
        return itemsInside.size();
    }

    public List<String> getItemsInside() {
        return itemsInside;
    }

    // Add item
    public void addItem(String item) {
        itemsInside.add(item);
    }

    // Remove item
    public void removeItem(String item) {
        itemsInside.remove(item);
    }
}