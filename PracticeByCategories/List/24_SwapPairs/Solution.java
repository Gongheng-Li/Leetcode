class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        while (prev.next != null && prev.next.next != null) {
            ListNode temp = prev.next.next;
            prev.next.next = prev.next.next.next;
            temp.next = prev.next;
            prev.next = temp;
            prev = prev.next.next;
        }
        return sentinel.next;
    }
}