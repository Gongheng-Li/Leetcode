/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pioneer = head;
        ListNode target = head;
        int count = 0;
        while (pioneer != null) {
            pioneer = pioneer.next;
            if (count >= k) {
                target = target.next;
            } else {
                count += 1;
            }
        }
        return target;
    }
}