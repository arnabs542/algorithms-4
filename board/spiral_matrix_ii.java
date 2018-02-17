/*
*
* 59. Spiral Matrix II
* https://leetcode.com/problems/spiral-matrix-ii/description/
*
* ----------------------------------------------------------
* Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
*
* For example,
* Given n = 3,
*
* You should return the following matrix:
* [
*  [ 1, 2, 3 ],
*  [ 8, 9, 4 ],
*  [ 7, 6, 5 ]
* ]
*
* */

package board;

public class spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int direction = 0, i = 0, j = 0, count = 1;
        while (count <= n * n) {
            matrix[i][j] = count++;
            if (direction == 0) { // right
                if (j + 1 <= n - 1 && matrix[i][j+1] == 0) j++;
                else {
                    direction = 1; // turn "down"
                    i++;
                }
            } else if (direction == 1) { // down
                if (i + 1 <= n - 1 && matrix[i+1][j] == 0) i++;
                else {
                    direction = 2; // turn "left"
                    j--;
                }
            } else if (direction == 2) { // left
                if (j - 1 >= 0 && matrix[i][j - 1] == 0) j--;
                else {
                    direction = 3; // turn "up"
                    i--;
                }
            } else { // up
                if (i - 1 >= 0 && matrix[i-1][j] == 0) i--;
                else {
                    direction = 0; // turn "right"
                    j++;
                }
            }
        }
        return matrix;
    }
}
