package tictactoe;

public class TicTacToeOptimized {

    private final int [][] board;
    private int row[];
    private int col[];
    private int dia[];
    private int revDiag[];

    public TicTacToeOptimized(final int n){
        board = new int[n][n];
        row = new int [n];
        col = new int[n];
        dia = new int[n];
        revDiag = new int[n];
    }


    /**
     * Makes a move and return a winner after if any after making the move
     *
     * @param player is either 0 or 1
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
