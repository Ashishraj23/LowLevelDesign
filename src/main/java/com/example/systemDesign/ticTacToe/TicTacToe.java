package com.example.systemDesign.ticTacToe;

public class TicTacToe {
    private final int [][] board;
    private final int n;

    public TicTacToe(final int n){
        this.n = n;
        board = new int[n][n];
    }

    /**
     * Makes a move on the board and returns the winner if the
     * move is a winning move.
     * @param player is either 0 or 1
     * @param row  is the move's row index
     * @param col  is the move's column index
     * @return  winner +1 if first player, -1 if second player and zero otherwise
     * @throws IllegalArgumentException if move is an illegal move
     */
    public int move (int player, int row, int col) throws IllegalArgumentException {
        if(row <0 || col <0 || row >=n || col >= n){
            throw new IllegalArgumentException("Moves out of board boundry");
        }
        else if(board[row][col] != 0){
            throw new IllegalArgumentException("Square is already occupied!");
        }
        else if( player != 0 && player != 1){
            throw new IllegalArgumentException("Invalid Player");
        }else {
            player = player == 0? -1 : 1;
            board [row][col] = player;
            boolean winRow = true, winCol = true, winDiag = true, winRevDiag =true;
            for (int i = 0; i < n; i++) {
                if(board[row][i] != player){
                    winRow= false;
                }
                if(board[i][col] != player){
                    winCol= false;
                }
                if (board[i][i] != player) {
                    winDiag = false;
                }
                if (board[i][n-1-i] != player) {
                    winRevDiag = false;
                }
            }
            if(winRow || winCol || winDiag || winRevDiag)return player;
        }
        return 0;
    }
}



















/*
win = true;
            for (int i = 0; i < n; i++) {
                if(board[i][col] != player){
                    win= false;
                    break;
                }
            }
            if(win)return player;
            /*
            check digonal
             */
/*
            if(row == col) {
                    win = true;
                    for (int i = 0; i < n; i++) {
        if (board[i][i] != player) {
        win = false;
        break;
        }
        }
        if (win) return player;
        }
            /*
            checking rev digonal
             */
/*
        if(row == n-1 - col) {
        win = true;
        for (int i = 0; i < n; i++) {
        if (board[i][n-1-i] != player) {
        win = false;
        break;
        }
        }
        if (win) return player;
        }

 */