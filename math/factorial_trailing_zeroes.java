/*
*
* 172. Factorial Trailing Zeroes
* https://leetcode.com/problems/factorial-trailing-zeroes/description/
*
* Given an integer n, return the number of trailing zeroes in n!.
* 就是说给一个数n，然后找n!的最后面有多少个0
*
* time: O(lgn)
* */

package math;

public class factorial_trailing_zeroes {
    public static int trailingZeroes(int n) {
        int pow = 1, result = 0;
        while (Math.pow(5, pow) <= n) {
            result += n / Math.pow(5, pow);
            pow++;
        }
        return  result;
    }
}
