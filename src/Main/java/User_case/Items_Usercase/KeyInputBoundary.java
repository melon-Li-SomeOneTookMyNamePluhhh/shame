package User_case.Items_Usercase;

import Entity.Item;
import Entity.Key;

public class KeyInputBoundary implements KeyInputBoundaryInterface {

    private Key key; // Key object to be interacted with
    private KeyOutputBoundaryInterface OutputBoundary;

    // Constructor that takes an NPC object
    public KeyInputBoundary(Key key, KeyOutputBoundaryInterface OutputBoundary) {
        this.key = key;
        this.OutputBoundary = OutputBoundary;
    }

    @Override
    public void interact(Item player_location) {
        if (player_location.getType() == "Exit" && key.isUsed()) {
            OutputBoundary.displayOutput(key.getName() + " does not match the" + player_location.getName());
        } else if (player_location.getType() == "Exit" && key.isUsed() == false) {
            OutputBoundary.displayOutput("You have cleared the " + player_location.getName() + " you can leave the room at anytime");
            player_location.setLocked(false);
            key.setUsed(true);
        } else {
            OutputBoundary.displayOutput("you poked the" + key.getName() + " onto " + player_location.getName() + " nothing happens");
        }
        return;
    }

    @Override
    public Item pickup() {
        OutputBoundary.displayOutput("You have picked up the " + key.getName());
        return key;
    }
}


