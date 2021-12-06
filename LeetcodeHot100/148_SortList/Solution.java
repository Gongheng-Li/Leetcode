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

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length += 1;
            ptr = ptr.next;
        }
        return helper(head, length);
    }

    private ListNode helper(ListNode firstHead, int length) {
        if (firstHead == null) {
            return null;
        } else if (firstHead.next == null) {
            return firstHead;
        }
        ListNode secondHeadSearcher = firstHead;
        for (int i = 0; i < length / 2 - 1; i++) {
            secondHeadSearcher = secondHeadSearcher.next;
        }
        ListNode secondHead = secondHeadSearcher.next;
        secondHeadSearcher.next = null;
        firstHead = helper(firstHead, length / 2);
        secondHead = helper(secondHead, length - length / 2);
        ListNode head = new ListNode();
//        if (firstHead.val <= secondHead.val) {
//            head = firstHead;
//            firstHead = firstHead.next;
//        } else {
//            head = secondHead;
//            secondHead = secondHead.next;
//        }
        ListNode ptr = head;
        while (true) {
            if (firstHead == null) {
                ptr.next = secondHead;
                break;
            } else if (secondHead == null) {
                ptr.next = firstHead;
                break;
            }
            if (firstHead.val <= secondHead.val) {
                ptr.next = firstHead;
                firstHead = firstHead.next;
            } else {
                ptr.next = secondHead;
                secondHead = secondHead.next;
            }
            ptr = ptr.next;
        }
        return head.next;
    }
}