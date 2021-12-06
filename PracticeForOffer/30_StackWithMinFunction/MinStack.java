import java.util.HashMap;
import java.util.Map;

class MinStack {

    private int top;
    private int[] minStack;
    private Map<Integer, Integer> minValues;

    /** initialize your data structure here. */
    public MinStack() {
        top = 0;
        minStack = new int[8];
        minValues = new HashMap<>();
    }

    private void resize(int capacity) {
        int[] newStack = new int[capacity];
        for (int i = 0; i < minStack.length; i++) {
            newStack[i] = minStack[i];
        }
        minStack = newStack;
    }

    public void push(int x) {
        minStack[top] = x;
        if (minValues.isEmpty()) {
            minValues.put(top, x);
        } else {
            int oldMin = minValues.get(top - 1);
            int newMin = Math.min(oldMin, x);
            minValues.put(top, newMin);
        }
        top += 1;
        if (top >= minStack.length) {
            resize(2 * minStack.length);
        }
    }

    public void pop() {
        top -= 1;
        minStack[top] = 0;
        minValues.remove(top);
    }

    public int top() {
        return minStack[top - 1];
    }

    public int min() {
        return minValues.get(top - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */