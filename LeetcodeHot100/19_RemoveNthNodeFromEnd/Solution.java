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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode eliminator = head, pioneer = head;
        for (int i = 0; i < n; i++) {
            pioneer = pioneer.next;
        }
        if (pioneer == null) {
            head = head.next;
        } else {
            while (pioneer.next != null) {
                pioneer = pioneer.next;
                eliminator = eliminator.next;
            }
            eliminator.next = eliminator.next.next;
        }
        return head;
    }
}