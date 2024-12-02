package User_case.Items_Usercase;
import Entity.Item.Item;
import Entity.Item.Exit;
import Entity.Item.Key;

public class ExitInputBoundary implements ExitInputBoundaryInterface{

    private Exit exit; // Exit object to be interacted with
    private ExitOutputBoundaryInterface OutputBoundary;

    // Constructor that takes an NPC object
    public ExitInputBoundary(Exit exit, ExitOutputBoundaryInterface OutputBoundary) {
        this.exit = exit;
        this.OutputBoundary = OutputBoundary;
    }

    @Override
    public void interact(Item inhand) {
        if (exit.getLocked() && inhand.getType() != "Key") {
            OutputBoundary.displayOutput("you tried to pick the lock but it didn't work");
        }
        else if (exit.getLocked() && inhand.getType() == "Key") {
        Key keyInHand = (Key) inhand;

        if (keyInHand.isUsed()) {
            OutputBoundary.displayOutput(keyInHand.getName() + " does not match the" + exit.getName());
        }
        else {
            exit.setLocked(false);  // Unlock the exit
            keyInHand.setUsed(true);  // Mark the key as used
            OutputBoundary.displayOutput("You unlocked the door!");
        }
        }

        else {
            OutputBoundary.displayOutput("the door is already opened");
        }
    }

    @Override
    public void interact() {
        if (exit.getLocked()) {
            OutputBoundary.displayOutput("the door is still blocked and you cannot pass");
        }
        else {
            System.out.println("You walk into the door and leave the room.");
            exit.getwhichRoom().leave();
        }
    }

    @Override
    public Item pickup() {
        OutputBoundary.displayOutput("You can't just lift the exit, silly!");
        return null;
    }
}
