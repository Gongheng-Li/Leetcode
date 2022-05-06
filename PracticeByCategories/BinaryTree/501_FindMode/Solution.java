import java.util.ArrayList;
import java.util.List;

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

    public int[] findMode(TreeNode root) {
        Integer currentNum = null;
        int currentCount = 0, maxCount = 0;
        TreeNode node = root;
        List<Integer> resultList = new ArrayList<>();
        while (true) {
            TreeNode predecessor = getPredecessor(node);
            if (predecessor == null || predecessor.right == node) {
                if (currentNum == null || node.val != currentNum) {
                    currentNum = node.val;
                    currentCount = 1;
                } else {
                    currentCount += 1;
                }
                if (currentCount == maxCount) {
                    resultList.add(currentNum);
                } else if (currentCount > maxCount) {
                    resultList = new ArrayList<>();
                    resultList.add(currentNum);
                    maxCount = currentCount;
                }
                if (predecessor != null) { //根据上层if判断，如果predecessor不为null，那么predecessor.right一定等于node
                    predecessor.right = null;
                }
                node = node.right;
                if (node == null) {
                    int[] result = new int[resultList.size()];
                    for (int i = 0; i < result.length; i++) {
                        result[i] = resultList.get(i);
                    }
                    return result;
                }
            } else {
                predecessor.right = node;
                node = node.left;
            }
        }
    }

    private TreeNode getPredecessor(TreeNode root) {
        if (root == null || root.left == null) {
            return null;
        }
        TreeNode node = root.left;
        while (node.right != null && node.right != root) {
            node = node.right;
        }
        return node;
    }
}