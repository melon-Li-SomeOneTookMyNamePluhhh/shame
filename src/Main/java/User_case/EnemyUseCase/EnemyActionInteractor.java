package User_case.EnemyUseCase;

import Entity.Enemy;

/**
 * The EnemyActionInteractor class extends EnemyInputBoundary and provides concrete
 * implementations of enemy actions.
 */
public class EnemyActionInteractor extends EnemyInputBoundary {
    private final EnemyOutputBoundary outputBoundary;

    public EnemyActionInteractor(Enemy enemy, EnemyOutputBoundary outputBoundary) {
        super(enemy); // 调用父类构造函数来初始化敌人
        this.outputBoundary = outputBoundary;
    }

    @Override
    public int performAction() {
        // 使用 public getter 方法来调用之前的 protected 方法
        if (enemy.shouldUseSpecialAbilityPublic()) {
            enemy.useSpecialAbility();
            outputBoundary.presentAttack(getEnemyName() + " used its special ability.");
            return enemy.getDamage();
        } else {
            String attackType = getRandomAttack();
            int damage = 0;
            switch (attackType) {
                case "normal":
                    damage = enemy.getAttackList().normalAttack();

                    outputBoundary.presentAttack(enemy.getName() +
                            " used a normal attack, dealing " + damage + " damage.");
                    return damage;
                case "critical":
                    damage = enemy.getAttackList().criticalStrike();
                    outputBoundary.presentAttack(enemy.getName() +
                            " used a critical strike, dealing " + damage + " damage.");
                    return damage;
                case "defense":
                    int absorbed = enemy.getAttackList().defense();
                    outputBoundary.presentAttack(enemy.getName() +
                            " used defense, absorbing " + absorbed + " damage.");
                    return enemy.getDamage();
                default:
                    outputBoundary.presentAttack(enemy.getName() +
                            " used an unknown attack type.");
                    return enemy.getDamage();
            }
        }
    }
}

