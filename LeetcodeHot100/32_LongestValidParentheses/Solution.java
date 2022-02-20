import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int longestLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    longestLength = Math.max(longestLength, i - stack.peek());
                }
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String parentheses = "(()(()())";
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(parentheses));
    }
}