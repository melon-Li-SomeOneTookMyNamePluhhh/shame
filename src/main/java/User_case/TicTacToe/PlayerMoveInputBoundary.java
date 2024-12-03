package User_case.TicTacToe;

public interface PlayerMoveInputBoundary {
    boolean makeMove(int row, int col);
    boolean isGameOver();
}