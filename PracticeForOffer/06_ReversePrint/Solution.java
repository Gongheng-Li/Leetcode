/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        return reversePrintHelper(head, 0);
    }

    private int[] reversePrintHelper(ListNode head, int length) {
        if (head == null) {
            return new int[length];
        } else {
            int[] result = reversePrintHelper(head.next, length + 1);
            result[result.length - length - 1] = head.val;
            return  result;
        }
    }
}