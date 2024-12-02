package Entity.Item;

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

    public int getDamage() {return damage;}

    public String getElement() {
        return element;
    }



}