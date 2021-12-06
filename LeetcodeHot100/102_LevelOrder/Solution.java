import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        while (!treeLevel.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int length = treeLevel.size();
            for (int i = 0; i < length; i++) {
                TreeNode currentNode = treeLevel.poll();
                level.add(currentNode.val);
                if (currentNode.left != null) {
                    treeLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    treeLevel.add(currentNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}