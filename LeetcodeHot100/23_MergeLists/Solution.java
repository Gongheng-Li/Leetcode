import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return lists[left];
        } else {
            int middle = (left + right) / 2;
            return mergeTwoLists(mergeKLists(lists, left, middle), mergeKLists(lists, middle + 1, right));
        }
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return sentinel.next;
    }
}