import java.util.Stack;

class CQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        mainStack.push(value);
    }

    public int deleteHead() {
        int result = -1;

        while (!mainStack.empty()) {
            helperStack.push(mainStack.pop());
        }
        if (!helperStack.empty()) {
            result = helperStack.pop();
        }
        while (!helperStack.empty()) {
            mainStack.push(helperStack.pop());
        }
        return result;
    }

    public int deleteHeadUsingOneStack() {
        if (mainStack.size() == 0) {
            return -1;
        } else if (mainStack.size() == 1) {
            return mainStack.pop();
        }
        int temp = mainStack.pop();
        int result = deleteHeadUsingOneStack();
        mainStack.push(temp);
        return result;
    }

    public void appendTailEfficientWay(int value) {
        inStack.push(value);
    }

    public int deleteHeadEfficientWay() {
        if (inStack.empty() && outStack.empty()) {
            return -1;
        } else if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        } else {
            return outStack.pop();
        }
    }
}

/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */