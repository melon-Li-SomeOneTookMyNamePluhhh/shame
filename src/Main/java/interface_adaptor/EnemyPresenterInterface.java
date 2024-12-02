package interface_adaptor;

import User_case.EnemyUseCase.EnemyOutputBoundaryInterface;
import Frameworks_and_drivers.guiUtility;

public class EnemyPresenterInterface implements EnemyOutputBoundaryInterface {
    @Override
    public void presentAttack(String message) {
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput(message);
    }
}
