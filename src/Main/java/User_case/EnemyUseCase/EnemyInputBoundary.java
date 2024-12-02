package User_case.EnemyUseCase;

import Entity.Enemy;

/**
 * The EnemyInputBoundary class implements actions and interactions for enemies in the game.
 * It processes commands and delegates specific actions for enemies.
 */
public class EnemyInputBoundary implements EnemyInputBoundaryInterface {
    protected Enemy enemy;

    /**
     * Constructs an EnemyInputBoundary with the specified enemy.
     * @param enemy The Enemy object representing the enemy in the game.
     */
    public EnemyInputBoundary(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void performAction() {
        // This method should be overridden by subclasses or specific use case classes.
        // Placeholder implementation.
        System.out.println("Performing a generic action.");
    }

    // You can add shared methods here that subclasses may need
    protected String getEnemyName() {
        return enemy.getName();
    }

    protected boolean shouldUseSpecialAbility() {
        return enemy.shouldUseSpecialAbilityPublic();
    }

    protected String getRandomAttack() {
        return enemy.getRandomAttackPublic();
    }
}
