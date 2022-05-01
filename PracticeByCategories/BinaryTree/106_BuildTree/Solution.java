import java.util.ArrayDeque;
import java.util.Deque;

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
        int index = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);
            if (!stack.isEmpty() && stack.peek().val != inorder[index]) {
                stack.peek().right = node;
                stack.push(node);
            } else {
                while (!stack.isEmpty()) {
                    TreeNode popNode = stack.pop();
                    index -= 1;
                    if (stack.isEmpty() || stack.peek().val != inorder[index]) {
                        popNode.left = node;
                        stack.push(node);
                        break;
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution s = new Solution();
        s.buildTree(inorder, postorder);
    }
}