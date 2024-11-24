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
        Item itemToRemove = findItem(itemName);
        if (itemToRemove != null) {
            itemsInside.remove(itemToRemove);
            return itemToRemove;
        }
        System.out.println("can not find\"" + itemName + "\"in bag");
        return null;
    }


    public Item findItem(String itemName){
        for (Item item : itemsInside){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }
}