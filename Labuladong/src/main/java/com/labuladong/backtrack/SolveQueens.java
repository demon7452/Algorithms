package com.labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SolveQueens {

    public static void main(String[] args) {
        SolveQueens queens = new SolveQueens();
        List<List<String>> re = queens.solveNQueens(8);
        System.out.println(re);
    }

    private final List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board, 0);
        return result;
    }

    private void backtrack(String[][] board, int row) {
        int n = board.length;
        if (n == row) {
            List<String> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder line = new StringBuilder(n);
                for (int j = 0; j < n; j++) {
                    line.append(board[i][j]);
                }
                res.add(line.toString());
            }
            result.add(res);
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
