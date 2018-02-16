/*
*
* 11. Container With Most Water
* https://leetcode.com/problems/container-with-most-water/description/
*
*  y ^
*    |     a2       a5
*    |     |        |
*    |     |  a3    |     an
*    |  a1 |  |     |     |
*    |  |  |  |  a4 |  a6 |
*    |  |  |  |  |  |  |  |
*    --------------------------->
*   0   1  2  3  4  5  6..n     x
*
*    It actually is to find the any 2 bars a_i, a_j, which hold most water together with x-axis.
*
* 思路：lower height of the two bar * width
* two pointer left and right
* if new height < min(left, right), right++
*
* */

package array;

public class container_with_most_water {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] arr = {2,5,3,1,5,1};
        System.out.println(maxArea(arr));
    }
}
