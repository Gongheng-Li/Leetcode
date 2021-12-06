import java.util.*;

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

    private class Node {
        TreeNode n;
        int layer;
        private Node(TreeNode n, int l) {
            this.n = n;
            layer = l;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layerList = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> fringe = new ArrayDeque<>();
        int layer = 0;
        fringe.add(new Node(root, 0));
        while (!fringe.isEmpty()) {
            Node presentNode = fringe.poll();
            if (presentNode.layer != layer) {
                result.add(layerList);
                layerList = new ArrayList<>();
                layer += 1;
            }
            layerList.add(presentNode.n.val);
            if (presentNode.n.left != null) {
                fringe.add(new Node(presentNode.n.left, presentNode.layer + 1));
            }
            if (presentNode.n.right != null) {
                fringe.add(new Node(presentNode.n.right, presentNode.layer + 1));
            }
        }
        result.add(layerList);
        return result;
    }
}