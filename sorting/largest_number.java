/*
*
* 179. Largest Number
* https://leetcode.com/problems/largest-number/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given a list of non negative integers, arrange them such that they form the largest number.
* For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
* Note: The result may be very large, so you need to return a string instead of an integer.
*
* 思路：change integer comparison to string comparison
* */

package sorting;

import java.util.Arrays;

public class largest_number {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        // 1. Convert to Integer array since Arrays.sort(A,T) forces that
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = Integer.toString(nums[i]);

        // 2. Sort in descending order
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 3.Append together and check final result
        StringBuilder sb = new StringBuilder();
        for (String str: strs) sb.append(str);
        if (sb.length() == 0 || sb.charAt(0) == '0') return "0";
        else return sb.toString();
    }
}
