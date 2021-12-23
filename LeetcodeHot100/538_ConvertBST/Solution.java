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
    public class TreeNode {
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

    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        int sum = 0;
        while (node != null) {
            if (node.right != null) {
                TreeNode successor = getSuccessor(node);
                if (successor.left == null) {
                    successor.left = node;
                    node = node.right;
                } else {
                    successor.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            } else {
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        TreeNode node = root.right;
        while (node.left != null && node.left != root) {
            node = node.left;
        }
        return node;
    }
}