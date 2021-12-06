/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthOfA = 0, lengthOfB = 0;
            ListNode countA = headA, countB = headB;
            while (countA != null) {
                countA = countA.next;
                lengthOfA += 1;
            }
            while (countB != null) {
                countB = countB.next;
                lengthOfB += 1;
            }
            for (int i = 0; i < lengthOfA - lengthOfB; i++) {
                headA = headA.next;
            }
            for (int i = 0; i < lengthOfB - lengthOfA; i++) {
                headB = headB.next;
            }
            while (headA != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
    }
}