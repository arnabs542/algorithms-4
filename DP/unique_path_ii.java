/*
*
* 63. Unique Paths II
* https://leetcode.com/problems/unique-paths-ii/description/
*
* Follow up for "Unique Paths":
*
* Now consider if some obstacles are added to the grids. How many unique paths would there be?
*
* An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*
* For example,
* There is one obstacle in the middle of a 3x3 grid as illustrated below.
*
* [
*   [0,0,0],
*   [0,1,0],
*   [0,0,0]
* ]
* The total number of unique paths is 2.
*
* Note: m and n will be at most 100.
* */

package DP;

public class unique_path_ii {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cols = new int[n];
        cols[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) cols[j] = 0;
                else if (j > 0) cols[j] += cols[j-1];
            }
        }
        return cols[n-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
