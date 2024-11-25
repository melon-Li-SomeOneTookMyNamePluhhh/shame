package Item;

import GUI.GUIUtility;

public class Key extends Item{
    int damage;
    String element = "Regular";

    // Constructor for Item.Key that calls the Item.Item constructor
    public Key(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"Key", damage, element); // Pass values to the superclass constructor
    }

    @Override
    public void Interact(Item player_location) {
        // TODO: We should have a game with the current player as a global variable. A current player will have a location.
        if (player_location.gettype() == "Exit" && player_location.getLocked() == true && this.getused() == false){
          location.setLocked(false);
            GUIUtility.displayOutput("You have unlocked the exit");
        }
        else if (player_location.gettype() == "Exit" && player_location.getLocked() == true && this.getused() == true){
            GUIUtility.displayOutput("You are using the wrong key for this exit.");
        }
        else if (player_location.gettype() == "Exit" && player_location.getLocked() == false){
            GUIUtility.displayOutput("The exit you are at is already unlocked!");
        }
        else {
            GUIUtility.displayOutput("You are not standing at an exit!");
        }

    }

    @Override
    public Item pickup(){
        GUIUtility.displayOutput("You have picked up the key");
        return this;
    }
}
