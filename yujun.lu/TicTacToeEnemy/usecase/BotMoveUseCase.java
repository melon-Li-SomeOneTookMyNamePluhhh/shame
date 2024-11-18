package usecase;

import entity.TicTacToeBoard;
import entity.TicTacToeEnemy;

public class BotMoveUseCase implements BotMoveInputBoundary {
    private final TicTacToeBoard board;
    private final MakeMoveOutputBoundary outputBoundary;

    public BotMoveUseCase(TicTacToeBoard board, MakeMoveOutputBoundary outputBoundary) {
        this.board = board;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void makeBotMove() {
        int[] move = TicTacToeEnemy.BotMakeMove(board); // 调用随机移动逻辑
        if(board.makeMove(move[0], move[1])) {
            char winner = board.checkWin();
            if (winner != '-') {
                outputBoundary.presentWinner(winner);
            } else if (board.isFull()) {
                outputBoundary.presentWinner('D'); // Draw
            } else {
                board.switchPlayer();
            }
        } else {
            outputBoundary.presentError("Invalid move. Try again.");
        }
    }

    @Override
    public boolean isGameMove() {
        return board.isGameOver();
    }
}
