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

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        dfs(root, sb, result);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<String> result) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            result.add(sb.toString());
            sb.delete(sb.lastIndexOf(">") + 1, sb.length());
            return;
        }
        sb.append(root.val).append("->");
        if (root.left != null) {
            dfs(root.left, sb, result);
        }
        if (root.right != null) {
            dfs(root.right, sb, result);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.delete(sb.lastIndexOf(">") + 1, sb.length());
    }
}