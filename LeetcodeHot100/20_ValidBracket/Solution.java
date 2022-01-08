import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> auxiliaryStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                auxiliaryStack.push(ch);
            } else if (ch == ')') {
                if (auxiliaryStack.empty() || !auxiliaryStack.pop().equals('(')) {
                    return false;
                }
            } else if (ch == ']') {
                if (auxiliaryStack.empty() || !auxiliaryStack.pop().equals('[')) {
                    return false;
                }
            } else if (ch == '}') {
                if (auxiliaryStack.empty() || !auxiliaryStack.pop().equals('{')) {
                    return false;
                }
            }
        }
        return auxiliaryStack.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}]]"));
    }
}