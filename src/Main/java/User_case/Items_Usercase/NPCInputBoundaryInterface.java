package User_case.Items_Usercase;

import Entity.Item.Item;

public interface NPCInputBoundaryInterface {

    // Method for interacting with the item (to be implemented by concrete classes)
    void interact(Item location);

    // Method to pick up the item
    Item pickup();
}
