package GUI;

import javax.swing.*;

public class GUIUtility {

    /**
     * Displays a message in a pop-up window, mimicking System.out.println.
     * @param message The message to display.
     */
    public static void displayOutput(String message) {
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a pop-up input dialog to get user input, mimicking Scanner input.
     * @param prompt The prompt message to display.
     * @return The user's input as a String.
     */
    public static String getInput(String prompt) {
        return JOptionPane.showInputDialog(null, prompt, "Input", JOptionPane.QUESTION_MESSAGE);
    }
}
