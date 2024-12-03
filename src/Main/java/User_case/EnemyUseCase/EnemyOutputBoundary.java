package User_case.EnemyUseCase;

import User_case.EnemyUseCase.EnemyOutputBoundaryInterface;

/**
 * The EnemyOutputBoundary class implements the presentation logic for enemy actions,
 * sending the output to the appropriate medium, such as a console or GUI.
 */
public class EnemyOutputBoundary implements EnemyOutputBoundaryInterface {

    @Override
    public void presentAttack(String message) {
        // In a real application, this could send the message to a GUI or other output medium.
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput(message);
    }
}

