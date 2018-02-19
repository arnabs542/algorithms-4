/*
*
* 55. Jump Game
* https://leetcode.com/problems/jump-game/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given an array of non-negative integers, you are initially positioned at the first index of the array.
* Each element in the array represents your maximum jump length at that position.
* Determine if you are able to reach the last index.
*
* For example:
* A = [2,3,1,1,4], return true.
* A = [3,2,1,0,4], return false.
*
* */

package array;

public class jump_game {
    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
