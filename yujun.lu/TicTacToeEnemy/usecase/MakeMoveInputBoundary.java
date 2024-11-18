package usecase;

public interface MakeMoveInputBoundary {
    boolean makeMove(int row, int col);
    boolean isGameOver();
}