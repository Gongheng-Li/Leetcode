import java.util.ArrayList;
import java.util.List;

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
    public static class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode predecessor = getPredecessor(currentNode);
                if (predecessor.right == null) {
                    predecessor.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    predecessor.right = null;
                    result.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            } else {
                result.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    private TreeNode getPredecessor(TreeNode root) {
        TreeNode predecessor = root.left;
        while (predecessor.right != null && predecessor.right != root) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }
}