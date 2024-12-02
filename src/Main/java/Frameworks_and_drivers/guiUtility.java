package Frameworks_and_drivers;

import javax.swing.*;
import java.util.Set;

public class guiUtility {
    public void displayOutput(String message) {
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getInput(String prompt) {
        return JOptionPane.showInputDialog(null, prompt, "Input", JOptionPane.QUESTION_MESSAGE);
    }

    public String getValidInput(String prompt, Set<String> validOptions) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, prompt, "Input", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Action canceled.", "Canceled", JOptionPane.WARNING_MESSAGE);
                return null;
            }

            input = input.trim().toLowerCase();
            if (!validOptions.contains(input)) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validOptions.contains(input));

        return input;
    }
}
