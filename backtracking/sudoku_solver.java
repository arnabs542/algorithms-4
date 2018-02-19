/*
*
* 37. Sudoku Solver
* https://leetcode.com/problems/sudoku-solver/description/
*
* Write a program to solve a Sudoku puzzle by filling the empty cells.
* Empty cells are indicated by the character '.'.
* You may assume that there will be only one unique solution.
*
* */

package backtracking;

public class sudoku_solver {
    /*-------------method 1: backtracking---------------*/
    public void solveSudoku(char[][] board) {
        // try 1~9 through every cell
        if (board == null || board.length == 0) return;
        solve(board);
    }

    // 学习一下这种backtrack的方式
    private boolean solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // check current cell's row, column and cube does not contain its char c
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; // check row
            if (board[row][i] != '.' && board[row][i] == c) return false; // check column
            int cubeRow = 3 * (row / 3) + i / 3, cubeCol = 3 * (col / 3) + i % 3;
            if (board[cubeRow][cubeCol] != '.' && board[cubeRow][cubeCol] == c) return false;
        }
        return true;
    }
}
