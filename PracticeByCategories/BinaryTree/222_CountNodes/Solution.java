public class Solution {

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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int leftDepth = 0, rightDepth = 0;
        while (node != null) {
            node = node.left;
            leftDepth += 1;
        }
        node = root;
        while (node != null) {
            node = node.right;
            rightDepth += 1;
        }
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        }
        int left = (int) Math.pow(2, rightDepth), right = (int) Math.pow(2, leftDepth) - 1;
        int target = left;
        int h = 1 << (rightDepth - 1);
        while (left <= right) {
            int middle = (left + right) / 2;
            if (checkExistence(root, middle, h)) {
                target = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return target;
    }

    private boolean checkExistence(TreeNode root, int index, int h) {
        TreeNode node = root;
        while (h > 0) {
            if ((index & h) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
            h >>= 1;
        }
        return node != null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node6 = s.new TreeNode(6);
        TreeNode node5 = s.new TreeNode(5);
        TreeNode node4 = s.new TreeNode(4);
        TreeNode node3 = s.new TreeNode(3, node6, null);
        TreeNode node2 = s.new TreeNode(2, node4, node5);
        TreeNode node1 = s.new TreeNode(1, node2, node3);

        System.out.println(s.countNodes(node1));
    }
}
