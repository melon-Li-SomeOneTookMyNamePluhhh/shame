package adapter;

import usecase.BotMoveInputBoundary;
import usecase.MakeMoveInputBoundary;

public class TicTacToeController {
    private final MakeMoveInputBoundary inputBoundary;
    private final BotMoveInputBoundary botBoundary;

    public TicTacToeController(MakeMoveInputBoundary inputBoundary, BotMoveInputBoundary botBoundary) {
        this.botBoundary = botBoundary;
        this.inputBoundary = inputBoundary;
    }

    public void makeMove(int row, int col) {
        if(!inputBoundary.isGameOver()) {
            boolean isValidMove = inputBoundary.makeMove(row, col);
            if (!isValidMove) {
                return;
        }

        botBoundary.makeBotMove();
    }
    }
}