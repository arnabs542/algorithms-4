/*
*
* 166. Fraction to Recurring Decimal
* https://leetcode.com/problems/fraction-to-recurring-decimal/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
*
* If the fractional part is repeating, enclose the repeating part in parentheses.
*
* For example,
*
* Given numerator = 1, denominator = 2, return "0.5".
* Given numerator = 2, denominator = 1, return "2".
* Given numerator = 2, denominator = 3, return "0.(6)".
*
* 思路：用map的key来存remainder digit，如果重复出现就不再继续加了
*
* */

package math;

import java.util.HashMap;
import java.util.Map;

public class fraction_to_recurring_decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        // edge case 1: 分数的符号
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        // edge case 2: 分数可能会overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();
        result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)) {
            map.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = map.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
}
