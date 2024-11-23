package GUI;

import Player. Player;

public class mainwindow {
    public static void main(String[] args) {
        // Create a Player object
        Player player = new Player(10, 20, 5); // Bag size: 10, Health: 20, Damage: 5

        // Start the Game GUI
        SwingUtilities.invokeLater(() -> new GameGUI(player));
    }
}
