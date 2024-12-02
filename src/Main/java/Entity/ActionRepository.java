package Entity;

import User_case.PlayerUsercase.inputBoundaryInterface;
import java.util.HashSet;
import java.util.Set;

public class ActionRepository {
    // Method to return all valid actions
    public static Set<String> getValidActions() {
        Set<String> validActions = new HashSet<>();
        validActions.add("walkto");
        validActions.add("pickup");
        validActions.add("speech");
        validActions.add("exit");
        validActions.add("drop");
        validActions.add("putinbag");
        validActions.add("getfrombag");
        validActions.add("inspectbag");
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
        String in = action.toLowerCase();
        switch (in) {
            case "walkto":
                User_case.PlayerUsercase.inputBoundaryInterface.walkTo(in);
                return "You walk towards your destination.";
            case "pickup":
                User_case.PlayerUsercase.inputBoundaryInterface.pickUp(in);
                return "You picked up an item.";
            case "speech":
                return "You started a conversation.";
            case "exit":
                return "You exited the area.";
            case "drop":
                User_case.PlayerUsercase.inputBoundaryInterface.drop();
                return "You dropped an item.";
            case "putinbag":
                User_case.PlayerUsercase.inputBoundaryInterface.putInBag();
                return "You put an item into your bag.";
            case "getfrombag":
                User_case.PlayerUsercase.inputBoundaryInterface.getFromBag(in);
                return "You retrieved an item from your bag.";
            case "inspectbag":
                User_case.PlayerUsercase.inputBoundaryInterface.inspectBag();
                return "You inspected your bag and found various items.";
            case "use the key to open the door":
                User_case.PlayerUsercase.inputBoundaryInterface.interact("key", "exit");
                return "You interacted with the environment.";
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
