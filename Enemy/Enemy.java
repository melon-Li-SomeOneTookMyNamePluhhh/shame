package Enemy;

import java.util.Random;

public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected int damage; // Damage dealt in the latest attack
    protected AttackList attackList; // Ensure this class/interface is defined
    protected String element;
    protected Random random; // Declare at the class level
    protected final String type; // Fixed type attribute
    protected boolean usedSpecialAbility = false; // Tracks if special ability has been used

    // Constructor
    public Enemy(String name, String description, AttackList attackList, String type) {
        this.name = name;
        this.description = description;
        this.health = 15; // Default health
        this.attackList = attackList;
        this.random = new Random(); // Initialize random
        this.type = type; // Assign the final type attribute
        this.damage = 0; // Initialize damage
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getDamage() { return damage; }

    public String getType() { return type; }

    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }

    // Abstract method for special ability
    public abstract void useSpecialAbility();

    // Determines whether to use a special ability (implemented by subclasses)
    protected abstract boolean shouldUseSpecialAbility();

    // Randomly selects an attack type
    protected String getRandomAttack() {
        int choice = random.nextInt(3); // 0: normal, 1: critical, 2: defense
        switch (choice) {
            case 0:
                return "normal";
            case 1:
                return "critical";
            case 2:
                return "defense";
            default:
                return "normal";
        }
    }

    // General attack method, updates and returns damage dealt
    public int performAction() {
        if (shouldUseSpecialAbility()) {
            useSpecialAbility();
            this.damage = 0; // Special ability does not deal damage
            return this.damage;
        } else {
            String attackType = getRandomAttack();
            switch (attackType) {
                case "normal":
                    this.damage = attackList.normalAttack();
                    System.out.println(name + " used a normal attack, dealing " + damage + " damage.");
                    return damage;
                case "critical":
                    this.damage = attackList.criticalStrike();
                    System.out.println(name + " used a critical strike, dealing " + damage + " damage.");
                    return damage;
                case "defense":
                    int absorbed = attackList.defense();
                    System.out.println(name + " used defense, absorbing " + absorbed + " damage.");
                    this.damage = 0; // Defense does not deal damage
                    return this.damage;
                default:
                    System.out.println(name + " used an unknown attack type.");
                    this.damage = 0;
                    return this.damage;
            }
        }
    }
}
