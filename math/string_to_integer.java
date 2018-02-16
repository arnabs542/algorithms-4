/*
* 8. String to Integer (atoi)
* https://leetcode.com/problems/string-to-integer-atoi/discuss/
*
* Implement atoi to convert a string to an integer.
*
* Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
* what are the possible input cases.
*
* Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
* gather all the input requirements up front.
*
*
* Requirements for atoi:
*
* The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
* Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
* and interprets them as a numerical value.
*
* The string can contain additional characters after those that form the integral number, which are ignored and
* have no effect on the behavior of this function.
*
* If the first sequence of non-whitespace characters in str is not a valid integral number,
* or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
*
* If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values,
* INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
* */

package math;

public class string_to_integer {
    // discard leading white spaces
    // an optional initial plus or minus sign followed by as many numerical digits as possible
    // ignore non-digit chars
    // if first non-whitespace char is not a digit, return 0
    // out of range: return INT_MAX (2147483647) or INT_MIN (-2147483648)
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int sign = 1, num = 0, i = 0;
        while (str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') sign = str.charAt(i++) == '-' ? -1 : 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10) && str.charAt(i) - '0' > 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = 10 * num + str.charAt(i++) - '0';
        }
        return sign * num;
    }
}
