class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int[] result = new int[matrix.length*matrix[0].length];
        int index = 0;
        int layer = 0;
        int m = matrix[0].length, n = matrix.length;
        while (layer < m / 2.0 && layer < n / 2.0) {
            for (int i = layer; i < m - layer; i++) {
                result[index] = matrix[layer][i];
                index += 1;
            }
            if (layer > m / 2 || layer >= n / 2) {
                return result;
            }
            for (int i = layer + 1; i < n - layer; i++) {
                result[index] = matrix[i][m - 1 - layer];
                index += 1;
            }
            if (layer >= m / 2 || layer > n / 2) {
                return result;
            }
            for (int i = m - 2 - layer; i >= layer; i--) {
                result[index] = matrix[n - 1 - layer][i];
                index += 1;
            }
            for (int i = n - 2 - layer; i > layer; i--) {
                result[index] = matrix[i][layer];
                index += 1;
            }
            layer += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2},
                                     {5, 6},
                                   //  {9, 10, 11},
                                     {4, 8}};
        int[] result = spiralOrder(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}