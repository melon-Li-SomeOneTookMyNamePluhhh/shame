package Entity;

import java.util.ArrayList;
import java.util.List;

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
        return new ArrayList<>(itemsInside); // 返回副本以保护内部列表
    }

    // 添加和移除物品的方法移到用例层处理
    public void addItemInternal(Item item) {
        itemsInside.add(item);
    }

    public void removeItemInternal(Item item) {
        itemsInside.remove(item);
    }
}