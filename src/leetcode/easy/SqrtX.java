package leetcode.easy;

/*
https://leetcode.com/problems/sqrtx/description/

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

// TC - O(log n) SC - O(1)

public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }

        int l = 1;
        int r = x;

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(m * m == x) {
                return m;
            } else if (m * m > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}
