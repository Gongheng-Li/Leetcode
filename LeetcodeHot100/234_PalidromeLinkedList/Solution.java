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
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length += 1;
            ptr = ptr.next;
        }
        ListNode secondHalfHead = head;
        int terminationIndex = 0;
        for (int i = 0; i < length / 2 + length % 2; i++) {
            secondHalfHead = secondHalfHead.next;
        }
        secondHalfHead = invertList(secondHalfHead);
        while (secondHalfHead != null) {
            if (head.val != secondHalfHead.val) {
                return false;
            }
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }

    private ListNode invertList (ListNode head) {
        ListNode current = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
    }
}