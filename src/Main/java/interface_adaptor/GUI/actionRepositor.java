package interface_adaptor.GUI;

import User_case.PlayerUsercase.PlayerInputBoundary;

import java.util.HashSet;
import java.util.Set;

public class actionRepositor {

    // Store valid actions as an instance variable
    private static Set<String> validActions = Set.of();
    private final PlayerInputBoundary playerInputBoundary;

    public actionRepositor(PlayerInputBoundary playerInputBoundary) {
        this.playerInputBoundary = playerInputBoundary;
        validActions = new HashSet<>();
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
        validActions.add("DragonfangSword");
    }

    // Instance method to return all valid actions
    public static Set<String> getValidActions() {
        return validActions;
    }

    // Instance method to handle each valid action and return a corresponding string
    public void handleAction(String action) {
        String in = action.toLowerCase();
        switch (in) {
            case "walkto":
                playerInputBoundary.walkTo(in);
                break;
            case "pickup":
                playerInputBoundary.pickUp(in);
                break;
            case "speech":
                break;
            case "exit":
                break;
            case "putinbag":
                playerInputBoundary.putInBag();
                break;
            case "getfrombag":
                playerInputBoundary.getFromBag(in);
                break;
            case "inspectbag":
                playerInputBoundary.inspectBag();
                break;
            case "use the key to open the door":
                playerInputBoundary.interact("key", "exit");
                break;
            case "DragonfangSword":
                playerInputBoundary.getFromBag(in);
                break;
            case "key":
                break;
            case "sword":
                break;
            case "torch":
                break;
            default:
                break;
        }
    }
}
