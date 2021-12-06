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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null && rootRight == null) {
            return true;
        } else if (rootLeft == null || rootRight == null) {
            return false;
        } else {
            return rootLeft.val == rootRight.val && isSymmetric(rootLeft.right, rootRight.left)
                    && isSymmetric(rootLeft.left, rootRight.right);
        }
    }
}