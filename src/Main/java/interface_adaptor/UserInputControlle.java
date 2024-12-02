package interface_adaptor;

import User_case.GUI.GUIInputBoundry;

public class UserInputControlle {
    private GUIInputBoundry inputBoundary;

    public UserInputControlle(GUIInputBoundry inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void setInputBoundary(GUIInputBoundry inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void handleInput(String input) {
        if (inputBoundary != null) {
            inputBoundary.processInput(input);
        }
    }
}
