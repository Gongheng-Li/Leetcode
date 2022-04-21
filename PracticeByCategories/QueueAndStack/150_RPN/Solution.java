import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 + op2);
            } else if ("-".equals(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 - op1);
            } else if ("*".equals(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op1 * op2);
            } else if ("/".equals(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(op2 / op1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}