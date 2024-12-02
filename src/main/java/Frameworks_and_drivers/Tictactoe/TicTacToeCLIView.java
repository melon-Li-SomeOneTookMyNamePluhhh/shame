package Frameworks_and_drivers.Tictactoe;

public class TicTacToeCLIView implements TicTacToeView {
    @Override
    public void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void displayWinner(char winner) {
        if (winner == 'D') {
            System.out.println("The game is a draw, you need to restart it or you can choose to quit!");
        } else if(winner == 'O'){
            System.out.println("You were defeated by this TicTacToe enemy.");
        } else {
            System.out.println("You defeated this TicTacToe enemy!");
        }
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }
}