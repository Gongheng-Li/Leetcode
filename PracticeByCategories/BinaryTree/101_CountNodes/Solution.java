public class Solution {

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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int leftDepth = 0, rightDepth = 0;
        while (node != null) {
            node = node.left;
            leftDepth += 1;
        }
        node = root;
        while (node != null) {
            node = node.right;
            rightDepth += 1;
        }
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        }
        return countNodes(root, rightDepth);
    }

    private int countNodes(TreeNode node, int layers) {
        if (node.left == null) {
            return 1;
        } else if (node.right == null) {
            return 2;
        }
        TreeNode n = node.left;
        int count = 1;
        while (n != null) {
            n = n.right;
            count += 1;
        }
        if (count == layers) {
            return countNodes(node.left, layers - 1) + (int) Math.pow(2, layers - 1);
        } else {
            return countNodes(node.right, layers - 1) + (int) Math.pow(2, layers);
        }
    }
}
