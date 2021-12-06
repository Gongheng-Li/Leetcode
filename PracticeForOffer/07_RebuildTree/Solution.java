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
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int count = 0;
        while (inorder[count] != root) {
            count += 1;
        }
        int lengthOfLeft = count;
        int lengthOfRight = preorder.length - count - 1;
        int[] leftPreorder = new int[lengthOfLeft];
        int[] leftInorder = new int[lengthOfLeft];
        int[] rightPreorder = new int[lengthOfRight];
        int[] rightInorder = new int[lengthOfRight];
        for (int i = 0; i < lengthOfLeft; i++) {
            leftPreorder[i] = preorder[i + 1];
            leftInorder[i] = inorder[i];
        }
        for (int i = 0; i < lengthOfRight; i++) {
            rightPreorder[i] = preorder[i + lengthOfLeft + 1];
            rightInorder[i] = inorder[i + lengthOfLeft + 1];
        }
        TreeNode resultTree = new TreeNode(root);
        resultTree.left = buildTree(leftPreorder, leftInorder);
        resultTree.right = buildTree(rightPreorder, rightInorder);
        return resultTree;
    }
}