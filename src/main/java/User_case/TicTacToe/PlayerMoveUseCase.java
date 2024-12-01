package User_case.TicTacToe;

import Entity.TicTacToe.TicTacToeBoard;

public class PlayerMoveUseCase implements PlayerMoveInputBoundary {
    private final TicTacToeBoard board;
    private final MakeMoveOutputBoundary outputBoundary;

    public PlayerMoveUseCase(TicTacToeBoard board, MakeMoveOutputBoundary outputBoundary) {
        this.board = board;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public boolean makeMove(int row, int col) {
        if(board.makeMove(row, col)) {
            char winner = board.checkWin();
            if (winner != '-') {
                outputBoundary.presentWinner(winner);
            } else if (board.isFull()) {
                outputBoundary.presentWinner('D'); // Draw
            } else {
                board.switchPlayer();
            }
            return true;
        } else {
            outputBoundary.presentError("Invalid move. Try again.");
            return false;
        }
    }

    @Override
    public boolean isGameOver() {
        return board.isGameOver();
    }
}