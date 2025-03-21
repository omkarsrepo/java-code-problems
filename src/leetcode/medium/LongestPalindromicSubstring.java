package leetcode.medium;

/*
https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Video: https://youtu.be/AKIHWGumagI?si=o3YDtiBlgOblnhtt&t=252
*/

// TC - O(n)^2 SC - 0(1)

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for(int l = 0; l < s.length() - 1; l++) {
            String odd = expandFromCenter(s, l, l);
            String even = expandFromCenter(s, l, l + 1);
            if(odd.length() > maxStr.length()) {
                maxStr = odd;
            }

            if(even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    static String expandFromCenter(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }
}
