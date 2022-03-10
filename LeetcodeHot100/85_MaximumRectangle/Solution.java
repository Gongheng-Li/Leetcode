import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] left = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        int maxArea = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] start = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] > left[i][j]) {
                    int popOut = stack.pop();
                    maxArea = Math.max(maxArea, (i - start[popOut] - 1) * left[popOut][j]);
                }
                if (stack.isEmpty()) {
                    start[i] = -1;
                } else {
                    start[i] = stack.peek();
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int popOut = stack.pop();
                maxArea = Math.max(maxArea, (matrix.length - start[popOut] - 1) * left[popOut][j]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                           {'1', '0', '1', '1', '1'},
                           {'1', '1', '1', '1', '1'},
                           {'1', '0', '0', '1', '0'}};
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(matrix));
    }
}