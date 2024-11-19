package Item;

public class Equipment extends Item {
    int damage;
    String element;

    // Constructor for Item.Equipment that calls the Item.Item constructor and has default damage and element
    public Equipment(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, name, description, floorDescription, damage, "Item.Equipment"); // Pass values to the superclass constructor
        this.damage = damage;
        this.element = element;
    }

    @Override
    public void Interact(Item location) {
        System.out.println("This is a piece of equipment.");
    }
}
