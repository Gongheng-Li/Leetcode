class MyLinkedList {

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private final Node sentinel;
    private Node tail;
    int length;

    public MyLinkedList() {
        sentinel = new Node(0);
        tail = sentinel;
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        sentinel.next = new Node(val, sentinel.next);
        if (tail == sentinel) {
            tail = sentinel.next;
        }
        length += 1;
    }

    public void addAtTail(int val) {
        tail.next = new Node(val);
        tail = tail.next;
        length += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        } else if (index > length) {
            return;
        }
        Node node = sentinel;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (index == length) {
            tail.next = new Node(val);
            tail = tail.next;
        } else {
            node.next = new Node(val, node.next);
        }
        length += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        Node node = sentinel;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        if (index == length - 1) {
            tail = node;
        }
        length -= 1;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));             //返回3
    }
}