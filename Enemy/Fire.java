package Enemy;

public class Fire extends Enemy {
    private boolean usedSpecialAbility = false;// 标志位：是否使用过特殊能力

    // Constructor
    public Fire(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (health < 3 && !usedSpecialAbility) {
            System.out.println(name + " activates its special ability! Critical strikes are now enabled.");
            usedSpecialAbility = true;
        } else {
            System.out.println(name + " cannot use its special ability.");
        }
    }

    public void attack() {
        if (usedSpecialAbility) {
            attackList.criticalStrike(); // 暴击攻击
        } else {
            attackList.normalAttack(); // 普通攻击
        }
    }
}