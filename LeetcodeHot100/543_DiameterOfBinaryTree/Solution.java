import java.util.HashMap;
import java.util.Map;

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

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> deepestBranch = new HashMap<>();
        deepestBranch.put(null, 0);
        return diameterOfBinaryTree(root, deepestBranch);
    }

    private int diameterOfBinaryTree(TreeNode root, Map<TreeNode, Integer> deepestBranch) {
        if (root == null) {
            return 0;
        }
        int diameterOfLeft = diameterOfBinaryTree(root.left, deepestBranch);
        int diameterOfRight = diameterOfBinaryTree(root.right, deepestBranch);
        int diameterOfBranch = Math.max(diameterOfLeft, diameterOfRight);
        deepestBranch.put(root, Math.max(deepestBranch.get(root.left), deepestBranch.get(root.right)) + 1);
        return Math.max(diameterOfBranch, deepestBranch.get(root.left) + deepestBranch.get(root.right));
    }
}