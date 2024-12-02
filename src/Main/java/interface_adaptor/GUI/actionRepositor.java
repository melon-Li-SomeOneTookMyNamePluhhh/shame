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
        //validActions.add("walkto");
        validActions.add("walk to the mailbox");
        //validActions.add("pickup");
        validActions.add("pick up key");
        validActions.add("speech");
        validActions.add("exit");
        validActions.add("drop");
        //validActions.add("putinbag");
        validActions.add("put it in bag");
        validActions.add("getfrombag");
        validActions.add("inspectbag");
        validActions.add("interact");
        validActions.add("exist");
        validActions.add("open");
        validActions.add("key");
        validActions.add("sword");
        validActions.add("torch");
        validActions.add("dragon fang sword");
        validActions.add("use the key in your hand");
        validActions.add("walk to the spiderweb");
    }

    // Instance method to return all valid actions
    public static Set<String> getValidActions() {
        return validActions;
    }

    // Instance method to handle each valid action and return a corresponding string
    public void handleAction(String action) {
        String in = action.toLowerCase();
        switch (in) {
            // case "walk to":
                // playerInputBoundary.walkTo(in);
                // break;
            case "walk to the mailbox":
                playerInputBoundary.walkTo("mailbox");
                break;
            case "walk to the spiderweb":
                playerInputBoundary.walkTo("spiderweb");
                break;
            //case "pickup":
                //playerInputBoundary.pickUp(in);
                //break;
            case "speech":
                break;
            case "exit":
                break;
            //case "putinbag":
               // playerInputBoundary.putInBag();
                //break;
            case "put it in bag":
                playerInputBoundary.putInBag();
                break;
            case "pick up key":
                playerInputBoundary.pickUp("mailbox");
                //这里有些问题，因为设置的key的名字叫mailbox
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
            case "dragon fang sword":
                playerInputBoundary.getFromBag(in);
                break;
            case "clean the spiderweb":
                System.out.println("You carefully pull at the sticky threads, feeling the resistance of the web as it clings stubbornly to the door. After a few tense moments, the door is clear, revealing an ornate handle. The way forward is open!");
                break;
            case "attack it with your sword":
                System.out.println("You swing your sword with determination, slicing through the thick webbing. The web starts to break apart, but the force of your attack leaves your sword slightly dull. The way forward is now open.");
                break;
            case "use the key in your hand":
                System.out.println("You push open the door through the thick, poisonous spiderweb. The venom in the web seeps into your skin, and you feel a sharp pain coursing through your body. Your health decreases by 2.");
                playerInputBoundary.interact("spiderweb"); // Deduct 2 health points
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
