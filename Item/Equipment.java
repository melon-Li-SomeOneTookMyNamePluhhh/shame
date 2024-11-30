package Item;

import GUI.GUIUtility;

public class Equipment extends Item {
    private int damage; // Instance field for damage
    private String element; // Instance field for element

    // Constructor for Equipment that calls the Item constructor
    public Equipment(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of the Item class with parameters
        super(name, description, floorDescription, "Equipment"); // Pass values to the superclass constructor
        this.damage = damage; // Initialize damage
        this.element = element; // Initialize element
    }

    // Getter for damage
    public int getDamage() {
        return damage;
    }

    // Getter for element
    public String getElement() {
        return element;
    }

    // Implement the abstract method interact(Item)
    @Override
    public void interact(Item location) {
        GUIUtility.displayOutput("This is a piece of equipment.");
    }

    // Override the pickup method
    @Override
    public Item pickup() {
        System.out.println("You picked up " + this.getName());
        return this;
    }
}
