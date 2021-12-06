import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                swap(matrix, i, j, length - 1 - i, j);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        Solution s = new Solution();
        s.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}