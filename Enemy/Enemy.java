package Enemy;

public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected AttackList attackList;

    // Constructor
    public Enemy(String name, String description, AttackList attackList) {
        this.name = name;
        this.description = description;
        this.health = 15; // Default health
        this.attackList = attackList;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public AttackList getAttackList() {
        return attackList;
    }

    // Abstract method for special ability
    public abstract void useSpecialAbility();
}

