public class Exit extends Item{
    private Boolean Locked = true;
    @Override
    public void Interact() {
        // TODO: we can use this code once we have a game with currentplayer as a global variable
        if (currentplayer.Holding instanceof Key && this.isLocked() && currentplayer.Holding.getUsed() == false) {
            System.out.println("You have unlocked the exit!");
        }
        else if (currentplayer.Holding instanceof Key && this.isLocked() && currentplayer.Holding.getUsed() == true) {
            System.out.println("You are using the wrong key for the exit!");
        }
        else if (!this.isLocked()) {
            System.out.println("The exit you are at is already unlocked.");
        }
        else {
            System.out.println("You do not have a key to unlock this door in your hand.");
        }
    }
    private boolean isLocked() {
        return Locked;
    }
    private void setLocked(boolean locked) {
        Locked = locked;
    }

    @Override
    public void Pickup() {
        System.out.println("You can't just lift the exit, silly!");
    }
}
