package leetcode.easy;

import java.util.Stack;

/*
https://leetcode.com/problems/reverse-only-letters/description/

Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */

// SC - O(n) TC - O(n)

public class ReverseOnlyLetters {
    public String reverseOnlyLetters1(String s) {
        Stack<Character> letters = new Stack<>();

        for(Character c: s.toCharArray()) {
            if(Character.isLetter(c)) {
                letters.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(Character c: s.toCharArray()) {
            if(Character.isLetter(c)) {
                ans.append(letters.pop());
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    public String reverseOnlyLetters2(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while(l < r) {
            if(Character.isLetter(chars[l]) && Character.isLetter(chars[r])) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }

            if(!Character.isLetter(chars[l])) {
                l++;
            }

            if(!Character.isLetter(chars[r])) {
                r--;
            }
        }

        return new String(chars);
    }
}
