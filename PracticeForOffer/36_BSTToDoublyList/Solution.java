/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        } else if (root.left == null || root.right == null) {
            Node partListHead;
            Node resultNode;
            if (root.left == null) {
                partListHead = treeToDoublyList(root.right);
                resultNode = root;
            } else {
                partListHead = treeToDoublyList(root.left);
                resultNode = partListHead;
            }
            root.left = partListHead.left;
            root.right = partListHead;
            root.left.right = root;
            root.right.left = root;
            return resultNode;
        } else {
            Node leftListHead = treeToDoublyList(root.left);
            Node rightListHead = treeToDoublyList(root.right);
            root.left = leftListHead.left;
            root.right = rightListHead;
            leftListHead.left = rightListHead.left;
            rightListHead.left.right = leftListHead;
            root.left.right = root;
            root.right.left = root;
            return leftListHead;
        }
    }
}