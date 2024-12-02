package interface_adaptor;

import interface_adaptor.UserInputControlle;
import Entity.Player;
import interface_adaptor.GUIPresenter;
import User_case.GUI.GUIInputBoundry;
import User_case.GUI.GUIOutputBoundry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameGUI serves as the GUI interface, part of the Interface Adapters layer.
 */
public class GameGUI extends JFrame implements GUIOutputBoundry {
    private Player player;
    private JTextArea gameOutput;
    private JTextField userInput;
    private JLabel healthLabel;
    private final UserInputControlle controller;

    public GameGUI(Player player, GUIInputBoundry interactor) {
        this.player = player;
        this.controller = new UserInputControlle(interactor);
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("The Lord of Magic Ring!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Top Panel: Display player's stats
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        healthLabel = new JLabel("Health: " + player.getHealth());
        statsPanel.add(healthLabel);
        add(statsPanel, BorderLayout.NORTH);

        // Center Panel: Game Output
        gameOutput = new JTextArea();
        gameOutput.setEditable(false);
        gameOutput.setLineWrap(true);
        gameOutput.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(gameOutput);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: User Input
        JPanel inputPanel = new JPanel(new BorderLayout());
        userInput = new JTextField();
        JButton submitButton = new JButton("Submit");
        inputPanel.add(userInput, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Event Listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = userInput.getText().trim().toLowerCase();
                userInput.setText("");
                controller.handleInput(input);
            }
        });

        setVisible(true);
    }

    public void setInputBoundary(GUIInputBoundry interactor) {
        controller.setInputBoundary(interactor); // Public method to set interactor
    }

    @Override
    public void displayResult(String message) {
        gameOutput.append(message + "\n");
        gameOutput.setCaretPosition(gameOutput.getDocument().getLength());
    }

    public void updateStats() {
        healthLabel.setText("Health: " + player.getHealth());
    }
}
