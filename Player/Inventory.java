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
        for (int i = 0; i < itemsInside.size(); i++) {
            Item item = itemsInside.get(i);
            if (item.getName().equals(itemName)) {
                itemsInside.remove(i);
                return item;
            }
        }
        return null; // 如果未找到对应的Item，返回null
    }

    public Item findItem(String itemName){
        for (Item item : itemsInside){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null; // 如果未找到对应的Item，返回null
    }
}