package User_case.GUI;

import User_case.PlayerUsercase.PlayerInputBoundary;

public class GUIController {
    private final PlayerInputBoundary playerInputBoundary;

    public GUIController(PlayerInputBoundary playerInputBoundary) {
        this.playerInputBoundary = playerInputBoundary;
    }

    public void walkTo(String itemName) {
        playerInputBoundary.walkTo(itemName);
    }

    public void pickUp(String itemName) {
        playerInputBoundary.pickUp(itemName);
    }

    public void interact(String itemName) {
        playerInputBoundary.interact(itemName);
    }

    public void inspectBag() {
        playerInputBoundary.inspectBag();
    }

    public void getFromBag(String itemName) {
        playerInputBoundary.getFromBag(itemName);
    }

    public void putInBag() {
        playerInputBoundary.putInBag();
    }

    public void interact(String holdingWhat, String itemAtLocation) {
        playerInputBoundary.interact(holdingWhat, itemAtLocation);
    }
}
