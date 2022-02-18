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
        PriorityQueue<ListNode> nodes =
                new PriorityQueue<>((Object o1, Object o2) -> ((ListNode) o1).val - ((ListNode) o2).val);
//        nodes.addAll(Arrays.asList(lists));
        for (ListNode list : lists) {
            if (list != null) {
                nodes.add(list);
            }
        }
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        while (!nodes.isEmpty()) {
            ListNode node = nodes.poll();
            current.next = node;
            current = current.next;
            node = node.next;
            if (node != null) {
                nodes.add(node);
            }
        }
        return sentinel.next;
    }
}