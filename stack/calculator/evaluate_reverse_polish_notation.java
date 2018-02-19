/*
*
* 150. Evaluate Reverse Polish Notation
* https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
* ----------------------------------------------------------------------------------------------------------------------
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
* Valid operators are +, -, *, /. Each operand may be an integer or another expression.
*
* Some examples:
*   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
*   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*
* */

package stack.calculator;

import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        int num1, num2;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
