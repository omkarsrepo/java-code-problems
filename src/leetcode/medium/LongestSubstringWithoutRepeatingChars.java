package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Video: https://youtu.be/T-Oj2Ajj9vA?si=nhdXB9_MPrneXCFH&t=161
*/

// TC - O(n)  SC - O(1)

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> charLastPositionMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            Character currChar = s.charAt(right);
            if(charLastPositionMap.containsKey(currChar) && charLastPositionMap.get(currChar) >= left // To update left only when char is present in right side: 'abba'
            ) {
                left = charLastPositionMap.get(currChar) + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            charLastPositionMap.put(currChar, right);
        }

        return maxLen;
    }
}
