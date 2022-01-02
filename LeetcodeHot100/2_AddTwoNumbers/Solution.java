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
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode node = sentinel;
        int carryBit = 0;
        while (true) {
            int value = carryBit;
            if (l1 == null && l2 == null) {
                if (carryBit == 1) {
                    node.next = new ListNode(1);
                }
                break;
            } else if (l1 == null) {
                value += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                value += l1.val;
                l1 = l1.next;
            } else {
                value += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (value >= 10) {
                value -= 10;
                carryBit = 1;
            } else {
                carryBit = 0;
            }
            node.next = new ListNode(value);
            node = node.next;
        }
        return sentinel.next;
    }
}