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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        boolean direction = true; //true代表current节点为pre节点的右子节点，否则为左子节点
        TreeNode sentinel = new TreeNode(-1, null, root);
        TreeNode pre = sentinel, current = root;
        while (current != null) {
            pre = current;
            if (current.val > val) {
                direction = false;
                current = current.left;
            } else {
                direction = true;
                current = current.right;
            }
        }
        if (direction) {
            pre.right = new TreeNode(val);
        } else {
            pre.left = new TreeNode(val);
        }
        return sentinel.right;
    }
}