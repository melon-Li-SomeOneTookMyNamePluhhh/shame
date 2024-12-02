package User_case.Items_Usercase;

import Entity.Item.Item;

public interface ExitInputBoundaryInterface {

    // Method for interacting with the item (to be implemented by concrete classes)
    void interact(Item location);

    //Method for Interacting when you just want to interact with the door with nothing
    void interact();

    // Method to pick up the item
    Item pickup();
}
