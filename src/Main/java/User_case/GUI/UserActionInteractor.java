package User_case.GUI;

import Entity.ActionRepository;
import java.util.Set;
import Entity.Player;

public class UserActionInteractor implements GUIInputBoundry {
    private final GUIOutputBoundry outputBoundary;
    private final Player player;

    public UserActionInteractor(GUIOutputBoundry outputBoundary, Player player) {
        this.outputBoundary = outputBoundary;
        this.player = player;
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
