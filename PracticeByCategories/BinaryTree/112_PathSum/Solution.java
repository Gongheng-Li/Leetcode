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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int currentSum, int targetSum) {
        currentSum += root.val;
        if (root.left == null && root.right == null) {
            return currentSum == targetSum;
        }
        if (root.left != null && dfs(root.left, currentSum, targetSum)) {
            return true;
        }
        if (root.right != null && dfs(root.right, currentSum, targetSum)) {
            return true;
        }
        return false;
    }
}