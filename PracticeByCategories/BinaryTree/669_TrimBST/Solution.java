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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode sentinel = new TreeNode();
        sentinel.left = root;
        TreeNode pre = sentinel, current = root;
        while (current != null) {
            if (current.val >= low) {
                pre = current;
                current = current.left;
            } else {
                pre.left = current.right;
                current = current.right;
            }
        }
        sentinel.right = sentinel.left;
        pre = sentinel;
        current = sentinel.right;
        while (current != null) {
            if (current.val <= high) {
                pre = current;
                current = current.right;
            } else {
                pre.right = current.left;
                current = current.left;
            }
        }
        return sentinel.right;
    }
}