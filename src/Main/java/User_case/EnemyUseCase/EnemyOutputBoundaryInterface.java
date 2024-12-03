package User_case.EnemyUseCase;

/**
 * The EnemyOutputBoundaryInterface defines methods for presenting enemy actions and information to the user.
 * It acts as the boundary between the use case and the output logic.
 */
public interface EnemyOutputBoundaryInterface {
    /**
     * Presents the result of an enemy's attack to the player.
     * @param message The message to be presented to the player.
     */
    void presentAttack(String message);
}

