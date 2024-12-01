package Entity;

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

    public Inventory getInventory(){
        return inventory;}

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
    }}
