package leetcode.easy;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */

// TC & SC = O(n)

public class ValidParenthesis {
    public boolean isValid(String parens) {
        Stack<Character> stack = new Stack<>();

        for(Character param: parens.toCharArray()) {
            if(param == '(' || param == '{' || param == '[') {
                stack.push(param);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    Character top = stack.peek();
                    if(top == '(' && param == ')' || top == '{' && param == '}' || top == '[' && param == ']') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
