/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (slow != fast) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        }
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return slow;
    }
}