/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftPart = lowestCommonAncestor(root.left, p, q);
        TreeNode rightPart = lowestCommonAncestor(root.right, p, q);
        if (leftPart == null) {
            return rightPart;
        }
        if (rightPart == null) {
            return leftPart;
        }
        return root;
    }
}