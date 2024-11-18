public class Key extends Item{
    int damage;
    String element = "Regular";
    @Override
    public void Interact() {
        // TODO: we can use this code once we have a game with currentplayer as a global variable and a location() method for all items.
        if (currentplayer.location() == currentplayer.curr_room.exit.location() && currentroom.exit.locked == true){
          currentplayer.curr_room.exit.locked = false;
          System.out.println("You have unlocked the exit");
        }
        else {
          System.out.println("You are not standing at the exit; go to the correct exit to unlock the exit");
        }

    }
}
