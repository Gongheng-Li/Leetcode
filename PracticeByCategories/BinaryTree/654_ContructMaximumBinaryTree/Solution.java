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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode current = null;
            while (!stack.isEmpty() && stack.peek().val < num) {
                TreeNode pre = stack.pop();
                pre.right = current;
                current = pre;
            }
            stack.push(new TreeNode(num, current, null));
        }
        TreeNode root = null;
        while (!stack.isEmpty()) {
            TreeNode pre = stack.pop();
            pre.right = root;
            root = pre;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution s = new Solution();
        s.constructMaximumBinaryTree(nums);
    }
}