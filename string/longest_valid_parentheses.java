/*
*
* 32. Longest Valid Parentheses
* https://leetcode.com/problems/longest-valid-parentheses/description/
*
* */

package string;

import java.util.Stack;

public class longest_valid_parentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        s += 'x'; // dummy char at the end,避免最后不会停止的问题
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
            else {
                // 如果stack空了，说明之前的都是valid
                if (stack.isEmpty()) max = Math.max(max, i);
                // 如果stack不空，则从当前char开始计算
                else max = Math.max(max, i - stack.peek() - 1);
                stack.push(i);
            }
        }
        return stack.isEmpty() ? s.length() : max;
    }
}
