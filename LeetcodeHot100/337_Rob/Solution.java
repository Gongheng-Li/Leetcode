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
        return rob(root, new HashMap<>());
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int result = 0;
        if (root.left != null && root.right != null) {
            result = Math.max(rob(root.left, cache) + rob(root.right, cache),
                              root.val + rob(root.left.left, cache) + rob(root.left.right, cache)
                                       + rob(root.right.left, cache) + rob(root.right.right, cache));
        } else if (root.left != null) {
            result = Math.max(rob(root.left, cache), root.val + rob(root.left.left, cache) + rob(root.left.right, cache));
        } else if (root.right != null) {
            result = Math.max(rob(root.right, cache), root.val + rob(root.right.left, cache) + rob(root.right.right, cache));
        } else {
            return root.val;
        }
        cache.put(root, result);
        return result;
//        if (canRobRoot) {
//            return Math.max(root.val + rob(root.left, false) + rob(root.right, false),
//                            rob(root.left, true) + rob(root.right, true));
//        } else {
//            return rob(root.left, true) + rob(root.right, true);
//        }
    }
}