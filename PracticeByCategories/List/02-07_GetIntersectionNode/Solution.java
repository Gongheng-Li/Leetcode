public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
            if (ptrA == null && ptrB == null) {
                return null;
            }
            if (ptrA == null) {
                ptrA = headB;
            }
            if (ptrB == null) {
                ptrB = headA;
            }
        }
        return ptrA;
    }
}