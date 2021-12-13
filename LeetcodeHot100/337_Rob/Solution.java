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

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> robRootCache = new HashMap<>();
        Map<TreeNode, Integer> notRobRootCache = new HashMap<>();
        robRootCache.put(null, 0);
        notRobRootCache.put(null, 0);
        rob(root, robRootCache, notRobRootCache);
        return Math.max(robRootCache.get(root), notRobRootCache.get(root));
    }

    private void rob(TreeNode root, Map<TreeNode, Integer> robRootCache, Map<TreeNode, Integer> notRobRootCache) {
        if (root == null) {
            return;
        }
        rob(root.left, robRootCache, notRobRootCache);
        rob(root.right, robRootCache, notRobRootCache);
        robRootCache.put(root, root.val + notRobRootCache.get(root.left) + notRobRootCache.get(root.right));
        notRobRootCache.put(root, Math.max(robRootCache.get(root.left), notRobRootCache.get(root.left))
                                + Math.max(robRootCache.get(root.right), notRobRootCache.get(root.right)));
    }
}