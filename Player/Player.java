package Player;

import DungenKeeper.Room;
import Item.Item;

public class Player {
    private Item location; // The name of the location/item in the Room.room
    private Room currRoom; // The current Room.room number
    private Item holding; // The item currently being held
    private int health; // Health of the player
    private int damage; // Damage the player can deal
    private Inventory inventory;

    // Constructor
    public Player(int bagSize, int health, int damage, Room room) {
        this.inventory = new Inventory(bagSize);
        this.health = health;
        this.damage = damage;
        this.location = null; // Start with no specific location
        this.currRoom = room; // Default starting Room.room
        this.holding = null; // Start with no item in hand
    }

    // Location-related methods
    public Item getLocation() {
        return location;
    }

    public void setLocation(Item location) {
        this.location = location;
    }

    // Room-related methods
    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

    // Holding item methods
    public Item getHolding() {
        return holding;
    }

    public void setHolding(Item holding) {
        this.holding = holding;
    }

    // Player status methods
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    // these method might need to be put somewhere else

    public void walkTo(String itemName){
        if (this.currRoom.hasItem(itemName) == null){
            System.out.println("you cant walk to that destination as it doesnt exist");
            return;
        }else{
            System.out.println("you walked to " + itemName);
            this.location = this.currRoom.hasItem(itemName);
            return;
        }
    }

//this requires fixing: can pick up unpickable items such as exit and npc
    public void pickUp(String itemName){
        // you can only pick up the item when your hands are empty
        if (this.holding != null){
            System.out.println("you cant pickup item when you are holding stuff");
            return;
        }
        // you can only pick up the item if you are standing next to it
        if (this.location == null){
            System.out.println("there is nothing around you to pickup!");
            return;
        }
        // you can only pick up the correct item
        if (this.location.getName().equals(itemName)) {
            this.holding = this.currRoom.pickUp(itemName);
            this.location = null;
            return;
        }
        else {
            System.out.println("you did not find " + itemName + " around you");
            return;
        }
    }

    // what else to implement:
    // interact
    // drop
    // inspect bag
    // put in bag
    // get item from bag

}

