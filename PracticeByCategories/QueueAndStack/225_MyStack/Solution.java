import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return exposeLast();
    }

    public int top() {
        int element = exposeLast();
        queue.add(element);
        return element;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private int exposeLast() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }
}
