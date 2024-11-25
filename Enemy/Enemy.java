package Enemy;

public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected AttackList attackList;
    protected int damage;
    protected String element;

    // Constructor
    public Enemy(String name, String description, AttackList attackList, int damage, String element) {
        this.name = name;
        this.description = description;
        this.health = 15; // Default health
        this.attackList = attackList;
        this.damage = damage;
        this.element = element;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public int getDamage() {
        return damage;
    }

    public String getElement() {
        return element;
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

