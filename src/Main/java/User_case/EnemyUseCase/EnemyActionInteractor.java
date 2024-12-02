package User_case.EnemyUseCase;

import Entity.Enemy;
import User_case.EnemyUseCase.EnemyOutputBoundary;

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
    public void performAction() {
        if (shouldUseSpecialAbility()) {
            enemy.useSpecialAbility();
            outputBoundary.presentAttack(getEnemyName() + " used its special ability.");
        } else {
            String attackType = getRandomAttack();
            int damage = 0;
            switch (attackType) {
                case "normal":
                    damage = enemy.getAttackList().normalAttack();
                    outputBoundary.presentAttack(getEnemyName() + " used a normal attack, dealing " + damage + " damage.");
                    break;
                case "critical":
                    damage = enemy.getAttackList().criticalStrike();
                    outputBoundary.presentAttack(getEnemyName() + " used a critical strike, dealing " + damage + " damage.");
                    break;
                case "defense":
                    int absorbed = enemy.getAttackList().defense();
                    outputBoundary.presentAttack(getEnemyName() + " used defense, absorbing " + absorbed + " damage.");
                    break;
                default:
                    outputBoundary.presentAttack(getEnemyName() + " used an unknown attack type.");
                    break;
            }
        }
    }
}

