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

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE, false, false);
    }

    private boolean helper(TreeNode root, int upperBound, int lowerBound, boolean existsUpperBound, boolean existsLowerBound) {
        if (root == null) {
            return true;
        }
        if (existsLowerBound && root.val <= lowerBound || existsUpperBound && root.val >= upperBound) {
            return false;
        }
        boolean isValidLeftSubtree = true, isValidRightSubtree = true;
        if (root.left != null) {
            isValidLeftSubtree = helper(root.left, Math.min(upperBound, root.val), lowerBound, true, existsLowerBound);
        }
        if (root.right != null) {
            isValidRightSubtree = helper(root.right, upperBound, Math.max(lowerBound, root.val), existsUpperBound, true);
        }
        return isValidLeftSubtree && isValidRightSubtree;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5,
                                       new TreeNode(1),
                                       new TreeNode(4));
        System.out.println(s.isValidBST(root));
    }
}