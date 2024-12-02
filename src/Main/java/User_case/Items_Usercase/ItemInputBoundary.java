package User_case.Items_Usercase;

import Entity.Item;

public class ItemInputBoundary implements ItemInputBoundaryInterface {

    private Item item; // Key object to be interacted with
    private ItemOutputBoundaryInterface OutputBoundary;

    // Constructor that takes an NPC object
    public ItemInputBoundary(Item item, ItemOutputBoundaryInterface OutputBoundary) {
        this.item = item;
        this.OutputBoundary = OutputBoundary;
    }

    // Regular method to inspect the item (has a body)
    public void Inspect() {
        OutputBoundary.displayOutput("Inspecting the item: " + item.getName() + ": " + item.getDescription() + ".");
    }
    // Regular method to pick up the item
    // this method should to regularly overrided such that awkward moment of you picked up exit will not happen


}

