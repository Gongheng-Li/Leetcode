class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.equals(p) || root.equals(q)) {
            return root;
        }
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        if (leftSearch == null) {
            return rightSearch;
        } else if (rightSearch == null) {
            return leftSearch;
        } else {
            return root;
        }
    }
}