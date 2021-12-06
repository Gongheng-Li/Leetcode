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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd) {
            return null;
        }
        int rootVal = preorder[preBegin];
        int rootPos;
        for (rootPos = inBegin; rootPos < inEnd; rootPos++) {
            if (inorder[rootPos] == rootVal) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preBegin + 1, preBegin + 1 + rootPos - inBegin, inorder, inBegin, rootPos);
        root.right = helper(preorder, preBegin + 1 + rootPos - inBegin, preEnd, inorder, rootPos + 1, inEnd);
        return root;
    }
}