import java.util.Stack;

class MinStack {

    Stack<Integer> elementStack;
    Stack<Integer> minStack;

    public MinStack() {
        elementStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        elementStack.push(val);
        if (minStack.empty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}