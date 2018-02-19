/*
*
* 137. Single Number II
* https://leetcode.com/problems/single-number-ii/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
*
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*
* 思路：
* */

package bits;

public class single_number_ii {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
