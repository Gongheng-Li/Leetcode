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

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefixSumSet = new HashMap<>();
        prefixSumSet.put(0, 1);
        return pathSum(root, targetSum, 0, prefixSumSet);
    }

    private int pathSum(TreeNode root, int targetSum, int prefixSum, Map<Integer, Integer> prefixSumSet) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        prefixSum += root.val;
        if (prefixSumSet.containsKey(prefixSum - targetSum)) {
            result += prefixSumSet.get(prefixSum - targetSum);
        }
        prefixSumSet.put(prefixSum, prefixSumSet.getOrDefault(prefixSum, 0) + 1);
        result += pathSum(root.left, targetSum, prefixSum, prefixSumSet);
        result += pathSum(root.right, targetSum, prefixSum, prefixSumSet);
        if (prefixSumSet.get(prefixSum) == 1) {
            prefixSumSet.remove(prefixSum);
        } else {
            prefixSumSet.put(prefixSum, prefixSumSet.get(prefixSum) - 1);
        }
        return result;
    }
}