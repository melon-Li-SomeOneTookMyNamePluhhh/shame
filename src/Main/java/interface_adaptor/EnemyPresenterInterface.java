package interface_adaptor;

import User_case.EnemyUseCase.EnemyOutputBoundaryInterface;
import Frameworks_and_drivers.GUIUtility;

public class EnemyPresenterInterface implements EnemyOutputBoundaryInterface {
    @Override
    public void presentAttack(String message) {
        GUIUtility.displayOutput(message);
    }
}
