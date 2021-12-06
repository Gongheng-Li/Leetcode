import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode leftNode, TreeNode rightNode) {
            val = x;
            left = leftNode;
            right = rightNode;
        }
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> fringe = new ArrayDeque<>();
        fringe.add(root);
        while (!fringe.isEmpty()) {
            TreeNode node = fringe.poll();
            resultList.add(node.val);
            if (node.left != null) {
                fringe.add(node.left);
            }
            if (node.right != null) {
                fringe.add(node.right);
            }
        }
        int[] result = new int[resultList.size()];
        int size = resultList.size();
        for (int i = 0; i < size; i++) {
            result[i] = resultList.remove(0);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                                            new TreeNode(15), new TreeNode(17)));
        int[] result = levelOrder(null);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}