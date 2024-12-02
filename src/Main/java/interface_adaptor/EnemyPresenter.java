package interface_adaptor;

import User_case.EnemyOutputBoundary;
import GUI.GUIUtility;

public class EnemyPresenter implements EnemyOutputBoundary {
    @Override
    public void presentAttack(String message) {
        GUIUtility.displayOutput(message);
    }
}
