package User_case.EnemyUseCase;

/**
 * The EnemyInputBoundaryInterface defines the actions and interactions for enemies in the game.
 * It acts as the boundary between the input logic and core game rules for enemy behavior.
 */
public interface EnemyInputBoundaryInterface {
    /**
     * Perform an action, such as attacking or using a special ability.
     */
    void performAction();
}