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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode head;
            ListNode l;
            if (l1.val < l2.val) {
                head = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head = new ListNode(l2.val);
                l2 = l2.next;
            }
            l = head;
            while (true) {
                if (l1 == null) {
                    l.next = l2;
                    break;
                } else if (l2 == null) {
                    l.next = l1;
                    break;
                } else {
                    if (l1.val < l2.val) {
                        l.next = new ListNode(l1.val);
                        l = l.next;
                        l1 = l1.next;
                    } else {
                        l.next = new ListNode(l2.val);
                        l = l.next;
                        l2 = l2.next;
                    }
                }
            }
            return head;
        }
    }
}