class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pioneer = head, eliminator = sentinel;
        for (int i = 0; i < n; i++) {
            pioneer = pioneer.next;
        }
        while (pioneer != null) {
            pioneer = pioneer.next;
            eliminator = eliminator.next;
        }
        eliminator.next = eliminator.next.next;
        return sentinel.next;
    }
}