/*
* LC 268. Missing Number
* https://leetcode.com/problems/missing-number/description/
*
* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
*
* example:
* Input: [9,6,4,2,3,5,7,0,1]
* Output: 8
*
* requirement: time: O(n), space: O(1)
* */

package math;

public class missing_number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = (0 + n) * (n + 1) / 2;
        for (int num : nums) result -= num;
        return result;
    }
}
