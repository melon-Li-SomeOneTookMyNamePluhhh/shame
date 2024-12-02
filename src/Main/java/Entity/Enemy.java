package Entity;

import java.util.Random;

public abstract class Enemy {
    protected String name;
    protected String description;
    protected int health;
    protected AttackList attackList; // protected 属性
    protected Random random;
    protected final String type; // 固定的类型属性
    protected boolean usedSpecialAbility = false;
    protected int damage; // Damage dealt in the latest attack

    // 构造函数
    public Enemy(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.health = 15; // 默认生命值
        this.attackList = new AttackList();
        this.random = new Random();
        this.type = type;
    }

    // 抽象方法：特殊能力
    public abstract void useSpecialAbility();

    // 抽象方法：是否使用特殊技能
    protected abstract boolean shouldUseSpecialAbility();

    // 随机选择攻击类型的方法（protected 改为通过 public getter）
    protected String getRandomAttack() {
        int choice = random.nextInt(3); // 0: normal, 1: critical, 2: defense
        switch (choice) {
            case 0: return "normal";
            case 1: return "critical";
            case 2: return "defense";
            default: return "normal";
        }
    }

    // Getter 方法，用于访问 protected 成员
    public String getName() { return name; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public String getType() { return type; }

    public String getRandomAttackPublic() {
        return getRandomAttack();
    }

    public boolean shouldUseSpecialAbilityPublic() {
        return shouldUseSpecialAbility();
    }

    public AttackList getAttackList() {
        return attackList;
    }

    public int getDamage() { return damage; }
}


