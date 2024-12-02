package interface_adaptor.GUI;

import User_case.GUI.GUIController;
import javax.swing.*;

public class GameGUI extends JFrame {
    private final GUIController controller;

    public GameGUI(GUIController controller) {
        this.controller = controller;
        setTitle("Game Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
    }

    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


    }

    public void displayResult(String message) {
        // Logic to display the result in the GUI
        JOptionPane.showMessageDialog(this, message, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateStats() {
        // Logic to update stats in the GUI
        System.out.println("Updating game stats...");
        // Update relevant stats in the GUI (e.g., health, inventory, score)
    }
}
