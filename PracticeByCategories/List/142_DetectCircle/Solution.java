public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode fast = sentinel, slow = sentinel;
        while (fast != slow || slow == sentinel) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            slow = slow.next;
        }
        ListNode countPtr = sentinel;
        while (slow != countPtr) {
            slow = slow.next;
            countPtr = countPtr.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}