/*
*
* LC 66. Plus One
* https://leetcode.com/problems/plus-one/description/
*
* */

package math;

public class pus_one {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else digits[i] = 0;
        }
        // 比如: 9999，需要输出10000
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

    }
}
