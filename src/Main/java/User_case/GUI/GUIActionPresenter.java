package User_case.GUI;

import interface_adaptor.GameGUI;

/**
 * GUIActionPresenter connects the Use Case logic to the GUI layer.
 */
public class GUIActionPresenter implements GUIOutputBoundry {
    private final GameGUI gameGUI;

    public GUIActionPresenter(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    @Override
    public void displayResult(String message) {
        // Forward the message to the GUI for display
        gameGUI.displayResult(message);
    }
}
