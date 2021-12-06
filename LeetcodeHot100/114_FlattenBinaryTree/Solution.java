/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class TreeNode {
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

    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        TreeNode end = root;
        root.left = null;
        if (leftRoot != null) {
            root.right = leftRoot;
            end = helper(leftRoot);
        }
        if (rightRoot != null) {
            end.right = rightRoot;
            end = helper(rightRoot);
        }
        return end;
    }
}