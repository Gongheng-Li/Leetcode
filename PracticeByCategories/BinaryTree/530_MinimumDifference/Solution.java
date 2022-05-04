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

    public int getMinimumDifference(TreeNode root) {
        boolean existPre = false;
        int pre = 0;
        int minimum = Integer.MAX_VALUE;
        TreeNode node = root;
        while (true) {
            if (node.left == null) {
                if (existPre) {
                    minimum = Math.min(minimum, Math.abs(node.val - pre));
                } else {
                    existPre = true;
                }
                pre = node.val;
                node = node.right;
                if (node == null) {
                    return minimum;
                }
            } else {
                TreeNode predecessor = getPredecessor(node);
                if (predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    if (existPre) {
                        minimum = Math.min(minimum, Math.abs(node.val - pre));
                    } else {
                        existPre = true;
                    }
                    pre = node.val;
                    predecessor.right = null;
                    node = node.right;
                    if (node == null) {
                        return minimum;
                    }
                }
            }
        }
    }

    private TreeNode getPredecessor(TreeNode root) {
        if (root.left == null) {
            return null;
        }
        TreeNode node = root.left;
        while (node.right != null && node.right != root) {
            node = node.right;
        }
        return node;
    }
}