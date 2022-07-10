import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

    Set<Integer> removedSet;
    PriorityQueue<Integer> addedBack;
    int next;

    public SmallestInfiniteSet() {
        removedSet = new HashSet<>();
        addedBack = new PriorityQueue<>();
        next = 1;
    }

    public int popSmallest() {
        int removedElement = 0;
        if (!addedBack.isEmpty()) {
            removedElement = addedBack.poll();
        } else {
            removedElement = next;
            next += 1;
        }
        removedSet.add(removedElement);
        return removedElement;
    }

    public void addBack(int num) {
        if (removedSet.contains(num)) {
            removedSet.remove(num);
            addedBack.add(num);
        }
    }
}