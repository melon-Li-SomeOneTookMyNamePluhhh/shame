package Entity;

public class Key extends Item {
    int damage = 1;
    boolean used = false; // yeah we need this

    // Constructor for Item.Key that calls the Item.Item constructor
    public Key(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription, "Key", element); // Pass values to the superclass constructor
        this.damage = damage;
    }
    @Override
    public int getDamage() {return damage;}

    public String getElement() {
        return element;
    }

    public boolean isUsed() {return used;}

    public void setUsed(boolean used) {this.used = used;}

}
