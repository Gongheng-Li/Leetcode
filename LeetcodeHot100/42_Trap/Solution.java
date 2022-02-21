import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int volume = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (!stack.empty()) {
                    volume += (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - height[bottom]);
                }
            }
            stack.push(i);
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        Solution s = new Solution();
        System.out.println(s.trap(heights));
    }
}