/*
*
* 54. Spiral Matrix
* https://leetcode.com/problems/spiral-matrix/description/
*
* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
* For example,
* Given the following matrix:
*
* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* You should return [1,2,3,6,9,8,7,4,5].
*
*  - - -
*       |
*  - ->
* |     |
*  - - -
* */

package board;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
    // 改变方向的顺序：右->下->左->上->右
    // 改变方向的条件：下一个点在边界，或者visited
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        final int INVALID = Integer.MIN_VALUE;
        int[][] directions = {{0, 1}, {1, 0} , {0, -1}, {-1, 0}};
        int direction = 0, i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        while (list.size() < m * n) {
            list.add(matrix[i][j]);
            matrix[i][j] = INVALID;
            if (direction == 0) { // right
                if (j + 1 <= n - 1 && matrix[i][j+1] != INVALID) j++;
                else {
                    direction = 1; // turn "down"
                    i++;
                }
            } else if (direction == 1) { // down
                if (i + 1 <= m - 1 && matrix[i+1][j] != INVALID) i++;
                else {
                    direction = 2; // turn "left"
                    j--;
                }
            } else if (direction == 2) { // left
                if (j - 1 >= 0 && matrix[i][j - 1] != INVALID) j--;
                else {
                    direction = 3; // turn "up"
                    i--;
                }
            } else { // up
                if (i - 1 >= 0 && matrix[i-1][j] != INVALID) i--;
                else {
                    direction = 0; // turn "right"
                    j++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
