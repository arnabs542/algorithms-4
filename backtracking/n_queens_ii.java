/*
*
* 52. N-Queens II
* https://leetcode.com/problems/n-queens-ii/description/
* ----------------------------------------------------------------------------------------------------------------------
* 任意两个皇后都不能处于同一条横行、纵行或斜线上
* Given an integer n, return all distinct solutions to the n-queens puzzle.
* Each solution contains a distinct board configuration of the n-queens' placement,
* where 'Q' and '.' both indicate a queen and an empty space respectively.
*
* Follow up for N-Queens problem.
* Now, instead outputting board configurations, return the total number of distinct solutions.
*
* 思路：
* 因为只需要解法的数量，所以不需要construct board，只需要用set记录col, diag1, diag2就行了
* */

package backtracking;

import java.util.HashSet;
import java.util.Set;

public class n_queens_ii {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> dia1 = new HashSet<>(); // y = x + k, so k = (y - x)
    private Set<Integer> diag2 = new HashSet<>(); // y = -x + k, so k = (y + x)

    public int totalNQueens(int n) {
        return backtrack(0, 0, n);
    }

    private int backtrack(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) continue;
            if (dia1.contains(row - col)) continue;
            if (diag2.contains(row + col)) continue;
            if (row == n - 1) count++; // "row" reaches the last row, valid cell for a queen
            else {
                cols.add(col);
                dia1.add(row - col);
                diag2.add(row + col);
                count = backtrack(row + 1, count, n);
                cols.remove(col);
                dia1.remove(row - col);
                diag2.remove(row + col);
            }
        }
        return count;
    }
}
