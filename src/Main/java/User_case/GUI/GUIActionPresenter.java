package User_case.GUI;

public class GUIActionPresenter implements GUIOutputBoundry {
    private final Frameworks_and_drivers.guiUtility guiUtility;

    public GUIActionPresenter(Frameworks_and_drivers.guiUtility guiUtility) {
        this.guiUtility = guiUtility;
    }

    @Override
    public void displayResult(String message) {
        guiUtility.displayOutput(message);
    }
}
