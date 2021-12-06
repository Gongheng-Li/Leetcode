import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                LinkedList<Integer> presentList = new LinkedList<>();
                presentList.addFirst(root.val);
                result.add(presentList);
            }
        } else {
            List<List<Integer>> leftList = pathSum(root.left, target - root.val);
            List<List<Integer>> rightList = pathSum(root.right, target - root.val);
            for (List<Integer> subList : leftList) {
                ((LinkedList<Integer>) subList).addFirst(root.val);
                result.add(subList);
            }
            for (List<Integer> subList : rightList) {
                ((LinkedList<Integer>) subList).addFirst(root.val);
                result.add(subList);
            }
        }
        return result;
    }

    /*
    private void pathSumHelper(TreeNode root, int target, List<Integer> presentList, List<List<Integer>> result) {
        presentList.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                result.add(presentList);
            }
        } else {
            if (root.left != null) {
                pathSumHelper(root.left, target - root.val, presentList, result);
            }
        }
    }
     */
}