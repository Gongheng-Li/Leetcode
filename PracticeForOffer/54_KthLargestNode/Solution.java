/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count;
    TreeNode result;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result.val;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (count == 1) {
            result = root;
            count = 0;
            return;
        } else {
            count -= 1;
        }
        dfs(root.left);
    }
}