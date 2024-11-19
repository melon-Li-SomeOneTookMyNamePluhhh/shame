package Item;

public class Equipment extends Item {
    int damage;
    String element;

    // Constructor for Item.Equipment that calls the Item.Item constructor and has default damage and element
    public Equipment(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription, "Equipment"); // Pass values to the superclass constructor
        this.damage = damage;
        this.element = element;
    }

    @Override
    public void Interact(Item location) {
        System.out.println("This is a piece of equipment.");
    }


    @Override
    public Item pickup() {
        System.out.println("You pickup" + this.getName());
        return this;
    }
}