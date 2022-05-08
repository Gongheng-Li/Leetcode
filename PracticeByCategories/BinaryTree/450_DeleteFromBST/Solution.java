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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode sentinel = new TreeNode(-1, null, root);
        boolean direction = true; //true表示current节点为pre节点的右子节点，否则为左子节点
        TreeNode pre = sentinel, current = root;
        while (current != null) {
            if (current.val > key) {
                pre = current;
                current = current.left;
                direction = false;
            } else if (current.val < key) {
                pre = current;
                current = current.right;
                direction = true;
            } else {
                TreeNode predecessorParent = getPredecessorParent(current);
                if (predecessorParent == null) {
                    if (direction) {
                        pre.right = current.right;
                    } else {
                        pre.left = current.right;
                    }
                } else {
                    if (predecessorParent.equals(current)) {
                        predecessorParent.left.right = predecessorParent.right;
                        if (direction) {
                            pre.right = predecessorParent.left;
                        } else {
                            pre.left = predecessorParent.left;
                        }
                    } else {
                        current.val = predecessorParent.right.val;
                        predecessorParent.right = predecessorParent.right.left;
                    }
                }
                break;
            }
        }
        return sentinel.right;
    }

    private TreeNode getPredecessorParent(TreeNode root) {
        if (root == null || root.left == null) {
            return null;
        }
        TreeNode parent = root, node = root.left;
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        return parent;
    }
}