package tictactoe;

public class TicTacToe {

    private final int [][] board;

    public TicTacToe(final int n){
        board = new int[n][n];
    }


    /**
     * Makes a move and return a winner after if any after making the move
     *
     * @param player is either 0 --> [player1] or 1 --> [player2]
     * @param row  is move's row index
     * @param col is move's row index
     * @return -1 if winner is player 1, +1 if winner is player 2, or 0 otherwise if no winner decided yet
     */
    public int move(int player, int row, int col) throws IllegalArgumentException{
        if(row < 0 || row >= board.length || col <0 || col>= board.length){
            throw new IllegalArgumentException("invalid cell for making the move");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("cell already occupied");
        }
        if(player != 0 || player != 1){
            throw new IllegalArgumentException("invalid player");
        }
        player = player == 0 ? -1 : 1;
        board[row][col] = player;
        boolean isWinRow = true, isWinCol = true, isWinDiag = true, isWinRevDia = true;
        for(int i=0 ; i < board.length; i++){
            if(board[row][i] != player){
                isWinRow = false;
            }
            if(board[i][col] != player){
                isWinCol = false;
            }
            if(board[i][i] != player){
                isWinDiag = false;
            }
            if(board[i][board.length - i - 1] != player){
                isWinRevDia = false;
            }
        }

        if(isWinCol || isWinRow || isWinDiag || isWinRevDia){
            return player;
        }
        return 0;
    }
}
