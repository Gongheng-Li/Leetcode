class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderStart;
        while (inorder[index] != rootVal) {
            index += 1;
        }
        root.left = buildTree(inorder, inorderStart, index - 1, postorder, postorderStart, postorderStart + index - inorderStart - 1);
        root.right = buildTree(inorder, index + 1, inorderEnd, postorder, postorderStart + index - inorderStart, postorderEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution s = new Solution();
        s.buildTree(inorder, postorder);
    }
}