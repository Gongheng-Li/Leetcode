import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(' || ch == ']' && stack.pop() != '[' || ch == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((int) '(');
        System.out.println((int) ')');
        System.out.println((int) '[');
        System.out.println((char) 92);
        System.out.println((int) ']');
        System.out.println((int) '{');
        System.out.println((char) 124);
        System.out.println((int) '}');
    }
}