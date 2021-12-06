import java.util.HashMap;
import java.util.Map;

class LRUCache {

    int capacity;
    DeLinkedListNode dummyHead;
    DeLinkedListNode dummyTail;
    Map<Integer, DeLinkedListNode> cacheMap;

    static class DeLinkedListNode {
        int key;
        int value;
        DeLinkedListNode prev;
        DeLinkedListNode next;

        public DeLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dummyHead = new DeLinkedListNode(-1, -1);
        this.dummyTail = new DeLinkedListNode(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        } else {
            DeLinkedListNode targetNode = cacheMap.get(key);
            targetNode.prev.next = targetNode.next;
            targetNode.next.prev = targetNode.prev;
            targetNode.next = dummyHead.next;
            targetNode.prev = dummyHead;
            targetNode.next.prev = targetNode;
            dummyHead.next = targetNode;
            return targetNode.value;
        }
    }

    public void put(int key, int value) {
        if (this.cacheMap.containsKey(key)) {
            DeLinkedListNode targetNode = cacheMap.get(key);
            targetNode.value = value;
            targetNode.prev.next = targetNode.next;
            targetNode.next.prev = targetNode.prev;
            targetNode.next = dummyHead.next;
            targetNode.prev = dummyHead;
            targetNode.next.prev = targetNode;
            dummyHead.next = targetNode;
        } else {
            DeLinkedListNode targetNode = new DeLinkedListNode(key, value);
            targetNode.next = dummyHead.next;
            targetNode.prev = dummyHead;
            targetNode.next.prev = targetNode;
            dummyHead.next = targetNode;
            cacheMap.put(key, targetNode);
            if (cacheMap.size() > capacity) {
                cacheMap.remove(dummyTail.prev.key);
                dummyTail.prev = dummyTail.prev.prev;
                dummyTail.prev.next = dummyTail;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}