public class Equipment extends Item {
    int damage;
    String element;

    // Constructor for Equipment that calls the Item constructor and has default damage and element
    public Equipment(String name, String description) {
        // Call the constructor of Item class with parameters
        super(name, description, "Equipment"); // Pass values to the superclass constructor
        this.damage = 1;
        this.element = "Regular";
    }

    // Overloaded constructor for Equipment that calls the Item constructor and sets damage and element for the equipment
    public Equipment(String name, String description, int damage, String element) {
        // Call the constructor of Item class with parameters
        super(name, description, "Equipment"); // Pass values to the superclass constructor
        this.damage = damage;
        this.element = element;
    }

    @Override
    public void Interact() {
        System.out.println("This is a piece of equipment.");
    }
}
