package Item;

public class Exit extends Item{
    private Boolean locked = true;

    // Constructor for Item.Exit that calls the Item.Item constructor
    public Exit(String name, String description, String floorDescription) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription, "Exit"); // Pass values to the superclass constructor
    }

    @Override
    public void Interact(Item location) {
        // TODO: we can use this code once we have a game with current player as a global variable
        if (this.locked) {
            System.out.println("you tried to pick the lock but it didn't work");
        }
        else {
            System.out.println("the door is already opened, there is no point trying to pick the lock");
        }
    }

    // it is possible that player interacts sth with no other items
    public void Interact() {
        // TODO: we can use this code once we have a game with current player as a global variable
        if (this.locked) {
            System.out.println("the door is still locked and you cannot pass");
        }
        else {
            System.out.println("You walk into the door and leave the room.");
        }
    }

    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean lock) {
        this.locked = lock;
    }

    @Override
    public Item pickup() {
        System.out.println("You can't just lift the exit, silly!");
        return null;
    }
}
