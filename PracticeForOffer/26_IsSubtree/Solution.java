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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    private boolean compare(TreeNode t, TreeNode target) {
        if (target == null) {
            return true;
        } else if (t == null) {
            return false;
        }
        return t.val == target.val && compare(t.left, target.left) && compare(t.right, target.right);
    }
}