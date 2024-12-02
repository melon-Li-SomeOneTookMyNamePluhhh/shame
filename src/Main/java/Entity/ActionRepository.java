package Entity;

import User_case.PlayerUsercase.inputBoundaryInterface;
import java.util.HashSet;
import java.util.Set;

public class ActionRepository {
    // Method to return all valid actions
    public static Set<String> getValidActions() {
        Set<String> validActions = new HashSet<>();
        validActions.add("walk to");
        validActions.add("pick up");
        validActions.add("speech");
        validActions.add("exit");
        validActions.add("drop");
        validActions.add("put in bag");
        validActions.add("get from bag");
        validActions.add("inspect bag");
        validActions.add("interact");
        validActions.add("exist");
        validActions.add("open");
        validActions.add("key");
        validActions.add("sword");
        validActions.add("torch");
        return validActions;
    }

    // Method to handle each valid action and return a corresponding string
    public static String handleAction(String action)
    {
        switch (action.toLowerCase()) {
            case "walk to":

                return "You walk towards your destination.";
            case "pick up":
                return "You picked up an item.";
            case "speech":
                return "You started a conversation.";
            case "exit":
                return "You exited the area.";
            case "drop":
                return "You dropped an item.";
            case "put in bag":
                return "You put an item into your bag.";
            case "get from bag":
                return "You retrieved an item from your bag.";
            case "inspect bag":
                return "You inspected your bag and found various items.";
            case "interact":
                return "You interacted with the environment.";
            case "exist":
                return "You exist in this moment.";
            case "open":
                return "You opened the object.";
            case "key":
                return "You used a key.";
            case "sword":
                return "You wielded a sword.";
            case "torch":
                return "You lit a torch.";
            default:
                return "Invalid action.";
        }
    }
}
