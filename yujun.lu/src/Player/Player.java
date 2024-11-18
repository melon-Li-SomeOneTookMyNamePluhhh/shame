package Player;

public class Player {

    // Moves the player to a specified location and updates the current location.
    public String Walk_to(String item){
        location = item;
        return item;
    }

    // Attempts to pick up an item. If the player is already holding another item, they cannot pick up a new one.
    public void Pick_up(String item){
        if(!holding.isEmpty()) {
            holding = item;
        }
        else{
            System.out.println("You can't have a pick up because your have another item on hand");
        }
    }

    // Puts the currently held item into the inventory if there is space. If the player is not holding anything,
    // or if the inventory is full, it displays an appropriate message.
    public void Put_in_bag(){
        if(holding.isEmpty()) {
            System.out.println("You have nothing to put in the inventory");
        }
        else{
            if(inventory.getNumItemsInside() < inventory.getBagSize()){
                inventory.addItem(holding);
                holding = "";
            }
            else{
                System.out.println("Your inventory is full");
            }
        }
    }

    // Drops the currently held item, making the player no longer hold any item.
    public void Drop(){
        holding = "";
    }
}
