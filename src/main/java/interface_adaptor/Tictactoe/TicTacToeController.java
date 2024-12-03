package interface_adaptor.Tictactoe;

import User_case.TicTacToe.BotMoveInputBoundary;
import User_case.TicTacToe.PlayerMoveInputBoundary;

public class TicTacToeController {
    private final PlayerMoveInputBoundary inputBoundary;
    private final BotMoveInputBoundary botBoundary;

    public TicTacToeController(PlayerMoveInputBoundary inputBoundary, BotMoveInputBoundary botBoundary) {
        this.botBoundary = botBoundary;
        this.inputBoundary = inputBoundary;
    }

    public void makeMove(int row, int col) {
        if (!inputBoundary.isGameOver()) {
            boolean isValidMove = inputBoundary.makeMove(row, col);
            if (!isValidMove) {
                return;
            }
        }
        if (!inputBoundary.isGameOver()) {
            botBoundary.makeBotMove();
        }
    }
}