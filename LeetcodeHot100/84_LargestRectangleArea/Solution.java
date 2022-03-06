import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] startPosition = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
//        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int popOut = stack.pop();
                maxArea = Math.max(maxArea, (i - startPosition[popOut] - 1) * heights[popOut]);
            }
            if (stack.isEmpty()) {
                startPosition[i] = -1;
            } else {
                startPosition[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popOut = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - startPosition[popOut] - 1) * heights[popOut]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(heights));
    }
}