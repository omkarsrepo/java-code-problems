package leetcode.medium;

/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Example 1:
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Example 2:
Input: root = [1,null,2,null,0,3]
Output: 3

Video: https://youtu.be/c31wBDg2aIU?si=y6Vc_mcPTT5v1BcO
*/

// Space complexity: The space complexity is O(H), where H is the height of the tree. In the worst case (unbalanced tree), the recursion stack could go as deep as the height of the tree
// TC - O(n) as we visit each node.

public class MaxDiffNodeAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxDifference = 0;

    int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        calculateDiff(root, root.val, root.val);

        return maxDifference;
    }

    void calculateDiff(TreeNode root, int min, int max) {
        if(root == null) return;

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int currentDifference = Math.max(Math.abs(max - root.val), Math.abs(min - root.val));
        maxDifference = Math.max(maxDifference, currentDifference);

        calculateDiff(root.left, min, max);
        calculateDiff(root.right, min, max);
    }
}
