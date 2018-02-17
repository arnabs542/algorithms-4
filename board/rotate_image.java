/*
*
* 48. Rotate Image
* https://leetcode.com/problems/rotate-image/description/
*
* You are given an n x n 2D matrix representing an image.
* Rotate the image by 90 degrees (clockwise).
*
* Note:
* You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
* DO NOT allocate another 2D matrix and do the rotation.
*
* example:
*
* Given input matrix =
* [
*   [1,2,3],
*   [4,5,6],
*   [7,8,9]
* ],
*
* rotate the input matrix in-place such that it becomes:
* [
*   [7,4,1],
*   [8,5,2],
*   [9,6,3]
* ]
*
* */

package board;

public class rotate_image {

    /*-------------- clockwise rotation ------------------*/

    /*
     *
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     *
     */
    void clockwise_rotate(int[][] matrix) {
        // up <--> down
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }

        // bottom left <--> top right
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    /*-------------- counter-clockwise rotation ------------------*/

    /*
     * anticlockwise rotate
     * first swap the symmetry, then swap left and right
     * 1 2 3     1 4 7     3 6 9
     * 4 5 6  => 2 5 8  => 2 5 8
     * 7 8 9     3 6 9     1 4 7
     */
    void counter_clockwise_rotate(int[][] matrix) {
        // bottom left <--> top right
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // left <--> right
        int start = 0, end = matrix[0].length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
    }
}
