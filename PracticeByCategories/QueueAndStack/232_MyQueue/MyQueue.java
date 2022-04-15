import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    private Deque<Integer> pushStack, popStack;

    public MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()) {
            move();
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            move();
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void move() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}