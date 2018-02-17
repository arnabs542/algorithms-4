/*
*
* 136. Single Number
* https://leetcode.com/problems/single-number/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given an array of integers, every element appears twice except for one. Find that single one.
*
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*
* 思路：XOR
* It is known that:
* 1. A XOR A = 0
* 2. the XOR operator is commutative
*
* the solution will be very straightforward.
*
* */

package bits;

public class single_number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
