/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int maxLeft = dfs(root.left);
        int maxRight = dfs(root.right);
        if (maxLeft < 0 && maxRight < 0) {
            maxSum = Math.max(maxSum, root.val);
        } else if (maxLeft < 0) {
            maxSum = Math.max(maxSum, root.val + maxRight);
        } else if (maxRight < 0) {
            maxSum = Math.max(maxSum, root.val + maxLeft);
        } else {
            maxSum = Math.max(maxSum, root.val + maxLeft + maxRight);
        }
        if (maxLeft < 0 && maxRight < 0) {
            return root.val;
        } else {
            return root.val + Math.max(maxLeft, maxRight);
        }
    }
}