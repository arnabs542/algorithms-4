/*
*
* 65. Valid Number
* https://leetcode.com/problems/valid-number/description/
* ----------------------------------------------------------------------------------------------------------------------
* Validate if a given string is numeric.
*
* Some examples:
* "0" => true
* " 0.1 " => true
* "abc" => false
* "1 a" => false
* "2e10" => true
*
* */


package string;

public class valid_number {
    /*
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        int i = 0;
        s = s.trim() + " "; // 多加一位，就不需要循环中判断i是否越界
        char[] chars = s.toCharArray();
        int len = s.length() - 1;

        // 1. 判断符号
        if (chars[i] == '+' || chars[i] == '-') i++;

        // 2. 判断浮点数
        int nDigit = 0, nPoint = 0;
        while (Character.isDigit(chars[i]) || chars[i] == '.') {
            if (Character.isDigit(chars[i])) nDigit++;
            if (chars[i] == '.') nPoint++;
            i++;
        }
        if (nDigit <= 0 || nPoint > 1) return false;

        // 3. 判断e
        if (chars[i] == 'e') {
            i++;
            if (chars[i] == '+' || chars[i] == '-') i++;
            if (i == len) return false;
            for (; i < len; i++) {
                if (!Character.isDigit(chars[i])) return false;
            }
        }

        // 4. 最后判断i是否是指向末尾了（即末尾没有非法字符了）
        return i == len;
    }
}
