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

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) >= 0;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node41 = s.new TreeNode(4);
        TreeNode node42 = s.new TreeNode(4);
        TreeNode node31 = s.new TreeNode(3, node41, node42);
        TreeNode node32 = s.new TreeNode(3);
        TreeNode node21 = s.new TreeNode(2, node31, node32);
        TreeNode node22 = s.new TreeNode(2);
        TreeNode node1 = s.new TreeNode(1, node21, node22);

        System.out.println(s.isBalanced(node1));
    }
}