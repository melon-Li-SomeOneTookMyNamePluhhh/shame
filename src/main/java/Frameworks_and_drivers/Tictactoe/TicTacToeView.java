package Frameworks_and_drivers.Tictactoe;

public interface TicTacToeView {
        void displayBoard(char[][] board);
        void displayWinner(char winner);
        void displayError(String message);
}

