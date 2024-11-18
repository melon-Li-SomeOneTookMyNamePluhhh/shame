package Player;

public class Player {
    private String location; // The name of the location/item in the room
    private int currRoom; // The current room number
    private String holding; // The item currently being held
    private int health; // Health of the player
    private int damage; // Damage the player can deal

    // Constructor
    public Player(int bagSize, int health, int damage) {
        this.health = health;
        this.damage = damage;
        this.location = ""; // Start with no specific location
        this.currRoom = 0; // Default starting room
        this.holding = ""; // Start with no item in hand
    }

    // Location-related methods
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Room-related methods
    public int getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(int currRoom) {
        this.currRoom = currRoom;
    }

    // Holding item methods
    public String getHolding() {
        return holding;
    }

    public void setHolding(String holding) {
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
}
