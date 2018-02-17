/*
*
* 73. Set Matrix Zeroes
* https://leetcode.com/problems/set-matrix-zeroes/description/
* --------------------------------------------------------------
* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*
* follow-up:
* Did you use extra space?
* A straight forward solution using O(mn) space is probably a bad idea.
* A simple improvement uses O(m + n) space, but still not the best solution.
* Could you devise a constant space solution?


*
* */

package board;

public class set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        int col0 = Integer.MAX_VALUE, m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
