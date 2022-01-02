import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToBeHotter = new int[temperatures.length];
        daysToBeHotter[temperatures.length - 1] = 0;
        Stack<Integer> monotoneStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!monotoneStack.empty() && temperatures[monotoneStack.peek()] < temperatures[i]) {
                int index = monotoneStack.pop();
                daysToBeHotter[index] = i - index;
            }
            monotoneStack.push(i);
        }
        return daysToBeHotter;
    }

    public static void main(String[] args) {
        int[] temperatures = {30, 60, 90};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));
    }
}