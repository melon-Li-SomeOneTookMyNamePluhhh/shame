package User_case.TicTacToe;

public interface MakeMoveOutputBoundary {
    void presentBoard(char[][] board);
    void presentWinner(char winner);
    void presentError(String message);
}