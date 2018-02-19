/*
*
* 51. N-Queens
* https://leetcode.com/problems/n-queens/description/
* ----------------------------------------------------------------------------------------------------------------------
* 任意两个皇后都不能处于同一条横行、纵行或斜线上
* Given an integer n, return all distinct solutions to the n-queens puzzle.
* Each solution contains a distinct board configuration of the n-queens' placement,
* where 'Q' and '.' both indicate a queen and an empty space respectively.
*
* 输出所有可能的结果
* */

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n_queens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] col : board) Arrays.fill(col, '.');
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(constuctBoard(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }

    // check (x,y)左边的columns上的点
    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(y - j) || x == i)) return false;
            }
        }
        return true;
    }

    private List<String> constuctBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] col : board) list.add(new String(col));
        return list;
    }

    public static void main(String[] args) {
        n_queens nq = new n_queens();
        System.out.println(nq.solveNQueens(9));
    }
}
