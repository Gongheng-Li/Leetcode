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

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            TreeNode successor = getSuccessor(node);
            if (successor == null || successor.left == node) {
                sum += node.val;
                node.val = sum;
                if (successor != null) {
                    successor.left = null;
                }
                node = node.left;
            } else {
                successor.left = node;
                node = node.right;
            }
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        if (root == null || root.right == null) {
            return null;
        }
        TreeNode node = root.right;
        while (node.left != null && node.left != root) {
            node = node.left;
        }
        return node;
    }
}