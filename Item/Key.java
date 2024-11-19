package Item;

public class Key extends Item{
    int damage;
    String element = "Regular";

    // Constructor for Item.Key that calls the Item.Item constructor
    public Key(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"Key", damage, element); // Pass values to the superclass constructor
    }

    @Override
    public void Interact(Item location) {
        // TODO: we can use this code once we have a game with currentplayer as a global variable and a location() method for all items.
        if (location.getName() == "exit" && location.getLocked() == true){
          location.setLocked(false);
          System.out.println("You have unlocked the exit");
        }
        else {
          System.out.println("you tried to poke the key into thin air, nothing happens");
        }

    }

    @Override
    public Item pickup(){
        System.out.println("You have picked up the key");
        return this;
    }
}
