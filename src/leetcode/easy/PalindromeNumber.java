package leetcode.easy;

/*
https://leetcode.com/problems/palindrome-number

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

// SC - 0(1) TC - O(log n), where n is the input number. This is because the number of digits in a number n is proportional to log n.

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int num = x, reverse = 0;

        while(num != 0) {
            reverse = (reverse * 10) + (num % 10);

            num = num / 10;
        }

        return reverse == x;
    }
}
