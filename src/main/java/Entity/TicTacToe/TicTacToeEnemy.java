package Entity.TicTacToe;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeEnemy {
    char botSymbol = 'O';

    public static int[] makeRandomMove(TicTacToeBoard board) {
        List<int[]> availableMoves = getAvailableMoves(board);
        Random random = new Random();
        return availableMoves.get(random.nextInt(availableMoves.size()));
    }

    public static int[] BotMakeMove(TicTacToeBoard board) {
        for (int[] move : getAvailableMoves(board)) {
            if (wouldWin(board, move, 'O')) {
                return move;
            }
        }

        return makeRandomMove(board);
    }

    private static boolean wouldWin(TicTacToeBoard board, int[] move, char symbol) {
        return board.attemptMove(move[0], move[1], 'O');
    }


    private static List<int[]> getAvailableMoves(TicTacToeBoard board){
        List<int[]> moves = new ArrayList<>();
        for(int row = 0; row <=2; row++){
            for(int col = 0; col <=2; col++){
                if(board.getBoard()[row][col] == '-'){
                    moves.add(new int[]{row, col});
                }
            }
        }
        return moves;
    }
}
