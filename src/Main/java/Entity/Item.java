package Entity;

public abstract class Item {
    private String name;
    private String description;
    private String floorDescription;
    private String type;
    private boolean locked;
    private String element;


    // This is a constructor for Item; it cannot be directly instantiated but can be used by concrete subclasses.
    public Item(String name, String description, String floorDescription, String type, String element) {
        this.name = name;
        this.description = description;
        this.floorDescription = floorDescription;
        // item on ground should have different description compared with item picked up & in inventory
        this.type = type;
        this.element = element;
    }
    // Abstract method to interact with the item

    public String getElement(){return element;}

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

    public int getDamage() {return 0;}

}