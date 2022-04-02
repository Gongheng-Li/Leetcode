import java.util.Arrays;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateEdges(matrix, 1, 0, n);
        return matrix;
    }

    private void generateEdges(int[][] matrix, int offset, int start, int n) {
        if (start > n / 2) {
            return;
        }
        int num = offset;
        for (int i = start; i < n - start; i++) {
            matrix[start][i] = num;
            num += 1;
        }
        for (int i = start + 1; i < n - start; i++) {
            matrix[i][n - start - 1] = num;
            num += 1;
        }
        for (int i = n - start - 2; i > start; i--) {
            matrix[n - start - 1][i] = num;
            num += 1;
        }
        for (int i = n - start - 1; i > start; i--) {
            matrix[i][start] = num;
            num += 1;
        }
        generateEdges(matrix, num, start + 1, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.generateMatrix(4)));
    }
}