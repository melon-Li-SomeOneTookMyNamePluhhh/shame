package Frameworks_and_drivers.Tictactoe;

public class TicTacToeCLIView implements TicTacToeView {
    @Override
    public void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
                guiUtility.displayOutput(cell + " ");
            }
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("");
        }
    }

    @Override
    public void displayWinner(char winner) {
        if (winner == 'D') {
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("The game is a draw, you need to restart it or you can choose to quit!");
        } else if(winner == 'O'){
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("You were defeated by this TicTacToe enemy.");
        } else {
            Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
            guiUtility.displayOutput("You defeated this TicTacToe enemy!");
        }
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }
}