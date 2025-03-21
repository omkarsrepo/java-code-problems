package leetcode.medium;

/*
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */

// TC - O(m * nlogn) SC - O(m*n)
// m = each string, n = len of each string = sorting array

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String str = new String(chars);

            if(!mp.containsKey(str)) {
                mp.put(str, new ArrayList<>());
            }

            mp.get(str).add(word);
        }

        return new ArrayList<>(mp.values());
    }
}
