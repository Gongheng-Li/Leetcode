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

    public int minCameraCover(TreeNode root) {
        return dfs(root)[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] result = new int[3];
        result[0] = left[2] + right[2] + 1;
        result[1] = Math.min(result[0], Math.min(left[0] + right[1], left[1] + right[0]));
        result[2] = Math.min(left[1] + right[1], result[0]);
        return result;
    }
}