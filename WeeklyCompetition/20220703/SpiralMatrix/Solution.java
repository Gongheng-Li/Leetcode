import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int i = 0, j = 0;
        int direction = 0;
        while (head != null) {
            matrix[i][j] = head.val;
            head = head.next;
            if (direction == 0) {
                j += 1;
                if (j >= n || matrix[i][j] != -1) {
                    direction = 1;
                    j -= 1;
                    i += 1;
                }
            } else if (direction == 1) {
                i += 1;
                if (i >= m || matrix[i][j] != -1) {
                    direction = 2;
                    i -= 1;
                    j -= 1;
                }
            } else if (direction == 2) {
                j -= 1;
                if (j < 0 || matrix[i][j] != -1) {
                    direction = 3;
                    j += 1;
                    i -= 1;
                }
            } else if (direction == 3) {
                i -= 1;
                if (i < 0 || matrix[i][j] != -1) {
                    direction = 0;
                    i += 1;
                    j += 1;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
//        int[] lst = {0, 5, 5, 2, 4, 9, 7, 1, 8, 6, 2, 0, 3};
        int[] lst = {2, 1, 0};
        ListNode head = null;
        for (int num : lst) {
            head = new ListNode(num, head);
        }
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.spiralMatrix(1, 4, head)));
    }
}