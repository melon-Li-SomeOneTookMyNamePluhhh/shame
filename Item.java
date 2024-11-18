// Define an abstract class called Item (Not an interface because we need instance variables)
public abstract class Item {
    String name;
    String description;
    String type;

    // This is a constructor for Item; it cannot be directly instantiated but can be used by concrete subclasses.
    public Item(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    // Abstract method to interact with the item
    public abstract void Interact();

    // Regular method to pick up the item
    public void Pickup() {
        System.out.println("You picked up the item: " + name + ".");
        // currentplayer.put_in_bag(name) #This section to be coded when all sections are put together and once we have a game with currentplayer as a global variable
    }

    // Regular method to inspect the item (has a body)
    public void Inspect() {
        System.out.println("Inspecting the item: " + name + ": " + description + ".");
    }

    // A method to return a string representation of the item
    public String toStr(){
        return name + ": " + description;
    }
}

