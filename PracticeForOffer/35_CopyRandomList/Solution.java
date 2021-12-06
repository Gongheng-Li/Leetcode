import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node copyHead = new Node(head.val);
        Node present = head;
        Node copyPresent = copyHead;
        nodeMap.put(head, copyHead);
        while (present.next != null) {
            Node copyNext = new Node(present.next.val);
            copyPresent.next = copyNext;
            present = present.next;
            copyPresent = copyPresent.next;
            nodeMap.put(present, copyPresent);
        }
        present = head;
        copyPresent = copyHead;
        while (present != null) {
            copyPresent.random = nodeMap.get(present.random);
            present = present.next;
            copyPresent = copyPresent.next;
        }
        return copyHead;
    }
}