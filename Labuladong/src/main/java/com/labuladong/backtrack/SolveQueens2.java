package com.labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SolveQueens2 {

    public static void main(String[] args) {
        SolveQueens2 queens = new SolveQueens2();
       queens.totalNQueens(8);
    }

    private int count = 0;

    public int totalNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board, 0);
        return count;
    }

    private void backtrack(String[][] board, int row) {
        int n = board.length;
        if (n == row) {
            count++;
        }

        for (int col = 0; col < n; col++) {
            if (isInValid(board, row, col)){
                continue;
            }

            board[row][col] = "Q";
            backtrack(board, row + 1);
            board[row][col] = ".";
        }
    }
    private boolean isInValid(String[][] board, int row, int col) {
        for (int i = 0; i <= row; i++) {
            if (board[i][col].equals("Q")){
                return true;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length  ; i--, j++) {
            if (board[i][j].equals("Q")){
                return true;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0  ; i--, j--) {
            if (board[i][j].equals("Q")){
                return true;
            }
        }
        return false;
    }
}
