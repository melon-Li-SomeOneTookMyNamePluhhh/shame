package interface_adaptor;

import User_case.EnemyUseCase.EnemyOutputBoundary;
import Frameworks_and_drivers.GUIUtility;

public class EnemyPresenter implements EnemyOutputBoundary {
    @Override
    public void presentAttack(String message) {
        GUIUtility.displayOutput(message);
    }
}
