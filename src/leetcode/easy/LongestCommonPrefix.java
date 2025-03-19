package leetcode.easy;

/*
https://leetcode.com/problems/longest-common-prefix/description/

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

The time complexity of this approach is O(n log n) due to the sorting operation, where n is the number of strings in the input list.
The space complexity is O(n) for the sorted list.
*/

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minCharLen = Math.min(first.length(), last.length());

        for(int i = 0; i < minCharLen; i++) {
            if(first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }

            sb.append(first.charAt(i));
        }

        return sb.toString();
    }
}
