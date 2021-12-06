import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        } else if (pushed.length == 0 || popped.length == 0) {
            return false;
        }
        int pushIndex=0, popIndex=0;
        Stack<Integer> helperStack = new Stack<>();
        Set<Integer> checked = new HashSet<>();
        while (popIndex < popped.length) {
            if (helperStack.empty()) {
                helperStack.push(pushed[pushIndex]);
                checked.add(pushed[pushIndex]);
                pushIndex += 1;
            }
            if (checked.contains(popped[popIndex])) {
                if (helperStack.peek() == popped[popIndex]) {
                    helperStack.pop();
                    popIndex += 1;
                } else {
                    return false;
                }
            } else {
                while (helperStack.peek() != popped[popIndex]) {
                    if (pushIndex >= pushed.length) {
                        return false;
                    }
                    helperStack.push(pushed[pushIndex]);
                    checked.add(pushed[pushIndex]);
                    pushIndex += 1;
                }
                helperStack.pop();
                popIndex += 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] possiblePopOrder = {4, 5, 3, 2, 1};
        int[] impossiblePopOrder = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushOrder, possiblePopOrder));
        System.out.println(validateStackSequences(pushOrder, impossiblePopOrder));
    }
}