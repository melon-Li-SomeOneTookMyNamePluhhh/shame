package Enemy;

public class AttackList {
    public void normalAttack() {
        System.out.println("Normal attack! The player loses 2 health.");
    }

    public void criticalStrike() {
        System.out.println("Critical strike! The player loses 5 health.");
    }

    public void defense() {
        System.out.println("Defense! Enemy absorbs 3 damage from the attack.");
    }
}

