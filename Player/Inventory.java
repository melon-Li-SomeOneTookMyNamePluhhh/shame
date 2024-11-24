package Player;

import java.util.ArrayList;
import java.util.List;
import Item.Item;

public class Inventory {
    private int bagSize;
    private List<Item> itemsInside;

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

    public List<Item> getItemsInside() {
        return itemsInside;
    }

    // Add item
    public void addItem(Item item) {
        itemsInside.add(item);
    }

    // Remove item
    public Item removeItem(String itemName) {
        if(itemsInside.isEmpty()) {
            System.out.println("you have nothing in your bag!");
            return null;
        }
        // cannot iterate through empty list, must remain. Room does not need to worry
        // as there is always exit in room
        Item i = null;
        for (Item item : itemsInside) {
            if (item.getName().equals(itemName)) {
                i = item;
                itemsInside.remove(item);
                return item;
                // return item once it is found instead of keep iterating
            }
        }
        return i;
    }
}