package User_case.GUI;

import Entity.ActionRepository;
import java.util.Set;

public class UserActionInteractor implements GUIInputBoundry {
    private final GUIOutputBoundry outputBoundary;

    public UserActionInteractor(GUIOutputBoundry outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void processInput(String input) {
        if (ActionRepository.getValidActions().contains(input)) {
            String response = ActionRepository.handleAction(input);
            outputBoundary.displayResult(response);
        } else {
            outputBoundary.displayResult("Invalid action: " + input);
        }
    }
}
