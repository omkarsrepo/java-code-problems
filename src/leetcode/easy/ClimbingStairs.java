package leetcode.easy;

/*

Dynamic Programming

https://leetcode.com/problems/climbing-stairs/description/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Explanation: https://www.youtube.com/watch?v=Y0lT9Fck7qI

Same as fibonacci Series

 */

// TC - O(N) SC - O(N)

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        return climb(n, mp);
    }

    int climb(int n, Map<Integer, Integer> mp) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(!mp.containsKey(n)) {
            mp.put(n, climb(n - 1, mp) + climb(n - 2, mp));
        }

        return mp.get(n);
    }
}
