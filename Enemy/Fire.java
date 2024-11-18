package Enemy;

public class Fire extends Enemy {
    private boolean usedSpecialAbility = false;

    public Fire(String name, String description) {
        super(name, description, new AttackList());
    }

    @Override
    public void useSpecialAbility() {
        if (health < 3 && !usedSpecialAbility) {
            System.out.println(name + " activates its special ability! All attacks are now critical strikes.");
            usedSpecialAbility = true;
        }
    }

    @Override
    public void damage(int amount) {
        if (health < 3 && !usedSpecialAbility) {
            useSpecialAbility(); // auto add damage(its special ability)
        }

        // check status
        if (usedSpecialAbility) {
            amount += 2; // critical strikes
            System.out.println(name + " is critically vulnerable! Damage increased by 2.");
        }

        super.damage(amount); // normal attack
    }
}