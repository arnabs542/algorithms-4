/*
*
* LC 258. Add Digits
* https://leetcode.com/problems/add-digits/description/
*
* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
*
* Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*
* */

package math;

public class add_digits {
    public int addDigits(int num) {
        int result = num;
        while (result >= 10) {
            result = 0;
            while (num != 0) {
                result += num % 10;
                num /= 10;
            }
            num = result;
        }
        return result;
    }
}
