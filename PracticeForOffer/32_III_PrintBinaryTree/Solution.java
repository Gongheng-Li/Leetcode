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

    private static final int leftToRight = 0;
    private static final int rightToLeft = 1;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root  == null) {
            return result;
        }
        Queue<TreeNode> fringe = new ArrayDeque<>();
        int direction = leftToRight;
        fringe.add(root);
        while (!fringe.isEmpty()) {
            LinkedList<Integer> presentList = new LinkedList<>();
            int layerLength = fringe.size();
            for (int i = 0; i < layerLength; i++) {
                TreeNode presentNode = fringe.poll();
                if (direction == leftToRight) {
                    presentList.add(presentNode.val);
                } else {
                    presentList.addFirst(presentNode.val);
                }
                if (presentNode.left != null) {
                    fringe.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    fringe.add(presentNode.right);
                }
            }
            direction = 1 - direction;
            result.add(presentList);
        }
        return result;
    }
}