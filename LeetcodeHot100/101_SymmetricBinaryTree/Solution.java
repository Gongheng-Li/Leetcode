import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> iterationTool = new LinkedList<>();
        iterationTool.add(root.left);
        iterationTool.add(root.right);
        while (!iterationTool.isEmpty()) {
            TreeNode oneNode = iterationTool.poll();
            TreeNode theOtherNode = iterationTool.poll();
            if (oneNode == null && theOtherNode == null) {
                continue;
            } else if (oneNode == null || theOtherNode == null || oneNode.val != theOtherNode.val) {
                return false;
            }
            iterationTool.add(oneNode.left);
            iterationTool.add(theOtherNode.right);
            iterationTool.add(oneNode.right);
            iterationTool.add(theOtherNode.left);
        }
        return true;
    }
}