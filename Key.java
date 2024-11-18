public class Key extends Item{
    int damage;
    String element = "Regular";
    private boolean Used = false; //has the key been used or not

    // Constructor for Key that calls the Item constructor
    public Key(String name, String description) {
        // Call the constructor of Item class with parameters
        super(name, description, "Key"); // Pass values to the superclass constructor
    }

    public boolean getUsed(){
        return Used;
    }
    public void setUsed(boolean used){
        Used = used;
    }
    @Override
    public void Interact() {
        // TODO: we can use this code once we have a game with currentplayer as a global variable and a location() method for all items.
        if (currentplayer.location() == currentplayer.curr_room.exit.location() && currentroom.exit.isLocked() == true && this.getUsed() == false){
          currentplayer.curr_room.exit.setLocked(false);
          System.out.println("You have unlocked the exit");
        }
        else if (currentplayer.location() == currentplayer.curr_room.exit.location() && currentroom.exit.isLocked() == true && this.getUsed() == true){
            System.out.println("You are using the wrong key for the exit");
        }
        else if (currentplayer.location() == currentplayer.curr_room.exit.location() && currentroom.exit.isLocked() == false){
            System.out.println("The exit you are at is already unlocked");
        }
        else {
          System.out.println("You are not standing at the exit; go to the correct exit to unlock the exit");
        }

    }
}
