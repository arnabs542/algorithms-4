/*
*
* 62. Unique Paths
* https://leetcode.com/problems/unique-paths/description/
* --------------------------------------------------------------------------------------------------
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
* The robot can only move either down or right at any point in time. The robot is trying to reach
* the bottom-right corner of the grid (marked 'Finish' in the diagram below).
*
* How many possible unique paths are there?
*
* */

package board;

import java.util.Arrays;

public class unique_path {
    // DP
    public static int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n ,m); // for optimization
        int[] rows = new int[m];
        Arrays.fill(rows, 1);

        // function
        for(int j = 1;j < n; j++){
            for(int i = 1; i < m; i++){
                rows[i] += rows[i-1];
            }
        }

        return rows[m-1];
    }
}
