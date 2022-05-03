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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }

    private boolean isValid(TreeNode root, int lowerBound, int upperBound, boolean existsLowerBound, boolean existsUpperBound) {
        if (root == null) {
            return true;
        }
        if (existsLowerBound && root.val <= lowerBound || existsUpperBound && root.val >= upperBound) {
            return false;
        }
        return isValid(root.left, lowerBound, root.val, existsLowerBound, true) &&
                isValid(root.right, root.val, upperBound, true, existsUpperBound);
    }
}