package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 */

// TC - O(n) SC - O(n)

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1]; // Consider [1, 1, 1] as nums. Since index starts from zero, so for 'nums.length' size will be 0-2 and not 0-3 hence +1 here.
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            int counts = entry.getValue();
            freq[counts].add(entry.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i = freq.length - 1; i >= 0; i--) {
            for(int num: freq[i]) {
                ans[idx] = num;
                idx++;

                if(idx == k) {
                    return ans;
                }
            }
        }

        return new int[0];
    }
}
