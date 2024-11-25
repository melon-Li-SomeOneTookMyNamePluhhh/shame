package Item;

import GUI.GUIUtility;

// MAKE THIS INTO INTERFACE!!!!!!!!!!!!!!!!!!!!!!!!!!
// Define an abstract class called Item.Item (Not an interface because we need instance variables)
public abstract class Item {
    private String name;
    private String description;
    private String floorDescription;
    private String type;
    private Boolean locked;

    // This is a constructor for Item.Item; it cannot be directly instantiated but can be used by concrete subclasses.
    public Item(String s, String name, String description, String floorDescription, int damage, String type) {
        this.name = name;
        this.description = description;
        this.floorDescription = floorDescription;
        // item on ground should have different discription compared with item picked up & in inventory
        this.type = type;
        this.locked = false;
    }
    // overide when need to be locked
    public Item(String name, String description, String floorDescription,String type, Boolean locked) {
        this.name = name;
        this.description = description;
        this.floorDescription = floorDescription;
        // item on ground should have different discription compared with item picked up & in inventory
        this.type = type;
        this.locked = locked;
        //
    }

    // Abstract method to interact with the item
    public abstract void Interact(Item location);

    // Regular method to pick up the item
    // this method should to regularly overrided such that awkward moment of you picked up exit will not happen
    public Item pickup() {
        return null;
    }

    // Regular method to inspect the item (has a body)
    public void Inspect() {
        GUIUtility.displayOutput("Inspecting the item: " + name + ": " + description + ".");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFloorDescription() {
        return floorDescription;
    }

    public boolean getLocked(){
        return locked;
    }

    public String getType() {
        return type;
    }

    public void setLocked(boolean key) {
        this.locked = key;
    }
}

